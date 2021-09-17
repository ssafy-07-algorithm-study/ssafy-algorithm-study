import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int []w = new int[N+1];
		int []v = new int[N+1];
		int [][]dp = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(w[i]<=j) {
					dp[i][j]=Math.max(dp[i-1][j], v[i]+dp[i-1][j-w[i]]);
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
	}//main
}
