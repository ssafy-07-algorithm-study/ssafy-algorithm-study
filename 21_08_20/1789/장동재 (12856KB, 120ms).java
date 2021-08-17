package week03;

import java.util.Scanner;

public class BOJ1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong();
		long sum = 0;
		
		// 1번 : 합 공식으로 구하기 - 12880KB 128ms
//		while (true) {
//			if (num * (num + 1) > N * 2) break;
//			num++;
//		}
		
		// 2번 : 그냥 다 더하기 - 12856KB 120ms
		long num = 0;
		
		while (true) {
			if (sum > N) break;
			sum += ++num;
		}
		
		System.out.println(num - 1);
		
		sc.close();
	}
}
