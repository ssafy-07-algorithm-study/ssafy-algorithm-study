package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14466_소가길을건너간이유6 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		boolean[][][] map = new boolean[N][N][4]; // 길의 위치 여부 - 4방향 : 상하좌우 순
		// 길의 방향 여부
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			if (x1 == x2 && y1 > y2) { // 서로의 방향이 상대적이므로 둘 다 표시해주어야 함.
				map[y1][x1][0] = true; // 상
				map[y2][x2][1] = true; // 하
			} else if (x1 == x2 && y1 < y2) {
				map[y1][x1][1] = true;
				map[y2][x2][0] = true;
			} else if (y1 == y2 && x1 > x2) {
				map[y1][x1][2] = true;
				map[y2][x2][3] = true;
			} else if (y1 == y2 && x1 < x2) {
				map[y1][x1][3] = true;
				map[y2][x2][2] = true;
			}
		}
		List<Node> cow = new ArrayList<>(); // 소의 위치
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			cow.add(new Node(y, x));
		}

		int cnt = 0; // 만날 수 없는 소의 쌍

		for (int i = 0; i < K; i++) { // 출발 소
			for (int j = i + 1; j < K; j++) { // 도착 소
				if (!bfs(i, j, map, N, cow)) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

	// 길을 건너지 않고 출발 소가 도착 소의 위치에 도착해 만날 수 있는지 여부
	private static boolean bfs(int start, int end, boolean[][][] map, int N, List<Node> cow) {
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
		boolean[][] visited = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();
		int y = cow.get(start).y; // 출발 소
		int x = cow.get(start).x;
		visited[y][x] = true;
		q.offer(new Node(y, x));
		int ey = cow.get(end).y; // 도착 소
		int ex = cow.get(end).x;
		while (!q.isEmpty()) {
			Node now = q.poll();
			y = now.y;
			x = now.x;
			for (int i = 0; i < 4; i++) {
				if (map[y][x][i]) // 길이 존재하면 X
					continue;
				int my = y + dir[i][0];
				int mx = x + dir[i][1];
				if (my < 0 || mx < 0 || my >= N || mx >= N || visited[my][mx])
					continue;
				if (my == ey && mx == ex) // 도착 소와 만나면
					return true;
				visited[my][mx] = true;
				q.offer(new Node(my, mx));
			}
		}
		return false; // 길을 건너지 않고 만날 수 없는 경우
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
