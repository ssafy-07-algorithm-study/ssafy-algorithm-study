package silver.s2_12761_돌다리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int answer = Integer.MAX_VALUE;
	static int A, B, N, M;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new boolean[100000];
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N, 0});
		while (!q.isEmpty()) {
			int[] item = q.poll();
			int current = item[0];
			int count = item[1];
			if (count >= answer || current < 0 || current > 100000 
					|| visited[current]) continue;
//				System.out.println(current + "입갤" + count);
			answer = Math.min(answer, Math.abs(current  - M) + count);
			visited[current] = true;
			
			if (current == M) {
				answer = Math.min(count, answer);
				continue;
			}
			if (current < M) {
				q.add(new int[] {current * A, count+1});
				q.add(new int[] {current * B, count+1});
				q.add(new int[] {current + A, count+1});
				q.add(new int[] {current + B, count+1});
				q.add(new int[] {current + 1, count+1});
			}
			q.add(new int[] {current - A, count+1});
			q.add(new int[] {current - B, count+1});
			q.add(new int[] {current - 1, count+1});
		}
		
		System.out.println(answer);
	}
}
