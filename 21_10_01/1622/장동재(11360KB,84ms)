package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		String a;
		while ((a = br.readLine()) != null) {
			int[] alphaSetA = new int[26];
			int[] alphaSetB = new int[26];
				
			char[] charArrayA = a.toCharArray();
			char[] charArrayB = br.readLine().toCharArray();
				
			for (char c : charArrayA) alphaSetA[c - 'a'] += 1;
			for (char c : charArrayB) alphaSetB[c - 'a'] += 1;
				
			for (int i = 0; i < 26; i++) {
				if (alphaSetA[i] != 0 && alphaSetB[i] != 0) {
					int min = Math.min(alphaSetA[i], alphaSetB[i]);
					for (int j = 0; j < min; j++) answer.append((char)(i + 'a'));
				}
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
}
