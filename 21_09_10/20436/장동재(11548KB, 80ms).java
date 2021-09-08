package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ20436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] info = br.readLine().toCharArray();

		char[][] keyboard = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' }, { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' }, { 'z', 'x', 'c', 'v', 'b', 'n', 'm' } };
		Map<Character, int[]> position = new HashMap();

		for (int i = 0; i < keyboard.length; i++)
			for (int j = 0; j < keyboard[i].length; j++) 
				position.put(keyboard[i][j], new int[] {i, j});
	
		char left = info[0];
		char right = info[2];
		
		int count = 0;
		
		String moum = "yuiophjklbnm";
		
		char[] charArray = br.readLine().toCharArray();
		for (char c : charArray) {
			int[] next = position.get(c);
			int[] current = null;
			if (moum.indexOf(c + "") != -1) {
				current = position.get(right);
				right = c;
			} else {
				current = position.get(left);
				left = c;
			}
			
			count += Math.abs(current[0] - next[0]) + Math.abs(current[1] - next[1]) + 1;
		}
		
		System.out.println(count);
	}
}
