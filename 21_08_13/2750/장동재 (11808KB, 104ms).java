// 11808KB	104ms
package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2750 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		boolean[] isShowed = new boolean[2001];
		for (int i = 0; i < N; i++) 
			isShowed[Integer.parseInt(br.readLine()) + 1000] = true;
		
		for (int i = 0; i < 2001; i++) if (isShowed[i]) answer.append(i - 1000).append("\n");
		
		System.out.println(answer);
	}
}
