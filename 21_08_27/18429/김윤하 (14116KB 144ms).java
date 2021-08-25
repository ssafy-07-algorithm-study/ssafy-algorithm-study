package s3_18429_근손실;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0, N, K;
	static int[] kit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kit = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int n = 0 ; n < N; n++) {
			kit[n] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0, 500, N, 0);
		System.out.println(answer);
	}
	
	static void permutation(int flag, int sum, int N, int depth) {
		if (depth == N) {
			answer++;
			return;
		}
		if (sum < 500)
			return;
		
		sum -= K;
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			permutation(flag | 1<<i, sum + kit[i], N, depth+1);
		}
	}
}
