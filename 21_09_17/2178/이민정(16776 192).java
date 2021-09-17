import java.io.*;
import java.util.*;

//16776	192
public class BOJ_2178_미로탐색 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M;
	static int[][] MAZE;
	static boolean[][] visited;

	static class Loc {
		int x;
		int y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		MAZE = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				MAZE[i][j] = Integer.parseInt(str[j]);
				visited[i][j] = false;
			}
		}

		visited[0][0] = true;
		BFS(0, 0);
		System.out.println(MAZE[N - 1][M - 1]);
	}

	private static void BFS(int x, int y) {
		Queue<Loc> q = new LinkedList<Loc>();
		q.offer(new Loc(x, y));

		while (!q.isEmpty()) {
			Loc cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nextX = cur.x + dx[d];
				int nextY = cur.y + dy[d];

				// 범위 밖이고 방문했던 곳이고 갈수없는곳이면
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;
				if (visited[nextX][nextY] || MAZE[nextX][nextY] == 0)
					continue;

				// 갈수있으면
				q.offer(new Loc(nextX, nextY));
				MAZE[nextX][nextY] = MAZE[cur.x][cur.y] + 1;
				visited[nextX][nextY] = true;
			}
		}
	}
}
