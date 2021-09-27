package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while (true) {
			int[][] checked = new int[N][N];	// 인덱스 저장
			
			int index = findArea(board, checked, N, L, R);	// 연결 구역 찾기
			
			if (index == N * N + 1) break;	// 연결된 곳 x
			++day;
		}
		
		System.out.println(day);
	}
	
	public static int findArea(int[][] board, int[][] checked, int N, int L, int R) {
		int index = 1;	// 지역 인덱스
		Map<Integer, Integer> hmap = new HashMap<>();	// 인덱스별 값 저장
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (checked[i][j] != 0) continue;	// 첫방문이 아니면 스킵
				
				int count = 1;
				int tempSum = board[i][j];
				
				Queue<int[]> queue = new LinkedList<>();
				queue.offer(new int[] {i, j});
				checked[i][j] = index;
				
				while (!queue.isEmpty()) {
					int[] current = queue.poll();
					
					for (int d = 0; d < 4; d++) {
						int nextX = current[0] + dx[d];
						int nextY = current[1] + dy[d];
						
						if (outOfRange(N, nextX, nextY) || checked[nextX][nextY] != 0) continue;
						
						int absValue = Math.abs(board[current[0]][current[1]] - board[nextX][nextY]);
						if (absValue >= L && absValue <= R) {
							queue.offer(new int[] {nextX, nextY});
							
							checked[nextX][nextY] = index;
							tempSum += board[nextX][nextY];
							count++;
						}
					}
				}
				hmap.put(index++, tempSum / count);	// 인덱스별 값 저장
			}
		}
		
		if (index != N * N + 1)	// 연결 구역이 있는 경우만 업데이트
			updateArea(board, checked, N, hmap);
		
		return index;
	}
	
	public static void updateArea(int[][] board, int[][] checked, int N, Map<Integer, Integer> hmap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int index = checked[i][j];
				board[i][j] = hmap.get(index);
			}
		}
	}
	
	public static boolean outOfRange(int N, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N) return true;
		return false;
	}
}
