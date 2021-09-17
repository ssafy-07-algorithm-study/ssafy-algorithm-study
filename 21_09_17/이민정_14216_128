import java.io.*;
import java.util.StringTokenizer;

//14216	128
public class BOJ_14501_퇴사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] schedule = new int[N + 5][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			schedule[i][0] = Integer.parseInt(st.nextToken()); // 걸리는 시간
			schedule[i][1] = Integer.parseInt(st.nextToken()); // 받는 금액
		}

		int maxPay = 0;
		int dp[] = new int[N + 5];

		for (int i = 1; i <= N + 1; i++) {
			dp[i] = Math.max(dp[i], maxPay);
			if (schedule[i][0] + i <= N + 1)
				dp[schedule[i][0] + i] = Math.max(dp[schedule[i][0] + i], schedule[i][1] + dp[i]);
			maxPay = Math.max(dp[i], maxPay);
		}

		System.out.println(maxPay);
	}
}
