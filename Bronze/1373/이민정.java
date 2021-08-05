//메모리 32128 KB
//시간 524ms

import java.io.IOException;
import java.util.Scanner;

// <2진수를 8진수로 바꾸기> 
// 1 . 2진수의 숫자를 3자리씩 묶기
// 2 . 3자리로 묶은 숫자에 2진수의 자리값을 곱함 
// 3 . 곱한 값을 더하면 8진수가 됨 !! 

public class BOJ_1373_2진수8진수 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int sum = 0;
		int len = s.length();

		if (s.length() % 3 == 2) {
			s = "0" + s;// 3의 배수로
			len++;
		} else if (s.length() % 3 == 1) {
			s = "00" + s;
			len = len + 2;
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 2;
		for (int i = 0; i < len; i++) {
			sum += (int) (Math.pow(2, cnt) * (s.charAt(i) - '0'));
			cnt--;
			if (cnt == -1) {
				sb.append(sum);
				sum = 0;
				cnt = 2;
			}
		}
		System.out.println(sb);
	}
}
