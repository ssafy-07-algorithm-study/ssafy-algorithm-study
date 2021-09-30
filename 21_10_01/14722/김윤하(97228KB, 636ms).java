package gold.g4_14722_우유도시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][][] dp = new int[N][N][2]; // dp[y][x][] = {먹을 수 있는 최대 우유 갯수, 다음에 먹을 우유 번호};  
		int[][] board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(board[0][0] == 0) {
			dp[0][0][0] = 1;
			dp[0][0][1] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i-1 >= 0) {
					// 우유를 먹을 수 있다면
					if (board[i][j] == dp[i-1][j][1]) {
						dp[i][j][0] = dp[i-1][j][0]+1;
						dp[i][j][1] = (dp[i-1][j][1]+1)%3;
					}
					else {
						dp[i][j][0] = dp[i-1][j][0];
						dp[i][j][1] = dp[i-1][j][1];
					}
				}
				
				if (j-1 >= 0) {
					// 우유를 먹을 수 있다면
					if (board[i][j] == dp[i][j-1][1]) {
						if (dp[i][j][0] < dp[i][j-1][0]+1) {
							dp[i][j][0] = dp[i][j-1][0]+1;
							dp[i][j][1] = (dp[i][j-1][1]+1)%3;
						}
					}
					else {
						if (dp[i][j][0] < dp[i][j-1][0]) {
							dp[i][j][0] = dp[i][j-1][0];
							dp[i][j][1] = dp[i][j-1][1];
						}
					}
				}
			}
		}
//		
		System.out.println(dp[N-1][N-1][0]);
		
	}
}
