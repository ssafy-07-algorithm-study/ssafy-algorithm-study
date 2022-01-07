package silver.s2_20950_미술가미미;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int[][] RGB;
	static int[] target;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		RGB = new int[N][3];
		target = new int[3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int value = Integer.parseInt(st.nextToken());
				RGB[i][j] = value;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			int value = Integer.parseInt(st.nextToken());
			target[i] = value;
		}
		
		comb(N, 0, 0, new int[] { 0, 0, 0 });
		
		System.out.println(answer);
		
	}	
		
	public static void comb(int N, int depth, int start, int[] currentSumRGB) {
		
		if (depth > 7)
			return;
		
		int sub = 0;
		if (depth >= 2) {
			for (int i = 0; i < 3; i++) {
				sub += Math.abs(target[i] - currentSumRGB[i]/depth);
			}
//			System.out.println(depth + " " + sub);
			answer = Math.min(sub, answer);
		}
		
		for (int i = start; i < N; i++) {
			
			for (int j = 0; j < 3; j++)
				currentSumRGB[j] += RGB[i][j];
			
			comb(N, depth + 1, i + 1, currentSumRGB);
			
			for (int j = 0; j < 3; j++)
				currentSumRGB[j] -= RGB[i][j];
		}
	}
}
