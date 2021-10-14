package october.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2606_바이러스 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		List<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			list[x].add(y);
			list[y].add(x);
		}

		int result = bfs(list, N);
		System.out.println(sb.append(result));
	}

	private static int bfs(List<Integer>[] list, int N) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		int cnt = 0;
		q.add(0);
		visited[0] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			int size = list[now].size();
			for (int i = 0; i < size; i++) {
				int n = list[now].get(i);
				if (visited[n])
					continue;
				q.offer(n);
				visited[n] = true;
				cnt++;
			}
		}
		return cnt;
	}
}
