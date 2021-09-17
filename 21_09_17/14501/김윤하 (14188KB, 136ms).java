package silver.s4_14501_퇴사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] sangDam = new int[N+1][2]; // 0: 기간 , 1: 금액
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			sangDam[i][0] = T;
			sangDam[i][1] = P;
		}
		
		int[] dp = new int[N+5]; // T가 최대 5일이라서
		int answer = 0;
		
		for (int i = 0 ; i < N+1; i++) {
			int nextDay = i + sangDam[i][0];
			
			dp[i] = Math.max(dp[i], answer);
			dp[nextDay]= Math.max(dp[i] + sangDam[i][1], dp[nextDay]);
			
			answer = dp[i];
		}
		
		System.out.println(answer);
		
		for (int i = 0 ; i < N+1; i++) {
			System.out.println(dp[i]);
		}
	}
}
