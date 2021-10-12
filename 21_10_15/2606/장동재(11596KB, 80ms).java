package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		int[] parents = new int[N + 1];
		for (int i = 1; i <= N; i++) parents[i] = i;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			if (findParent(parents, a) != findParent(parents, b)) unionParent(parents, a, b);
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) if (parents[i] == 1) count++;
		
		System.out.println(count - 1);
	}
	
	public static int findParent(int[] parents, int x) {
		if (parents[x] != x) return parents[x] = findParent(parents, parents[x]);
		return x;
	}
	
	public static void unionParent(int[] parents, int a, int b) {
		int ap = findParent(parents, a);
		int bp = findParent(parents, b);
		
		if (ap < bp) updateParent(parents, bp, ap);
		else updateParent(parents, ap, bp);
	}
	
	public static void updateParent(int[] parents, int a, int b) {
		for (int i = 1; i < parents.length; i++) if (parents[i] == a) parents[i] = b;
	}
}