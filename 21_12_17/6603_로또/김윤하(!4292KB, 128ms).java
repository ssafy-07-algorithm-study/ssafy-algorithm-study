package silver.s2_6603_로또;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] num, lotto;
	static int k;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			
			num = new int[k];
			lotto = new int[6];
			
			for (int i = 0; i < k; i++)
				num[i] = Integer.parseInt(st.nextToken());
			
			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void comb(int depth, int start) {
		if (depth == 6) {
			for (int n : lotto)
				sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < k; i++) {
			lotto[depth] = num[i];
			comb(depth+1, i+1);
		}
	}
}
