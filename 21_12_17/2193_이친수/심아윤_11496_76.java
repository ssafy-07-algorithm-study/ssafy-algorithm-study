package december.third;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2193_이친수 {

	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[][] dp = new long[N][2];
		dp[0][0] = 0;
		dp[0][1] = 1;
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}
		System.out.println(dp[N - 1][0] + dp[N - 1][1]);
	}

}
