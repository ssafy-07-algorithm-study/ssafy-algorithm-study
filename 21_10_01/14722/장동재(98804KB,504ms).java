package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14722 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {1, 0};	// 동, 남
		int[] dy = {0, 1};	// 동, 남

		int[][][] dp = new int[N][N][2];	// 타겟 우유, 총 갯수
		
		if (board[0][0] == 0) {	// 첫 우유가 딸기우유면 하나씩 올려줌
			dp[0][0][0] = 1;
			dp[0][0][1] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < 2; d++) {
					int nextX = i + dx[d];
					int nextY = j + dy[d];
					
					if (outOfRange(N, nextX, nextY)) continue;
					
					int target = dp[i][j][0];	// 타겟 우유
					if (target == board[nextX][nextY]) {	// 타겟 우유랑 값이 같을 때
						if (dp[nextX][nextY][1] < dp[i][j][1] + 1) {	// 기존 값이 이전값+1 보다 작으면 업데이트
							dp[nextX][nextY][0] = (target + 1) % 3;
							dp[nextX][nextY][1] = dp[i][j][1] + 1;
						} 
					} else {	// 다를 때
						if (dp[nextX][nextY][1] < dp[i][j][1]) {	// 기존 값이 이전값보다 작으면 업데이트
							dp[nextX][nextY][0] = dp[i][j][0];
							dp[nextX][nextY][1] = dp[i][j][1];
						}
					}
				}
			}
		}
		
		System.out.println(dp[N - 1][N - 1][1]);
	}
	
	public static boolean outOfRange(int N, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N) return true;
		return false;
	}
}
