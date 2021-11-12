package week15;

import java.io.*;
import java.util.*;

public class BOJ2512 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		int total = Integer.parseInt(br.readLine());
		int min = total / N;
		int prevSum = 0;
		while (true) {
			int sum = 0;
			for (int i = 0; i < N; i++) if (numbers[i] <= min) sum += numbers[i]; else sum += min;
			if (sum <= total) {
				if (prevSum == sum) break;
				prevSum = sum;
				++min;
			}
			else break;
		}
		System.out.println(min - 1);
	}
}
