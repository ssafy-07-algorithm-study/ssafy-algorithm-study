import java.io.*;
import java.util.StringTokenizer;

//53792	208
public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 넣을 수 있는 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

		int[] W = new int[N + 1];
		int[] V = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		int[][] D = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				if (W[i] <= w) { // 해당 물건을 가방에 넣을 수 있다.
					D[i][w] = Math.max(D[i - 1][w], V[i] + D[i - 1][w - W[i]]);
				} else { // 해당 물건을 가방에 넣을 수 없다 .
					D[i][w] = D[i - 1][w]; // 직전 물건까지의 최적해
				}
			}
		}
		System.out.println(D[N][K]);
	}
}
