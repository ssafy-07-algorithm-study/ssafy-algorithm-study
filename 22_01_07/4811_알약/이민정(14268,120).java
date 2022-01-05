import java.io.*;

//	14268	120
public class BOJ_4811_알약 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		long[] dp = new long[31];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= 30; i++) {
			long cnt = 0;

			for (int j = 0; j < i; j++) {
				cnt += dp[j] * dp[i - j - 1];
			}

			dp[i] = cnt;
		}

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			sb.append(dp[N]).append("\n");
		}

		System.out.println(sb);
	}
}
