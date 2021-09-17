import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []t = new int[N+2];
		int []p = new int[N+2];
		StringTokenizer st;
		int []dp = new int[N+2];
		
		for(int f=1;f<=N;f++) {
			st = new StringTokenizer(br.readLine());
			t[f]=Integer.parseInt(st.nextToken());
			p[f]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=N;i>0;i--) {
			if(t[i]+i>N+1) dp[i]=dp[i+1];
			else {
				dp[i]=Math.max(dp[i+1], dp[i+t[i]]+p[i]);
			}
		}
		System.out.println(dp[1]);
	}//main
}
