package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1969 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		String nucleotides = "ACGT";	// 염기 순서
		String[] DNAs = new String[N];	// DNA 리스트
		for (int i = 0; i < N; i++) DNAs[i] = br.readLine();	// DNA 업데이트

		int[][] DNAsInfo = new int[M][4];	// 염기 순서 별 빈도수 체크
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) 
				DNAsInfo[i][nucleotides.indexOf(DNAs[j].charAt(i))]++;	// 염기 순서 인덱스를 통해 빈도수 업데이트
		}
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			int[] maxInfo = maxFrequency(DNAsInfo[i]);	// 인덱스, 빈도 수
			count += N - maxInfo[1];	// 최댓값과 다른 개수를 체크하는 것이므로 전체 - 최댓값
			answer.append(nucleotides.charAt(maxInfo[0]));	// 최대빈도 염기 추가
		}
		
		System.out.println(answer);
		System.out.println(count);
	}
	// 최대 빈도 염기 인덱스 및 빈도수 체크
	public static int[] maxFrequency(int[] arr) {
		int idx = -1, max = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				idx = i;
				max = arr[i];
			}
		}
		return new int[] {idx, max};
	}
}
