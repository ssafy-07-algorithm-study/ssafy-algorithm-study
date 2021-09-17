package gold.g5_12865_평범한배낭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] things = new int[N+1][2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[K+1];
		
		for (int i = 1; i <= N; i++) {
			for (int w = K; w >= things[i][0]; w--) {
				dp[w] = Math.max(dp[w], things[i][1] + dp[w-things[i][0]]);
			}
		}
		
		System.out.println(dp[K]);
		
		
	}
}
