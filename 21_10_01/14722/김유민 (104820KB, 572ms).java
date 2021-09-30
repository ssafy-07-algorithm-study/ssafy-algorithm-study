import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int [][]arr = new int[N][N];
		int [][][]dp = new int[N][N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) dp[i][j][0]=1;
			}
		}
		int nx, ny;
		int []dx = {0,1};
		int []dy = {1,0};
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<3;k++) {
					if(dp[i][j][k]!=0) {	//현재 dp가 0이 아니면
						for(int q=0;q<2;q++) {	//오른쪽-아래 검사
							nx = i+dx[q];
							ny = j+dy[q];
							if(nx>=N || ny>=N) continue;
							if(arr[nx][ny]==k+1 || arr[nx][ny]==k-2) {	//다음 우유일 경우
								dp[nx][ny][arr[nx][ny]] = Math.max(dp[nx][ny][arr[nx][ny]], dp[i][j][k]+1);
							}
							else {	//우유 못 마시는 경우
								dp[nx][ny][k] = Math.max(dp[nx][ny][k], dp[i][j][k]);
							}
						}
					}
				}
			}
		}
		
		int answer= 0;
		for(int k=0;k<3;k++) {
			answer = Math.max(answer, dp[N-1][N-1][k]);
		}
		System.out.println(answer);
	}//main
}
