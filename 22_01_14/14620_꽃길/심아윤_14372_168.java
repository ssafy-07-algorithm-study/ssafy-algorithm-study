package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14620_꽃길 {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean[][] visited; // 겹침 방지

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				visited = new boolean[N][N];
				stateSearch(1, 0, i, j, N, visited, arr, dir);
			}
		}

		System.out.println(min);
	}

	private static void stateSearch(int cnt, int sum, int y, int x, int N, boolean[][] visited, int[][] arr,
			int[][] dir) {
		if (cnt > 3) { // 3개의 씨앗 모두 자리를 선택하면 연산 끝
			min = Math.min(min, sum);
			return;
		}
		for (int i = y; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if ((i == y && j < x) || visited[i][j]) // 이전 위치는 고려하지 않기 위해, 방문처리 - 꽃잎의 겹침 방지
					continue;
				int now = 0; // 현재 위치에서의 비용
				visited[i][j] = true;
				now += arr[i][j];
				boolean flag = true;
				for (int d = 0; d < 4; d++) { // 4방향 꽃잎
					int my = i + dir[d][0];
					int mx = j + dir[d][1];
					if (visited[my][mx]) { // 겹치면 방문처리 원상복구
						visited[i][j] = false; // 꽃술 방문처리 복구
						flag = false;
						for (int k = 0; k < d; k++) {
							int dy = i + dir[k][0];
							int dx = j + dir[k][1];
							visited[dy][dx] = false;
						}
						break;
					}
					visited[my][mx] = true;
					now += arr[my][mx];
				}
				if (flag) { // 꽃잎 모두 안전한 자리를 잡았다면
					stateSearch(cnt + 1, sum + now, i, j, N, visited, arr, dir); // 다음 꽃잎
					visited[i][j] = false; // 꽃술 방문처리 복구
					for (int d = 0; d < 4; d++) { // 4방향 꽃잎 방문처리 복구
						int my = i + dir[d][0];
						int mx = j + dir[d][1];
						visited[my][mx] = false;
					}
				}
			}
		}

	}
}
