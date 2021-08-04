package argust.oneweek;
// 67596KB 356ms
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1913_달팽이 {

	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상우하좌
	static int cnt = 1;
	static int target, N;
	static int[][] map;
	static int[] result = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		target = Integer.parseInt(in.readLine());
		map = new int[N][N];

		int start = N / 2; // 정중앙
		map[start][start] = cnt++; // 정중앙 1 입력 - 시작점
		solve(start, start, 1, 0); // 시작좌표,일직선횟수, 방향

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
				}
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(result[0]).append(" ").append(result[1]);
		System.out.println(sb);
	}

	// 2번의 방향전환 후 직선의 길이가 1씩 증가.
	private static void solve(int y, int x, int straight, int d) {
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < straight; i++) {
				if (cnt > N * N)
					return;
				y += dir[d][0];
				x += dir[d][1];
				map[y][x] = cnt++;
			}
			d = (d + 1) % 4;
		}
		solve(y, x, straight + 1, d);
	}
}
