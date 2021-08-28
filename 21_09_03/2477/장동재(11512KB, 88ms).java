package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int[][] info = new int[12][2];	// 방향 및 길이 체크
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1, len = Integer.parseInt(st.nextToken());

			info[i][0] = info[i + 6][0] = d;	// 방향 저장
			info[i][1] = info[i + 6][1] = len;	// 길이 저장
		}
		
		int total = 0, blank = 0;
		for (int i = 0; i < 6; i++) {
			if (info[i][0] == info[i + 2][0] && info[i + 1][0] == info[i + 3][0]) {	// 처음부터 반복이 일어나는 경우 찾기
				total = info[i + 4][1] * info[i + 5][1];	// 맨 뒤 숫자는 자동적으로 가장 긴 변
				blank = info[i + 1][1] * info[i + 2][1];	// 사이 넓이 체크
				break;
			}
		}
		
		System.out.println((total - blank) * K);
	}
}
