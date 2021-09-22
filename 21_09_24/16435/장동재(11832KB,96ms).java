package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16435 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);
		for (int i = 0; i < N; i++) if (numbers[i] <= L) L++; else break;
		System.out.println(L);
	}
}
