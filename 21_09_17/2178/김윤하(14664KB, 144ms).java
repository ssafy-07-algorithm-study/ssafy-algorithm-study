package silver.s1_2178_미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dydx = new int[][] { {0,1}, {1,0}, {0,-1}, {-1,0} };
		boolean[][] visited = new boolean[N][M];
		char[][] board = new char[N][M];
		
		for (int i = 0; i < N; i++)
			board[i] = br.readLine().toCharArray();
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int cost = cur[2];
			
			if (y == N-1 && x == M-1) {
				System.out.println(cost);
				return;
			}
			visited[y][x] = true;
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dydx[k][0];
				int nx = x + dydx[k][1];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]
					&& board[ny][nx] == '1')
					q.offer(new int[] {ny, nx, cost+1});
			}
		}
	}
}
