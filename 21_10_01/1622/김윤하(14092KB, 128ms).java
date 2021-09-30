package silver.s5_1622_공통순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a;
		
		StringBuilder sb = new StringBuilder();
		while((a = br.readLine()) != null) {
			int[] countA = new int[26];
			int[] countB = new int[26];
			
			String b = br.readLine();
			for (char i : a.toCharArray()) {
				countA[i-'a']++;
			}
			for (char i : b.toCharArray())
				countB[i-'a']++;
			
			for (int i = 0; i < 26; i++) {
				while(countA[i]-- > 0 && countB[i]-- > 0)
					sb.append((char)(i+'a'));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
