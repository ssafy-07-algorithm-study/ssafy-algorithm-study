package december.fifth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1912_연속합 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int maxValue = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			maxValue = Math.max(maxValue, sum);
			if (sum < 0)
				sum = 0;
		}
		System.out.println(maxValue);
	}
}
