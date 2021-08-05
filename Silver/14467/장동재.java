// 17844KB	240ms
package week01;

import java.util.Scanner;

public class BOJ14467 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] cows = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] check = new int[10];

		int count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			int cowNum = sc.nextInt() - 1;
			int pos = sc.nextInt();

			if (cows[cowNum] == -1)
				cows[cowNum] = pos;
			else {
				if (cows[cowNum] != pos) {
					cows[cowNum] = pos;
					check[cowNum]++;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < 10; i++) {
			result += check[i];
		}
		System.out.println(result);
	}
}
