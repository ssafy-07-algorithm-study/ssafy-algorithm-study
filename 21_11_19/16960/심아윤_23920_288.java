package november.third;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_16960_스위치와램프 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] button = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			button[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				button[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			boolean[] ramp = new boolean[M];
			for (int j = 0; j < N; j++) {
				if (j == i)
					continue;
				int size = button[j].size();
				for (int k = 0; k < size; k++) {
					int idx = button[j].get(k);
					ramp[idx] = true;
				}
			}
			if (check(ramp, M)) {
				sb.append(1);
				flag = false;
				break;
			}
		}
		if (flag) {
			sb.append(0);
		}
		System.out.println(sb);
	}

	private static boolean check(boolean[] ramp, int M) {
		for (int i = 0; i < M; i++) {
			if (!ramp[i])
				return false;
		}
		return true;
	}
}
