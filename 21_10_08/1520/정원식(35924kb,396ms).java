import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길_dfs_dp {
	
	static int M, N;
	static int[] dr = new int[] {-1, 1, 0, 0};	// 상하좌우
	static int[] dc = new int[] {0, 0, -1, 1};
	static int[][] map, dp;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());	// 세로
		N = Integer.parseInt(st.nextToken());	// 가로
		
		map = new int[M][N];
		dp = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[M-1][N-1] = 1;
		dfs(0, 0);
		
		System.out.println(dp[0][0]);
		
	}
	
	private static void dfs(int r, int c) {		
		
		if(r == M-1 && c == N-1)	// 도착점
			return;
		
		if(visited[r][c])	// 방문 지점
			return;
		
		visited[r][c] = true;	// 방문 처리	
		
		
		for(int d = 0; d < 4; d++) {	// 탐색
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr >=0 && nr < M && nc >=0 && nc < N && map[r][c] > map[nr][nc]) {	// 범위체크, 크기비교
				if(dp[nr][nc] != 0) {
					dp[r][c] += dp[nr][nc];
					
//					System.out.println("------");
//					for (int[] i2 : dp) {
//						for (int i : i2) {
//							System.out.print(i + " ");
//						}
//						System.out.println();
//					}
//					System.out.println("------");
					
					continue;
				} else {
					dfs(nr, nc);
					dp[r][c] += dp[nr][nc];
					
//					System.out.println("------");
//					for (int[] i2 : dp) {
//						for (int i : i2) {
//							System.out.print(i + " ");
//						}
//						System.out.println();
//					}
//					System.out.println("------");
					
				}
			}
		}
	}
	
}
