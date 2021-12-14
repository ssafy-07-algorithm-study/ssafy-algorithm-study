import java.io.*;

//	14264	128

public class BOJ_2193_이친수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[N + 1];

		if (N < 3) {
			System.out.println(1);
		} else {
			dp[1] = dp[2] = 1;
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i - 2] + dp[i - 1];
			}
			System.out.println(dp[N]);
		}
	}
}
