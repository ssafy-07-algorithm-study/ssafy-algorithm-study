import java.awt.Point;
import java.io.*;
import java.util.*;

//	115804	508

public class BOJ_16918_봄버맨 {

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		int[][] bombMap = new int[R][C];

		int sec = 0;

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					bombMap[i][j]++;
				}
			}
		}

		// 1초동안 아무것도 안함
		sec++;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					bombMap[i][j]++;
				}
			}
		}

		while (sec < N) {
			sec++;
			if (sec % 2 == 0) {
				// 폭탄이 설치되어 있지 않은 모든 칸에 폭탄 설치
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						bombMap[i][j]++;
						map[i][j] = 'O';
					}
				}
			} else {
				Queue<Point> q = new LinkedList<Point>();
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						bombMap[i][j]++;
						if (bombMap[i][j] == 4)
							q.offer(new Point(i, j));
					}
				}
				// 3초 지난 폭탄 터짐
				while (!q.isEmpty()) {
					Point cur = q.poll();
					int x = cur.x;
					int y = cur.y;
					map[x][y] = '.';
					bombMap[x][y] = 0;
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
							map[nx][ny] = '.';
							bombMap[nx][ny] = 0;
						}
					}
				}
			}

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
