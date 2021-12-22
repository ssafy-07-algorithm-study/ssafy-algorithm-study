package december.fourth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2470_두용액 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE; // 두 용액의 차이 (0에 가까운 작은 수)
		int a = 0, b = 0;

		int left = 0;
		int right = N - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				a = arr[left];
				b = arr[right];
			}
			if (sum < 0)
				left++;
			else if (sum > 0)
				right--;
			else
				break;
		}

		sb.append(a + " " + b);
		System.out.println(sb);
	}
}
