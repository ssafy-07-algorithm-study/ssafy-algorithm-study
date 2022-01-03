import java.awt.Point;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

//	999640	1520
public class BOJ_16954_움직이는미로탈출 {

	static char[][] map;
	static boolean flag;
	static int[] dx = { 0, -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, 0, 1, -1, 1, -1, 0, 1 };
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[8][8];

		for (int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
		}

		q = new ArrayDeque<Point>();

		q.offer(new Point(7, 0));
		flag = false;

		while (!q.isEmpty() && !flag) {
			move();
			downWall();
		}

		if (flag)
			System.out.println("1");
		else
			System.out.println("0");

	}

	private static void move() {
		int qSize = q.size();

		for (int i = 0; i < qSize; i++) {
			Point cur = q.poll();

			if (map[cur.x][cur.y] == '#')
				continue;

			if (cur.x == 0 && cur.y == 7) {
				flag = true;
				return;
			}

			// 욱제 이동
			for (int j = 0; j < 9; j++) {
				int nx = cur.x + dx[j];
				int ny = cur.y + dy[j];

				if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && map[nx][ny] == '.') {
					q.offer(new Point(nx, ny));
				}
			}
		}
	}

	private static void downWall() {
		// 가장 아래
		for (int i = 0; i < 8; i++) {
			map[7][i] = '.';
		}

		// 벽 아래로 내려감
		for (int i = 6; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
//				map[i + 1][j] = map[i][j];
				if (map[i][j] == '#') {
					map[i + 1][j] = '#';
					map[i][j] = '.';
				}
			}
		}

	}
}
