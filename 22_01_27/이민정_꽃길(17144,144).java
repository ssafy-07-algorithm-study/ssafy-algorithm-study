import java.io.*;
import java.util.StringTokenizer;

//	17144	144
public class BOJ_14620_꽃길 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static boolean[][] visited;
	static int[][] garden;
	static int N, minCost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		garden = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][N];
		minCost = Integer.MAX_VALUE;
		flower(0, 0, 1);
		System.out.println(minCost);
	}

	private static void flower(int cnt, int cost, int r) {
		if (cnt == 3) {
			minCost = Math.min(cost, minCost);
			return;
		}

		for (int i = r; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (visited[i][j] || !canFlower(i, j))
					continue;

				int c = garden[i][j];
				visited[i][j] = true;
				for (int d = 0; d < 4; d++) {
					visited[i + dx[d]][j + dy[d]] = true;
					c += garden[i + dx[d]][j + dy[d]];
				}
				flower(cnt + 1, cost + c, i);

				visited[i][j] = false;
				for (int d = 0; d < 4; d++) {
					visited[i + dx[d]][j + dy[d]] = false;
				}
			}
		}
	}

	private static boolean canFlower(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int nr = i + dx[d];
			int nc = j + dy[d];
			if (visited[nr][nc]) {
				return false;
			}
		}
		return true;
	}
}
