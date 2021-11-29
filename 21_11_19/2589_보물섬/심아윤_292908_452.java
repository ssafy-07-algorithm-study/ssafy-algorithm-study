package november.third;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2589_보물섬 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
				if (arr[i][j] == 'L') {
					result = Math.max(bfs(i, j, R, C, arr), result);
				}
			}
		}
		System.out.println(sb.append(result));
	}

	private static int bfs(int y, int x, int R, int C, char[][] arr) {
		int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		boolean[][] visited = new boolean[R][C];
		Queue<Node> q = new LinkedList<>();
		visited[y][x] = true;
		int count = 0;
		q.offer(new Node(y, x, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();
			count = Math.max(count, now.cnt);
			for (int i = 0; i < 4; i++) {
				int my = now.y + dir[i][0];
				int mx = now.x + dir[i][1];
				if (my < 0 || mx < 0 || my >= R || mx >= C || visited[my][mx])
					continue;
				if (arr[my][mx] == 'W')
					continue;
				visited[my][mx] = true;
				q.offer(new Node(my, mx, now.cnt + 1));
			}
		}
		return count;
	}

	static class Node {
		int y, x, cnt;

		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}
}
