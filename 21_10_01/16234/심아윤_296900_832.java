package september.fiveweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16234_인구이동 {

	static int result;
	static boolean[][] visited;
	static List<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = -1; // 총 결과값

		int cnt = 1;
		while (cnt > 0) { // 더이상 인구 이동이 존재하지 않을 때까지
			count++;
			visited = new boolean[N][N];
			cnt = bfs(arr, N, L, R); // 인구이동이 존재하지 않았다면 break;
		}

		System.out.println(sb.append(count));
	}

	private static int bfs(int[][] arr, int N, int L, int R) {
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int move = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				list = new ArrayList<int[]>(); // 인구이동계산 - 하나의 연합이 시작될 때 초기화
				Queue<int[]> q = new LinkedList<int[]>();
				q.offer(new int[] { i, j });
				list.add(new int[] { i, j });
				visited[i][j] = true;
				int sum = arr[i][j]; // 인구이동계산
				while (!q.isEmpty()) {
					int[] now = q.poll();
					int a = now[0];
					int b = now[1];
					for (int k = 0; k < 4; k++) {
						int my = a + dir[k][0];
						int mx = b + dir[k][1];
						if (!isArea(my, mx, N) || visited[my][mx])
							continue;
						if (Math.abs(arr[a][b] - arr[my][mx]) < L || Math.abs(arr[a][b] - arr[my][mx]) > R)
							continue;
						visited[my][mx] = true;
						sum += arr[my][mx];
						q.offer(new int[] { my, mx });
						list.add(new int[] { my, mx });
					}
				}

				if (list.size() > 1) { // 인구이동이 존재하면
					move++;
					int avg = sum / list.size();
					for (int[] tmp : list) {
						arr[tmp[0]][tmp[1]] = avg;
					}
				}
			}
		}
		return move;
	}

	private static boolean isArea(int y, int x, int N) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;
		return true;
	}
}
