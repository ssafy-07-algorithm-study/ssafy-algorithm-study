package october.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_5014_스타트링크 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		sb.append(bfs(F, S, G, U, D));

		System.out.println(sb);
	}

	private static String bfs(int F, int S, int G, int U, int D) {
		boolean[] visited = new boolean[F + 1];
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(S, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();
			int f = now.f;
			int cnt = now.cnt;
			if (f == G) {
				return cnt + "";
			}
			// U
			if (f + U <= F && !visited[f + U]) {
				visited[f + U] = true;
				q.offer(new Node(f + U, cnt + 1));
			}
			// D
			if (f - D > 0 && !visited[f - D]) {
				visited[f - D] = true;
				q.offer(new Node(f - D, cnt + 1));
			}
		}
		return "use the stairs";
	}

	static class Node {
		int f, cnt; // 층, 버튼클릭수

		public Node(int f, int cnt) {
			super();
			this.f = f;
			this.cnt = cnt;
		}

	}
}
