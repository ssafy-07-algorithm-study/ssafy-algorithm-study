package silver.s3_10799_쇠막대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] in = br.readLine().toCharArray();
		char current = ')';
		int count = 0, answer = 0;
		
		for (char i : in) {
			
			if (current == '(' && i == '(') {
				count++;
			}
			if (current == '(' && i == ')') {
				count--;
				answer += count;
			}
			if (current == ')' && i == '(') {
				count++;
			}
			if (current == ')' && i == ')') {
				answer += 1;
				count--;
			}
			current = i;
		}
		System.out.println(answer);
	}
}
