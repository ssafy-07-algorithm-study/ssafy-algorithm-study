package silver.s1_12919_A와B2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String target;
	static int targetSize;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder(br.readLine());
		target = br.readLine();
		targetSize = target.length();

		cal(sb);
		System.out.println(answer);
	}

	public static void cal(StringBuilder current) {
		if (answer == 1) return;
		if (current.toString().equals(target)) {
			answer = 1;
			return;
		}
		
		if (current.length() == targetSize) return;
		
		boolean result1 = target.contains(current);
		boolean result2 = target.contains(current.reverse());
		current.reverse();
		if (!result1 && !result2)
			return;
		
		StringBuilder next = new StringBuilder(current).append("A");
		cal(next);
		next = new StringBuilder(current).append("B").reverse();
		cal(next);
		 
		
	}
}
