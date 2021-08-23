package argust.fourweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_18429_근손실 {

	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		boolean[] check = new boolean[N];
		int[] w = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		perm(0, N, K, arr, check, w);
		System.out.println(sb.append(count));
	}

	private static void perm(int cnt, int N, int K, int[] arr, boolean[] check, int[] w) {
		if (cnt == N) {
			int now = 500;
			for (int i = 0; i < N; i++) {
				now += w[i] - K;
				if (now < 500)
					return;
			}
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check[i])
				continue;
			check[i] = true;
			w[cnt] = arr[i]; // 중량넣기
			perm(cnt + 1, N, K, arr, check, w);
			check[i] = false;
		}
	}
}
