import java.io.*;
import java.util.*;

//15844KB 164ms

class nucleotide implements Comparable<nucleotide> {
	char nu;
	int cnt;

	public nucleotide(char nu, int cnt) {
		super();
		this.nu = nu;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(nucleotide o) {
		if (this.cnt == o.cnt) {
			return this.nu - o.nu;
		}
		return o.cnt - this.cnt;
	}
}

public class BOJ_1969_DNA {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] dnas = new char[N][M];

		for (int i = 0; i < N; i++) {
			dnas[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < M; i++) {
			ArrayList<nucleotide> nu = new ArrayList<nucleotide>();

			nu.add(new nucleotide('A', 0));
			nu.add(new nucleotide('T', 0));
			nu.add(new nucleotide('G', 0));
			nu.add(new nucleotide('C', 0));

			for (int j = 0; j < N; j++) {
				switch (dnas[j][i]) {
				case 'A':
					nu.get(0).cnt++;
					break;
				case 'T':
					nu.get(1).cnt++;
					break;
				case 'G':
					nu.get(2).cnt++;
					break;
				case 'C':
					nu.get(3).cnt++;
					break;
				}
			}
			Collections.sort(nu);
			sb.append(nu.get(0).nu);
		}

		int hd = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sb.charAt(j) != dnas[i][j])
					hd++;
			}
		}
		System.out.println(sb);
		System.out.println(hd);

	}
}
