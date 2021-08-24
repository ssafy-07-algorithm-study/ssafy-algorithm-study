package week04;

import java.util.Scanner;

public class BOJ4779 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			int N = sc.nextInt();
			
			int max = (int)Math.pow(3, N);	// 최댓값
			String[] str = new String[max];	// 문자열 배열 생성
			for (int i = 0; i < max; i++) str[i] = "-";	// 채우기
			
			cut(str, 0, max, max / 3);
			System.out.println(String.join("", str));
		}
	}
	
	public static void cut(String[] str, int start, int end, int length) {
		if (length == 0) return ;	// 더 자를 게 없을 때 리턴
		for (int i = start + length; i < end - length; i++) str[i] = " ";	// 가운데 공백 처리
		cut(str, start, start + length, length / 3);	// 앞 부분 진행
		cut(str, end - length, end, length / 3);	// 뒷 부분 진행
	}
}
