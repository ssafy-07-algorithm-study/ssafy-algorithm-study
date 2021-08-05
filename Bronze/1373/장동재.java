// 126600KB	736ms
package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1373 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] str = br.readLine().split("");

		String temp = "";
		for (int i = str.length - 1; i >= 0; i--) {
			temp = str[i] + temp;
			if (temp.length() == 3 || i == 0) {
				binToOct(temp);
				temp = "";
			}
		}

		System.out.println(sb.reverse().toString());

	}

	public static void binToOct(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num += (str.charAt(i) - '0') * Math.pow(2, str.length() - 1 - i);
		}
		sb.append(num);
	}
}
