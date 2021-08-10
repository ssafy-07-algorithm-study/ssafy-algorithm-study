package argust.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_20154_이구역의승자는누구야 { // 덧셈의 연산이므로 처음부터 더해주는

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };
		String str = in.readLine();

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += arr[str.charAt(i) - 'A']; // 인덱스로 만들어 획수로 계산
			if (sum > 10) // 10을 넘으면
				sum %= 10;
		}
		if (sum % 2 == 0) // 짝수이면
			sb.append("You're the winner?");
		else // 홀수이면
			sb.append("I'm a winner!");
		System.out.println(sb);
	}
}
