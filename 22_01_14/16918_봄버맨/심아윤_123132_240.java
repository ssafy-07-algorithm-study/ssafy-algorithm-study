import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append('O');
				}
				sb.append("\n");
			}
		} else {
			for (int t = 1; t < N; t += 2) {
				boolean[][] visited = new boolean[R][C];
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (visited[i][j])
							continue;
						if (arr[i][j] == '.') {
							arr[i][j] = 'O';
						} else {
							arr[i][j] = '.';
							boom(i, j, arr, visited);
						}
						visited[i][j] = true;
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void boom(int y, int x, char[][] arr, boolean[][] visited) {
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int r = arr.length;
		int c = arr[0].length;
		for (int d = 0; d < 4; d++) {
			int my = y + dir[d][0];
			int mx = x + dir[d][1];
			if (my < 0 || mx < 0 || my >= r || mx >= c)
				continue;
			if ((d == 3 || d == 1) && arr[my][mx] == 'O')
				continue;
			visited[my][mx] = true;
			arr[my][mx] = '.';
		}
	}
}
