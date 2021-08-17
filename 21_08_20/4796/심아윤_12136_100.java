package august.threeweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4796_캠핑 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 1;
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(in.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			if (L == 0 && P == 0 && V == 0)
				break;

			int sum = 0;
			sb.append("Case " + T + ": ");
			int n = V / P;
			sum += n * L;
			if (V % P > L) // 이부분이 정말 중요!!!
				sum += L;
			else
				sum += V % P;
			sb.append(sum + "\n");
			T++;
		}
		System.out.println(sb);
	}
}
