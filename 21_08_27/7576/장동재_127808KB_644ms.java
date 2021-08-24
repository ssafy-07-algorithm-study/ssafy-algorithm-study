package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];

		Queue<int[]> queue = new LinkedList<>();	// 익은 토마토 위치 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) queue.offer(new int[] {i, j, board[i][j]});	// x, y, 상태
			}
		}
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1 ,1};
		
		int day = 0;
		while (!queue.isEmpty()) {	// 큐가 빌때까지
			int[] current = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextX = current[0] + dx[d];
				int nextY = current[1] + dy[d];
				
				if (outOfRange(N, M, nextX, nextY)) continue;	// 범위 넘으면 스킵
				if (board[nextX][nextY] == 0) {
					board[nextX][nextY] = current[2] + 1;	// 영향 받은 토마토 상태는 영향주는 토마토 상태+1
					queue.offer(new int[] {nextX, nextY, current[2] + 1});	// 큐에 새로 추가
				}
			}
			day = current[2] - 1;	// 지난 날짜 업데이트
		}
		
		if (checkZero(board)) System.out.println(-1);	// 영향을 안받은 토마토가 존재하면 -1 리턴
		else System.out.println(day);	// 아니면 날짜 리턴
	}
	// 범위 체크
	public static boolean outOfRange(int N, int M, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == M) return true;
		else return false;
	}
	
	// 안 변한 토마토 체크
	public static boolean checkZero(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) return true;
			}
		}
		return false;
	}
}
