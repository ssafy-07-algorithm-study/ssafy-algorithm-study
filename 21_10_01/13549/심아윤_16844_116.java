package september.fiveweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13549_숨바꼭질3 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = 0; // 결과값
		Queue<Node> p = new LinkedList<>();
		p.offer(new Node(N, 0));
		boolean[] visited = new boolean[100001]; // 100001
		visited[N] = true;
		while (!p.isEmpty()) {
			Node now = p.poll();
			if (now.n == K) {
				result = now.cnt;
				break;
			}

			// *2
			if (isSize(now.n * 2) && !visited[now.n * 2]) {
				visited[now.n * 2] = true;
				p.offer(new Node(now.n * 2, now.cnt));
			}
      
			// -1
			if (isSize(now.n - 1) && !visited[now.n - 1]) {
				visited[now.n - 1] = true;
				p.offer(new Node(now.n - 1, now.cnt + 1));
			}

			// +1
			if (isSize(now.n + 1) && !visited[now.n + 1]) {
				visited[now.n + 1] = true;
				p.offer(new Node(now.n + 1, now.cnt + 1));
			}
		}

		System.out.println(sb.append(result));
	}

	private static boolean isSize(int now) {
		if (now < 0 || now > 100000)
			return false;
		return true;
	}

	static class Node {
		int n, cnt;

		public Node(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}

	}
}
