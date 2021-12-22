import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5212_지구온난화 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int R, C;
	static char[][] map, copymap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 2][C + 2];

		for (int i = 0; i < R + 2; i++) {
			for (int j = 0; j < C + 2; j++) {
				map[i][j] = '.';
			}
		}

		for (int i = 1; i <= R; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 1; j <= C; j++) {
				map[i][j] = arr[j - 1];
			}
		}

		copymap = new char[R + 2][C + 2];

		for (int i = 0; i < R + 2; i++) {
			for (int j = 0; j < C + 2; j++) {
				copymap[i][j] = map[i][j];
			}
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (copymap[i][j] == 'X') {
					if (check(i, j) >= 3) {
						map[i][j] = '.';
					}
				}
			}
		}

		int minR, minC, maxR, maxC;
		minR = minC = 10;
		maxR = maxC = 0;

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == 'X') {
					minR = Math.min(minR, i);
					minC = Math.min(minC, j);
					maxR = Math.max(maxR, i);
					maxC = Math.max(maxC, j);
				}
			}
		}

		for (int i = minR; i <= maxR; i++) {
			for (int j = minC; j <= maxC; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static int check(int r, int c) {
		int nr, nc;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (copymap[nr][nc] == '.')
				cnt++;
		}
		return cnt;
	}
}
