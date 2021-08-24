package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18429 {
	public static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());	// 원판 개수, 손실량
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] weights = new int[N];	// 원판
		for (int i = 0; i < N; i++) weights[i] = Integer.parseInt(st.nextToken());
		
		boolean[] isSelected = new boolean[N];
		permutation(weights, isSelected, N, K, 0, 500);
		
		System.out.println(result);
	}
	
	public static void permutation(int[] weights, boolean[] isSelected, int N, int K, int count, int sum) {
		if (count == N) {
			result++;
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;	// 이미 썼으면 스킵
			if (sum + weights[i] - K < 500) continue;	// 중량 치고 다음날 500 이하로 떨어지면 스킵
			isSelected[i] = true;
			permutation(weights, isSelected, N, K, count + 1, sum + weights[i] - K);
			isSelected[i] = false;
		}
	}
}
