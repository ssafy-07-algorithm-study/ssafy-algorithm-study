package gold.g5_4811_알약;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		long[][] arr = new long[31][31];
		
		
		for (int i = 0; i <= 30; i++) {
			for (int j = 0; j <= 30; j++) {
				if (j > i) break;
				if (j==0) {
					arr[i][j] = 1;
				}
				else {
					arr[i][j] = arr[i][j-1] + arr[i-1][j];
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				System.out.println(sb);
				return;
			}
			sb.append(arr[num][num]).append("\n");
			
		}
		
		
	}
}
