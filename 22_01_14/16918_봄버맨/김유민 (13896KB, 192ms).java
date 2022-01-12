import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int [][]arr = new int[R][C];
		int []dx = {1,-1,0,0};
		int []dy = {0,0,1,-1};
		int nx=0; int ny=0;
		for(int i=0;i<R;i++) {
			String tmp = br.readLine();
			for(int j=0;j<C;j++) {
				if(tmp.charAt(j)=='O') arr[i][j]=3;
			}
		}
		
		for(int t=1;t<=N;t++) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(t%2==0) {
						if(arr[i][j]==0) arr[i][j]=t+3;
					}
					if(t%2==1) {
						if(arr[i][j]==t) {
							arr[i][j]=0;
							for(int q=0;q<4;q++) {
								nx = i+dx[q];
								ny = j+dy[q];
								if(nx<0 || ny<0 || nx>=R|| ny>=C) continue;
								if(arr[nx][ny]!=t) arr[nx][ny] = 0;
							}
						}
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]==0) sb.append('.');
				else sb.append('O');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
