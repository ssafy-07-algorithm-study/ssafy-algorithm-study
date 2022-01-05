package january.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_4811_알약 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[][] dp = new long[32][32];
		for (int i = 1; i < 31; i++) { // H만 있을 경우
			dp[0][i] = 1;
		}
		for (int w = 1; w < 31; w++) {
			for (int h = 0; h < 30; h++) { // else에서 H가 31일 경우가 나타나므로 29까지로 하고 출력 결과를 dp[N-1][1]로 함.
				if (h == 0) {
					dp[w][h] = dp[w - 1][1];
				} else {
					dp[w][h] = dp[w - 1][h + 1] + dp[w][h - 1];
				}
			}
		}
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			sb.append(dp[N - 1][1] + "\n"); // dp[N][0]과 dp[N-1][1]이 같으므로
		}
		System.out.println(sb);
	}
}
