import java.io.*;
import java.util.*;

//	15060	144
public class BOJ_1726_로봇 {
	static class Robot {
		int r, c, dir, cnt;

		public Robot(int r, int c, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}

	}

	static int N, M, map[][];
	static boolean visited[][][];
	static Robot start, end;
	static int[] dr = { 0, 0, 0, 1, -1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][5];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		start = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), 0);
		st = new StringTokenizer(br.readLine(), " ");
		end = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), 0);

		System.out.println(move());
	}

	private static int move() {
		Queue<Robot> q = new LinkedList<Robot>();
		q.offer(start);
		visited[start.r][start.c][start.dir] = true;

		while (!q.isEmpty()) {
			Robot cur = q.poll();

			int r = cur.r;
			int c = cur.c;
			int dir = cur.dir;
			int cnt = cur.cnt;

			if (r == end.r && c == end.c && dir == end.dir) {
				return cnt;
			}

			// 회전
			if (dir == 1 || dir == 2) {
				if (!visited[r][c][4]) {
					q.offer(new Robot(r, c, 4, cnt + 1));
					visited[r][c][4] = true;
				}
				if (!visited[r][c][3]) {
					q.offer(new Robot(r, c, 3, cnt + 1));
					visited[r][c][3] = true;
				}
			} else if (dir == 3 || dir == 4) {
				if (!visited[r][c][2]) {
					q.offer(new Robot(r, c, 2, cnt + 1));
					visited[r][c][2] = true;
				}
				if (!visited[r][c][1]) {
					q.offer(new Robot(r, c, 1, cnt + 1));
					visited[r][c][1] = true;
				}
			}

			// 직진
			for (int i = 1; i <= 3; i++) {
				int nr = r + (dr[dir] * i);
				int nc = c + (dc[dir] * i);

				if (nr > 0 && nr <= N && nc > 0 && nc <= M && !visited[nr][nc][dir]) {
					if (map[nr][nc] == 1)
						break;
					q.offer(new Robot(nr, nc, dir, cnt + 1));
					visited[nr][nc][dir] = true;
				}

			}
		}

		return -1;
	}

}
