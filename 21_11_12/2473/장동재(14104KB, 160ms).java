package week15;

import java.io.*;
import java.util.*;

public class BOJ2473 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		int[] answer = new int[3];
		
		long result = Long.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int pivot = numbers[i];
			
			int leftIdx = i + 1;
			int rightIdx = N - 1;
			
			long sum = 0;
			while (leftIdx < rightIdx) {
				sum = (long)pivot + (long)numbers[leftIdx] + (long)numbers[rightIdx];
				if (result > Math.abs(sum)) {
					result = Math.abs(sum);
					
					answer[0] = pivot; 
					answer[1] = numbers[leftIdx]; 
					answer[2] = numbers[rightIdx];
				}
				
				if (result == 0) break;
				else if (sum > 0) --rightIdx;
				else ++leftIdx;
			}
		}
		
		for (int i = 0; i < 3; i++) System.out.print(answer[i] + " ");
	}
}
