package week15;

import java.io.*;
import java.util.*;

public class BOJ1431 {
	public static class SerialNumber implements Comparable<SerialNumber> {
		String str;
		int length, sum;
		
		public SerialNumber(String str) {
			this.str = str;
			this.length = str.length();
			this.getSum();
		}
		
		private void getSum() {
			for (int i = 0; i < this.length; i++) if (this.str.charAt(i) <= '9') this.sum += this.str.charAt(i) - '0';
		}

		public int compareTo(SerialNumber o) {
			if (this.length == o.length) {
				if (this.sum == o.sum) {
					return this.str.compareTo(o.str);
				}
				return this.sum - o.sum;
			}
			return this.length - o.length;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		SerialNumber[] list = new SerialNumber[N];
		for (int i = 0; i < N; i++) list[i] = new SerialNumber(br.readLine());
		Arrays.parallelSort(list);
		
		for (int i = 0; i < N; i++) answer.append(list[i].str).append("\n");
		System.out.println(answer);
	}
}
