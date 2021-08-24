package argust.fourweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576_토마토 {

	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상우하좌

	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		int[][] arr = new int[N][M];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.offer(new int[] { i, j, 0 });
				}
			}
		}

		// 출력형태 다시 확인 - 0, -1, n

		bfs(N, M, arr, q);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					result = -1;
			}
		}

		System.out.println(sb.append(result));
	}

	private static void bfs(int N, int M, int[][] arr, Queue<int[]> q) {

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			int cnt = now[2];
			result = Math.max(result, cnt);
			for (int i = 0; i < 4; i++) {
				int my = y + dir[i][0];
				int mx = x + dir[i][1];
				if (check(my, mx, N, M) && arr[my][mx] == 0) {
					arr[my][mx] = 1;
					q.offer(new int[] { my, mx, cnt + 1 });
				}
			}
		}
	}

	private static boolean check(int y, int x, int N, int M) {
		if (y < 0 || x < 0 || y >= N || x >= M)
			return false;
		return true;
	}
}
