package december.third;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_12761_돌다리 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = bfs(A, B, N, M);
		System.out.println(result);
	}

	private static int bfs(int A, int B, int N, int M) {
		boolean[] visited = new boolean[100001];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));
		visited[N] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			int now = node.num;
			int cnt = node.cnt;
			if (now == M) {
				return cnt;
			}
			for (int i = 0; i < 8; i++) {
				int next;
				if (i == 0) { // +1
					next = now + 1;
				} else if (i == 1) { // -1
					next = now - 1;
				} else if (i == 2) { // +A
					next = now + A;
				} else if (i == 3) { // +B
					next = now + B;
				} else if (i == 4) { // -A
					next = now - A;
				} else if (i == 5) { // -B
					next = now - B;
				} else if (i == 6) { // *A
					next = now * A;
				} else { // *B
					next = now * B;
				}
				if (next < 0 || next > 100000 || visited[next])
					continue;
//				System.out.print(next + " ");
				visited[next] = true;
				q.offer(new Node(next, cnt + 1));
			}
		}
		return 0;
	}

	static class Node {
		int num;
		int cnt;

		public Node(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

	}
}
