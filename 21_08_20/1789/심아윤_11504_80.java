package august.threeweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1789_수들의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long S = Long.parseLong(in.readLine());
		long start = (long) Math.sqrt(2 * S);
		while (start > 0 && start <= S) {
			if (start * (start + 1) > 2 * S)
				start--;
			else if (start * (start + 1) <= 2 * S) {
				sb.append(start);
				break;
			}
		}
		System.out.println(sb);
	}
}
