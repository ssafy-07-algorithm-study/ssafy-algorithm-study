package september.oneweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9372_상근이의여행 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
			}
			sb.append(N - 1 + "\n");
		}
		System.out.println(sb);
	}
}
