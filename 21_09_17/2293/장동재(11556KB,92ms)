package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		int[] array = new int[K + 1];
		int[] numbers = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		array[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j - numbers[i] >= 0) array[j] += array[j - numbers[i]];
			}
		}
		
		System.out.println(array[K]);
	}
}
