package week14;

import java.io.*;

public class BOJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] parens = br.readLine().toCharArray();
		boolean flag = true;
		int count = 0;
		
		int size = 0;
		for (char paren : parens) {
			if (paren == '(') {
				++size;
				flag = true;
			} else {
				--size;
				if (flag) count += size;
				else ++count;
				flag = false;
			}
		}
		
		System.out.println(count);
	}
}
