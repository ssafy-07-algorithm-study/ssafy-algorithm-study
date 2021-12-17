package silver.s3_2193_이친수;

import java.io.InputStreamReader;

import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] dp = new long[90];
		
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 1; dp[1] = 1;
		for (int i = 2; i < N; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		System.out.println(dp[N-1]);
		
	}
}
