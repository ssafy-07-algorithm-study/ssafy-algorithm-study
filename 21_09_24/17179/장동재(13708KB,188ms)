package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17179 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		
		int[] cutPoints = new int[M + 1];
		for (int i = 0; i < M; i++) cutPoints[i] = Integer.parseInt(br.readLine());
		cutPoints[M] = L;
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int start = 0, end = L;
			
			int answer = 0;
			while (start <= end) {
				int mid = (start + end) / 2;
				
				int tempCut = 0, prev = 0;
				for (int j = 0; j < M + 1; j++) {
					if (cutPoints[j] - prev >= mid) {
						tempCut++;
						prev = cutPoints[j];
					}
				}
				if (tempCut > n) {
					start = mid + 1;
					answer = Math.max(answer, mid);
				}
				else end = mid - 1;
			}
			System.out.println(answer);
		}
		
	}
}
