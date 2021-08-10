// 22712KB	176ms
package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20154 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alphaToInt = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };
		int sum = 0;
		char[] alphaList = br.readLine().toCharArray();
		for (char c : alphaList) sum += alphaToInt[c - 'A'];
		
		System.out.println(sum % 2 == 1 ? "I'm a winner!" : "You're the winner?");
	}
}
