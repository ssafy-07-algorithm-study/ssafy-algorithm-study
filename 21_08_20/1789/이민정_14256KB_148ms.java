import java.io.*;

//14256KB 148ms

public class BOJ_1789_수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// int로 하면 최대 int 범위 벗어나므로 long
		long S = Long.parseLong(br.readLine()); // 자연수의 합

		long num = 1;
		long sum = 0; // i 계속 더한 값
		int cnt = 0; // 더한 숫자 개수

		while (sum < S) {
			sum += num++;
			cnt++;
		}

		int result = sum == S ? cnt : cnt - 1;
		System.out.println(result);
	}
}
