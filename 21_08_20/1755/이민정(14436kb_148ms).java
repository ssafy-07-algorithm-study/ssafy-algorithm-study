import java.io.*;
import java.util.*;

// 14436KB 148ms

public class BOJ_1755_숫자놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String originNum[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		List<String> engNum = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
				"nine");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		String number[] = new String[N - M + 1];

		int idx = 0;
		for (int i = M; i <= N; i++) {
			number[idx++] = Integer.toString(i);
		}

		for (int i = 0; i < number.length; i++) {
			if (number[i].length() == 2) {
				number[i] = engNum.get(Integer.parseInt(number[i].split("")[0])) + " "
						+ engNum.get(Integer.parseInt(number[i].split("")[1]));
			} else {
				number[i] = engNum.get(Integer.parseInt(number[i]));
			}
		}

		Arrays.sort(number);

		for (int i = 0; i < number.length; i++) {
			st = new StringTokenizer(number[i], " ");
			if (st.countTokens() == 2) {
				number[i] = originNum[engNum.indexOf(st.nextToken())] + originNum[engNum.indexOf(st.nextToken())];
			} else {
				number[i] = originNum[engNum.indexOf(st.nextToken())];
			}
		}

		for (int i = 1; i <= number.length; i++) {
			System.out.print(number[i - 1] + " ");
			if (i % 10 == 0) {
				System.out.println();
			}
		}

	}
}
