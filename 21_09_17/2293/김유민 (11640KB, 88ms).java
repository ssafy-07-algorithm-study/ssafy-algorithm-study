import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int []dp = new int[k+1];
		int coin=0;
		dp[0]=1;
		for(int i=0;i<n;i++) {
			coin=Integer.parseInt(br.readLine());
			for(int j=1;j<=k;j++) {
				if(j>=coin) dp[j] += dp[j-coin];
			}
		}
		System.out.println(dp[k]);
	}//main
}
