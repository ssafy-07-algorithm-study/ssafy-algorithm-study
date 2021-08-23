package argust.fourweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1969_DNA {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] DNA = new String[N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			DNA[i] = str;
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			int[] dna = new int[4]; // ATGC
			for (int j = 0; j < N; j++) {
				char c = DNA[j].charAt(i);
				if (c == 'A') // 사전순
					dna[0]++;
				else if (c == 'C')
					dna[1]++;
				else if (c == 'G')
					dna[2]++;
				else // T
					dna[3]++;
			}

			int idx = 0;
			for (int k = 1; k < 4; k++) {
				if (dna[idx] < dna[k])
					idx = k;
			}

			if (idx == 0)
				sb.append("A");
			else if (idx == 1)
				sb.append("C");
			else if (idx == 2)
				sb.append("G");
			else
				sb.append("T");

			for (int k = 0; k < 4; k++) {
				if (k == idx)
					continue;
				count += dna[k];
			}
		}

		sb.append("\n" + count);
		System.out.println(sb);
	}

}
