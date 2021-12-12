package december.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14248_점프점프 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = Integer.parseInt(in.readLine()) - 1;
		int result = bfs(start, N, arr);
		System.out.println(result);
	}

	private static int bfs(int start, int N, int[] arr) {
		int[] dir = { -1, 1 };
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] check = new boolean[N];
		q.offer(start);
		check[start] = true;
		int count = 1; // 방문 가능 돌의 개수 (현재 이미 하나의 돌을 밟음)
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int next = (arr[now] * dir[d]) + now;
				if (next < 0 || next >= N || check[next])
					continue;
				check[next] = true;
				count++;
				q.offer(next);
			}

		}
		return count;
	}
}
