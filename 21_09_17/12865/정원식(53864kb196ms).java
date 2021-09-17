import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] things = new int[N+1][2];	// 0: 무게, 1: 가치
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 2; j++) {
				things[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			
			for(int k = 1; k <= K; k++) {
				
				if( things[i][0] <= k ) {
					dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k - things[i][0]] + things[i][1]);
				} else {
					dp[i][k] = dp[i-1][k];
				}
				
			}
			
		}
		
		System.out.println(dp[N][K]);
		
	}
	
//	public static void recur(int n, int k, int v) {
//		
//		if(n == N) {
//			max = Math.max(max, v);
//			return;
//		}
//		
//		recur(n+1, k, v);
//		if(things[n][0] <= k) {
//			recur(n+1, k - things[n][0], v + things[n][1]);
//		}
//	}
}
