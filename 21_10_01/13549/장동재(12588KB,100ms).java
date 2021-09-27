package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N + K + 2];
		
		// 이전 이후 기본 이동으로 업데이트
		for (int i = N; i > 0; i--) dp[i - 1] = dp[i] + 1;
		for (int i = N; i <= N + K; i++) dp[i + 1] = dp[i] + 1;
		
		// 이후 순간이동 위치 업데이트
		for (int i = 1; i <= N + K; i++) {
			if (i * 2 > N + K) break;
			dp[i * 2] = Math.min(dp[i], dp[i * 2]);
		}
		
		// 첫번째 재갱신
		for (int i = 1; i <= N + K; i++) {
			if (i % 2 == 0) dp[i] = Math.min(dp[i / 2], Math.min(dp[i + 1] + 1, Math.min(dp[i - 1] + 1, dp[i])));
			else dp[i] = Math.min(dp[i + 1] + 1, Math.min(dp[i - 1] + 1, dp[i]));
		}
		
		// 두번째 재갱신
		for (int i = 1; i <= N + K; i++) {
			if (i % 2 == 0) dp[i] = Math.min(dp[i / 2], Math.min(dp[i + 1] + 1, Math.min(dp[i - 1] + 1, dp[i])));
			else dp[i] = Math.min(dp[i + 1] + 1, Math.min(dp[i - 1] + 1, dp[i]));
		}
		
		System.out.println(dp[K]);
	}
}
