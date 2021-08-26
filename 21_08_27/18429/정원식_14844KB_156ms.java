package silver_18429_근손실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {
	
	static int res;
	static int[] selected;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] kits = new int[N];
		for(int i = 0; i < N; i++) {
			kits[i] = Integer.parseInt(st.nextToken());
		}
		selected = new int[N];
		visited = new boolean[N];
		
		comb(kits, 0, N, K);
		System.out.println(res);
	}
	
	static void comb(int[] kits, int cnt, int n, int k) {
		if(cnt == n) {
			int w = 500;
			for(int i = 0; i < n; i++) {
				if((w += selected[i] - k) < 500)
					return;
			}
			res++;
			return;
		}		
		for(int i = 0; i < n; i++) {
			if(visited[i] == true) continue;
			selected[cnt] = kits[i];
			visited[i] = true;
			comb(kits, cnt+1, n, k);
			visited[i] = false;
		}
	}

}
