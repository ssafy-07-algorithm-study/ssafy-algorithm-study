package week03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ1755 {
	static String[] englishNumber = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	static class Dictionary {
		private int num;
		private String eng;
		
		public Dictionary(int num, String eng) {
			this.num = num;
			this.eng = eng;
		}
		
		public int getNum() {
			return this.num;
		}
		
		public String getEng() {
			return this.eng;
		}
	}
	
	public static void main(String[] args) {
		StringBuilder answer = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(), B = sc.nextInt();
		List<Dictionary> list = new ArrayList<>();
		
		for (int i = 0; i < B - A + 1; i++) 
			list.add(new Dictionary(i + A, numbersToEnglish(i + A)));
		
		list.sort(new Comparator<Dictionary>() {
			@Override
			public int compare(Dictionary d1, Dictionary d2) {
				if (d1.getEng().compareTo(d2.getEng()) < 0) return -1;
				else return 1;
			}
		});
		
		for (int i = 0; i < B - A + 1; i++) {
			answer.append(list.get(i).getNum());
			if (i % 10 == 9) answer.append("\n");
			else answer.append(" ");
		}

		System.out.println(answer);
		sc.close();
	}
	
	public static String numbersToEnglish(int n) {
		char[] strNum = String.valueOf(n).toCharArray();
		String[] strNumSet = new String[strNum.length];
		
		int idx = 0;
		for (char c : strNum) strNumSet[idx++] = englishNumber[c - '0'];
		
		return String.join(" ", strNumSet);
	}
}
