package s5_4796_캠핑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int L,P,V;
		
		for (int t = 1; ; t++) {
			StringTokenizer strT = new StringTokenizer(br.readLine());
			
			
			L = Integer.parseInt(strT.nextToken());
			P = Integer.parseInt(strT.nextToken());
			V = Integer.parseInt(strT.nextToken());
			
			if (L == 0)
				break;
			int result = V/P*L + Math.min(V%P, L);
			
			sb.append("Case ").append(t).append(": ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
