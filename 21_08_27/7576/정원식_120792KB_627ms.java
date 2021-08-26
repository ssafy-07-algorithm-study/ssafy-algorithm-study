package silver_7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int res;
	static int[] dr = new int[] {-1, 1, 0, 0 };	// 상 하 좌 우
	static int[] dc = new int[] {0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					cnt++;
			}
		}
		
		if(cnt == M*N) {
			System.out.println(0);
		}else {
			bfs(map, N, M);
			System.out.println(res);
		}
	}
	
	static void bfs(int[][] map, int n, int m) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}		
		while(!q.isEmpty()) {
			int qSize = q.size();			
			// 레벨 순회
			for(int i = 0; i < qSize; i++) {				
				int[] pos = q.poll();				
				for(int d = 0; d < 4; d++) {	// 사방 탐색
					// outOfIndex 체크
					// -1, 1 체크
					int nr = pos[0] + dr[d];
					int nc = pos[1] + dc[d];					
					if(nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if(map[nr][nc] == -1 || map[nr][nc] == 1)
						continue;
					map[nr][nc] = 1;
					q.offer(new int[] {nr, nc});					
				}				
			}
			res++; // 하루 지남
		}
		res--;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0)
					res = -1;
			}
		}
	}
}
