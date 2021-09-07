package september.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2508_사탕박사고창영 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[][] arr = new char[R][C];
			for (int i = 0; i < R; i++) {
				String str = in.readLine();
				for (int j = 0; j < C; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			int result = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] == 'v' || arr[i][j] == '>') {
						if (candy(i, j, R, C, arr)) {
							result++;
						}
					}
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}

	private static boolean candy(int y, int x, int R, int C, char[][] arr) {
		if (arr[y][x] == '>') { // 우
			for (int i = 0; i < 2; i++) {
				int my = y + 0;
				int mx = x + 1;
				if (!isArea(my, mx, R, C))
					return false;
				if (i == 0 && arr[my][mx] == 'o') {
					y = my;
					x = mx;
					continue;
				} else if (i == 1 && arr[my][mx] == '<') {
					return true;
				} else
					return false;
			}

		} else if (arr[y][x] == 'v') { // 하
			for (int i = 0; i < 2; i++) {
				int my = y + 1;
				int mx = x + 0;
				if (!isArea(my, mx, R, C))
					return false;
				if (i == 0 && arr[my][mx] == 'o') {
					y = my;
					x = mx;
					continue;
				} else if (i == 1 && arr[my][mx] == '^') {
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	private static boolean isArea(int y, int x, int R, int C) {
		if (y < 0 || x < 0 || y >= R || x >= C)
			return false;
		return true;
	}
}
