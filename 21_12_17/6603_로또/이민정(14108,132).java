import java.io.*;
import java.util.StringTokenizer;

//	14108	132

public class BOJ_6603_로또 {

	static int K, S[], selected[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			K = Integer.parseInt(st.nextToken());
			if (K == 0)
				break;

			S = new int[K];
			for (int i = 0; i < K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			selected = new int[6];
			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 6) {
			for (int num : selected) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < S.length; i++) {
			selected[cnt] = S[i];
			comb(cnt + 1, i + 1);
		}
	}
}
