import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스 {

	static class Connect {
		int a;
		int b;
		boolean visited;

		public Connect(int to, int from, boolean visited) {
			super();
			this.a = to;
			this.b = from;
			this.visited = visited;
		}

	}

	static int C, N;
	static Connect[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		C = Integer.parseInt(br.readLine()); // 컴퓨터 수
		N = Integer.parseInt(br.readLine()); // 연결된 쌍의 수

		list = new Connect[N];

		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			list[i] = new Connect(to, from, false);
		}

		System.out.println(virus());
	}

	private static int virus() {

		boolean[] isInfected = new boolean[C + 1];

		Queue<Connect> q = new LinkedList<Connect>();
		for (int i = 0; i < N; i++) {
			if (list[i].a == 1 || list[i].b == 1)
				q.offer(list[i]);
		}

		while (!q.isEmpty()) {
			Connect cur = q.poll();
			cur.visited = true;

			isInfected[cur.a] = true;
			isInfected[cur.b] = true;

			for (int i = 0; i < N; i++) {
				if (list[i].a == cur.b || list[i].b == cur.b || list[i].a == cur.a || list[i].b == cur.a) {
					if (!list[i].visited) {
						q.offer(list[i]);
					}
				}
			}
		}

		int cnt = 0;

		for (boolean virus : isInfected) {
			if (virus)
				cnt++;
		}
		return cnt - 1;
	}
}
