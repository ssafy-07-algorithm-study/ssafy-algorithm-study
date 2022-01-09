package october.oneweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1520_내리막길 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M][N];
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int[][] visited = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1; // 방문되지 않을 시
			}
		}
		System.out.println(dfs(0, 0, M, N, arr, dir, visited));
	}

	private static int dfs(int y, int x, int M, int N, int[][] arr, int[][] dir, int[][] visited) {
		if (y == M - 1 && x == N - 1) // 도착지점 도착
			return 1;

		if (visited[y][x] == -1) { // 미방문(-1)일 때
			visited[y][x] = 0; // 방문 표시
			for (int i = 0; i < 4; i++) {
				int my = y + dir[i][0];
				int mx = x + dir[i][1];
				if (my < 0 || mx < 0 || my >= M || mx >= N)
					continue;
				if (arr[my][mx] < arr[y][x]) { // 더 낮은 위치의 조건 만족 시
					visited[y][x] += dfs(my, mx, M, N, arr, dir, visited);
				}
			}
		}
		// 이미 방문 기록이 있다면 (visited[y][x] != 0) or 미방문 처리 후
		return visited[y][x];
	}

}
