import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	//1520
	public static int M, N;
	public static int [][]arr, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		dp = new int[M][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		dfs(0, 0);
		System.out.println(dp[0][0]);
	}//main
	public static int dfs(int x, int y) {
		if(x==M-1 && y==N-1) return 1;
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		int nx, ny;
		if(dp[x][y]!= -1) return dp[x][y];
		dp[x][y]=0;
		for(int i=0;i<4;i++) {
			nx = dx[i]+x;
			ny = dy[i]+y;
			if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
			
			if(arr[x][y]>arr[nx][ny]) dp[x][y] += dfs(nx, ny);
		}
		return dp[x][y];
	}
}
