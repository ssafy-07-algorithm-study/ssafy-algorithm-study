package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5547 {
	/*
	 * 체크 할 방향 :
	 * 		- 왼쪽 위, 오른쪽 위, 왼쪽, 오른쪽, 왼쪽 아래, 오른쪽 아래 (6방향)
	 * 		- 각 방향이 0이거나 outOfRange일 경우 + 1
	 * 			- 건물로 둘러쌓인 부분은 제외
	 * 
	 * 		- row가 짝수일 때 :
	 * 			- 바로 아래가 왼쪽 아래, 오른쪽 아래가 오른쪽 아래
	 * 			- 바로 위가 왼쪽 위, 오른쪽 위가 오른쪽 위
	 * 		- row가 홀수일 때 :
	 * 			- 왼쪽 아래가 왼쪽 아래, 바로 아래가 오른쪽 아래
	 * 			- 왼쪽 위가 왼쪽 위, 바로 위가 오른쪽 위
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());	// 열, 행
		int[][] houses = new int[H][W];	// 보드 선언
		
		// 보드 업데이트
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				houses[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 안쪽 블록 채우기
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (houses[i][j] == 0) fillInnerBlock(houses, new boolean[H][W], H, W, i, j);
			}
		}
		
		// 외곽 갯수 세기
		int answer = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (houses[i][j] == 1) answer += checkOutLine(houses, H, W, i, j);
			}
		}
		
		System.out.println(answer);
	}
	
	// 바깥과 연결되지 않은 블록 채우기
	private static void fillInnerBlock(int[][] houses, boolean[][] checked, int H, int W, int x, int y) {
		int[] dx = {-1, -1, 0, 1, 1, 0};		// 왼쪽 위부터 시계방향으로 체크
		int[] dy = new int[6];			// 짝수 기준 dy
		
		boolean flag = false;	// 뚫려있는지 체크하기 위해
		
		Queue<int[]> queue = new LinkedList<>();	// bfs 돌기
		List<int[]> list = new ArrayList<>();	// 지금까지 들어온 좌표 리스트 담기
		
		// 시작점 추가
		queue.offer(new int[] {x, y});
		list.add(new int[] {x, y});
		checked[x][y] = true;
		
		while (!queue.isEmpty()) {	// bfs 시작
			int[] current = queue.poll();
			
			if (current[0] % 2 == 1) dy = new int[]{-1, 0, 1, 0, -1, -1};	// 행이 홀수일 때
			else dy = new int[] {0, 1, 1, 1, 0, -1};	// 행이 짝수일 때
			
			for (int d = 0; d < 6; d++) {
				int nextX = current[0] + dx[d];
				int nextY = current[1] + dy[d];
				
				if (outOfRange(H, W, nextX, nextY)) {	// 뚫려있는거니까 flag on
					flag = true;
					continue;
				}
				
				if (!checked[nextX][nextY] && houses[nextX][nextY] == 0) {	// 처음가는 뚫린 곳일 때
					checked[nextX][nextY] = true;	// 간 것 체크
					queue.offer(new int[] {nextX, nextY});	// 큐에 넣고
					list.add(new int[] {nextX, nextY});	// 리스트에 넣고
				}
			}
		}
		
		if (!flag) {	// 둘러쌓인 곳이면 모두 1로 변경
			for (int i = 0; i < list.size(); i++) {
				int[] current = list.get(i);
				houses[current[0]][current[1]] = 1;
			}
		} else {	// 뚫린 곳이면 모두 2로 변경
			for (int i = 0; i < list.size(); i++) {
				int[] current = list.get(i);
				houses[current[0]][current[1]] = 2;
			}
		}
	}
	
	// 외곽 개수 체크
	private static int checkOutLine(int[][] houses, int H, int W, int x, int y) {
		int count = 0;
		int[] dx = {-1, -1, 0, 1, 1, 0};		// 왼쪽 위부터 시계방향으로 체크
		int[] dy = {0, 1, 1, 1, 0, -1};			// 짝수 기준 dy
		
		if (x % 2 == 1)	dy = new int[]{-1, 0, 1, 0, -1, -1};	// 홀수일 때는 새로 바꿔주고
		
		for (int d = 0; d < 6; d++) {
			int nextX = x + dx[d];
			int nextY = y + dy[d];
			
			if (outOfRange(H, W, nextX, nextY) || houses[nextX][nextY] == 2) count++;	// 범위를 벗어나는 면이거나 뚫린 면일 때 카운팅
		}
		
		return count;
	}
	
	// 범위를 넘어나는지 체크
	private static boolean outOfRange(int H, int W, int x, int y) {
		if (x < 0 || y < 0 || x == H || y == W) return true;
		return false;
	}
}
