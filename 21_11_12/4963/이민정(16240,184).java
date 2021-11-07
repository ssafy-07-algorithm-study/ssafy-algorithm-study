import java.awt.Point;
import java.io.*;
import java.util.*;

//16240	184
public class BOJ_4963_섬의개수 {

	static int H, W, island;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			W = Integer.parseInt(st.nextToken()); // 너비
			H = Integer.parseInt(st.nextToken()); // 높이

			// w와 h가 둘 다 0이면 종료
			if (W == 0 && H == 0)
				break;

			island = 0; // 섬의 개수
			map = new int[H][W];
			visited = new boolean[H][W];

			// 0 : 바다
			// 1 : 땅
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) { // 땅이면
						islandCheck(i, j);
						island++;
					}
				}
			}

			sb.append(island).append("\n");
		}
		System.out.println(sb);
	}

	private static void islandCheck(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();

		q.add(new Point(x, y));
		visited[x][y] = true;
		map[x][y] = 0; // 0으로 바꾸기

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 8; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny] && map[nx][ny] == 1) {
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
					map[nx][ny] = 0;
				}
			}
		}
	}
}
