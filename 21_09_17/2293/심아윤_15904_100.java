package september.threeweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2293_동전1 {

	static int result;

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
		int[][] price = new int[N][K + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				if (j == coin[i])
					price[i][j] = 1;
				if (i == 0 && j >= coin[i]) { // 현재 코인보다 크고, 배수이면
					price[i][j] += price[i][j - coin[i]];
				}
				if (i == 0)
					continue;
				if (j >= coin[i]) {
					// 현재 가격 j를 맞추는 이전 연산 결과와
					// 현재 연산 결과에서 현재 코인을 뺀 가격의 값
					// 현재 + 1 => X : 현재 연산 결과에서 뺀 가격을 포함하므로
					// 그 곳에 이미 현재의 코인을 최대로 사용하여 j의 가격을 만들 수 있는 경우를 포함하고 있음.
					// 24번째 줄과 관련
					price[i][j] += price[i - 1][j] + price[i][j - coin[i]];
				} else {
					price[i][j] += price[i - 1][j];
				}
			}
		}

		System.out.println(sb.append(price[N - 1][K]));
	}

}
