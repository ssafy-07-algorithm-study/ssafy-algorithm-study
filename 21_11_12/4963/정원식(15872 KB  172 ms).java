//15872 KB  172 ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	
	static int w, h;
	static int[][] map;
	static int[] dr = {0, 0, 1, -1, -1, 1, -1, 1};
	static int[] dc = {1, -1, 0, 0, -1, 1, 1, -1};
	static boolean[][] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			cnt = 0;			
			st = new StringTokenizer(br.readLine(), " ");			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h==0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						walk(i, j);
						cnt++;
					}
				}
			}			
			System.out.println(cnt);
		} 
	}
	
	public static void walk(int r, int c) {
		
		visited[r][c] = true;
		
		for(int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
			
			if(map[nr][nc] == 1 && !visited[nr][nc]) walk(nr, nc);
		}		
	}
}
