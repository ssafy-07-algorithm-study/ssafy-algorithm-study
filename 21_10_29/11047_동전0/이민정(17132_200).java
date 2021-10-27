import java.io.*;
import java.util.StringTokenizer;

//	17132	200

public class BOJ_11047_동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int coinCnt = 0;
		int total = 0;

		// 끝에서부터 확인
		for (int i = N - 1; i >= 0; i--) {
			// 동전의 가치가 K보다 크면 pass
			if (coin[i] > K)
				continue;

			// 동전의 가치가 K보다 작으면
			// total이 동전보다 커지는 순간까지 더함
			while (total <= K) {
				total += coin[i];
				coinCnt++;

			}

			total -= coin[i];
			coinCnt--;

			if (total == K)
				break;
		}

		System.out.println(coinCnt);

	}
}
