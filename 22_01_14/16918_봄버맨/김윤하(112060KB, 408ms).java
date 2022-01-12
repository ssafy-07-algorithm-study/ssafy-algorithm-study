package silver.s1_16918_봄버맨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dydx = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int R, C, N;
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[][] board = new int[R][C];
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				if (in.charAt(j) == '.')
					board[i][j] = 0;
				else
					board[i][j] = 2;
			}
		}

		Queue<int[]> q = new LinkedList<>();
		for (int n = 0; n < N-1; n++) {

			if (n % 2 == 0) {
				for (int y = 0; y < R; y++) {
					for (int x = 0; x < C; x++) {
						if (board[y][x] == 0)
							board[y][x] = 1;
						else
							board[y][x]++;
					}
				}
			} else {
				for (int y = 0; y < R; y++) {
					for (int x = 0; x < C; x++) {
						if (board[y][x] == 3) {
							q.add(new int[] { y, x });
						}
						else if (board[y][x] > 0) board[y][x]++;
					}
				}

				while (!q.isEmpty()) {
					int[] item = q.poll();
					int y = item[0];
					int x = item[1];

					board[y][x] = 0;
					for (int m = 0; m < 4; m++) {
						int ny = y + dydx[m][0];
						int nx = x + dydx[m][1];
						if (ny < 0 || ny >= R || nx < 0 || nx >= C)
							continue;

						board[ny][nx] = 0;
					}
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 0)
					sb.append('.');
				else
					sb.append('O');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
