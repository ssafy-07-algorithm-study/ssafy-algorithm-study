package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2776 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int[] notes = new int[N];
			for (int i = 0; i < N; i++) notes[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(notes);
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M; i++) answer.append(binarySearch(notes, Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
		}
		System.out.println(answer);
	}
	
	private static boolean binarySearch(int[] notes, int target) {
		int start = 0;
		int end = notes.length - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (notes[mid] == target) return true;
			else if (notes[mid] < target) start = mid + 1;
			else end = mid - 1;
		}
		
		return false;
	}
}
