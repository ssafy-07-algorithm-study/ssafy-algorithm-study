package december.fifth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2252_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cnt = new int[N];
		List<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			list[A].add(B);
			cnt[B]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (cnt[i] == 0) {
				q.offer(i);
				sb.append((i + 1) + " ");
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			int size = list[now].size();
			for (int i = 0; i < size; i++) {
				int num = list[now].get(i);
				cnt[num]--;
				if (cnt[num] == 0) {
					q.offer(num);
					sb.append((num + 1) + " ");
				}
			}
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}

}
