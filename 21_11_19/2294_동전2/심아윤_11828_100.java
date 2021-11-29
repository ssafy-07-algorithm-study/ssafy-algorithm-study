package november.third;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2294_동전2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		int[] minCoin = new int[K + 1];
		Arrays.fill(minCoin, 100001);
		minCoin[0] = 0;

		for (int j = 0; j < N; j++) {
			for (int i = 1; i <= K; i++) {
				if (coin[j] <= i) {
					if (minCoin[i] == -1)
						minCoin[i] = 1;
					minCoin[i] = Math.min(minCoin[i], minCoin[i - coin[j]] + 1);
				}
			}
		}
		if (minCoin[K] == 100001)
			sb.append(-1);
		else
			sb.append(minCoin[K]);
		System.out.println(sb);
	}
}
