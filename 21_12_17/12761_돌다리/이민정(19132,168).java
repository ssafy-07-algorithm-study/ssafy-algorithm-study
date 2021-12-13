import java.io.*;
import java.util.*;

//	19132	168

public class BOJ_12761_돌다리 {

	static int A, B, N, M;
	static boolean visited[];

	static class Point {
		int p, cnt;

		public Point(int p, int cnt) {
			super();
			this.p = p;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken()); // A 파워
		B = Integer.parseInt(st.nextToken()); // B 파워
		N = Integer.parseInt(st.nextToken()); // 동규 위치
		M = Integer.parseInt(st.nextToken()); // 주미 위치

		visited = new boolean[100001];

		move();

	}

	private static void move() {
		Queue<Point> queue = new LinkedList<Point>();

		queue.offer(new Point(N, 0));
		visited[N] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (cur.p == M) {
				System.out.println(cur.cnt);
				break;
			}

			if (cur.p + 1 >= 0 && cur.p + 1 <= 100000 && !visited[cur.p + 1]) {
				queue.offer(new Point(cur.p + 1, cur.cnt + 1));
				visited[cur.p + 1] = true;
			}

			if (cur.p - 1 >= 0 && cur.p - 1 <= 100000 && !visited[cur.p - 1]) {
				queue.offer(new Point(cur.p - 1, cur.cnt + 1));
				visited[cur.p - 1] = true;
			}

			if (cur.p + A >= 0 && cur.p + A <= 100000 && !visited[cur.p + A]) {
				queue.offer(new Point(cur.p + A, cur.cnt + 1));
				visited[cur.p + A] = true;
			}

			if (cur.p - A >= 0 && cur.p - A <= 100000 && !visited[cur.p - A]) {
				queue.offer(new Point(cur.p - A, cur.cnt + 1));
				visited[cur.p - A] = true;
			}

			if (cur.p + B >= 0 && cur.p + B <= 100000 && !visited[cur.p + B]) {
				queue.offer(new Point(cur.p + B, cur.cnt + 1));
				visited[cur.p + B] = true;
			}

			if (cur.p - B >= 0 && cur.p - B <= 100000 && !visited[cur.p - B]) {
				queue.offer(new Point(cur.p - B, cur.cnt + 1));
				visited[cur.p - B] = true;
			}

			if (cur.p * A >= 0 && cur.p * A <= 100000 && !visited[cur.p * A]) {
				queue.offer(new Point(cur.p * A, cur.cnt + 1));
				visited[cur.p * A] = true;
			}

			if (cur.p * B >= 0 && cur.p * B <= 100000 && !visited[cur.p * B]) {
				queue.offer(new Point(cur.p * B, cur.cnt + 1));
				visited[cur.p * B] = true;
			}
		}
	}
}
