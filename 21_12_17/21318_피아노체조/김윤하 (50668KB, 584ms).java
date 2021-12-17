package silver.s2_21318_피아노체조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] acBo = new int[N+1], dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			acBo[i] = Integer.parseInt(st.nextToken());
			
			if (i > 1) {
				if (acBo[i] < acBo[i-1]) 
					dp[i] ++;
				dp[i] += dp[i-1];
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		int Q = Integer.parseInt(br.readLine());
		while(Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int q1 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			answer.append(dp[q2] - dp[q1]).append("\n");
		}
		
		System.out.println(answer.toString());
		
		
		
		
	}
}
