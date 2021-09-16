package september.threeweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178_미로탐색 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(N, M, arr);
		System.out.println(arr[N - 1][M - 1]);
	}

	private static void bfs(int N, int M, int[][] arr) {
		int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new int[] { 0, 0, 1 });
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == N - 1 && now[1] == M - 1) // 도착지점 도달
				break;

			for (int i = 0; i < 4; i++) {
				int my = now[0] + dir[i][0];
				int mx = now[1] + dir[i][1];
				int cnt = now[2];
				if (my < 0 || mx < 0 || my >= N || mx >= M || visited[my][mx])
					continue;
				visited[my][mx] = true;
				if (arr[my][mx] != 0) {
					arr[my][mx] = cnt + 1;
					q.offer(new int[] { my, mx, cnt + 1 });
				}
			}
		}
	}

}
