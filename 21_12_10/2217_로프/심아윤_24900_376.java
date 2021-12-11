package december.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B_2217_로프 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder()); // 내림차순
		int max = arr[0];
		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i] * (i + 1));
		}
		System.out.println(sb.append(max));
	}
}
