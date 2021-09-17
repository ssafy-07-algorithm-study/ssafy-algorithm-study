package silver.s1_2293_동전1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		
		// dp에 n번 반복을 돌림
		// dp[i] = n번째 동전까지 쓰고 i금액을 달성하는 서로다른 가짓 수
		// 1차원으로 되는 이유 : 어차피 n번째의 dp[i] = n-1번째까지의 dp[i] + n번째 dp[i-coins[i]] 니까
		// 1차원으로 하면 n-1번째 까지의 dp[i]는 자동으로 더한 셈이고, n번째 dp[i-coins[i]]만 해주면 되는것
		// 어렵당....
		
		int[] dp = new int[k+1];
		
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			
		}
		
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				dp[j] += dp[j - coins[i]];
			}
				
				//이거 출력해보면 이해감
				for (int a = 1; a <= k; a++) {
					System.out.print(dp[a] + " ");
				}
				System.out.println();
		}
		
		

		System.out.println(dp[k]);
	}
}
