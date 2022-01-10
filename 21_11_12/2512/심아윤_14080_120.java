package november.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2512_예산 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(in.readLine());

		Arrays.sort(arr); // 예산 오름차순 정렬

		int limit = M / N; // 처음 가능한 정수 상한액
		int max = 0; // 결과값
		for (int i = 0; i < N; i++) {
			if (limit >= arr[i]) { // 상한액보다 작을 경우
				max = Math.max(max, arr[i]);
				M -= arr[i];
				int k = N - (i + 1);
				if (k > 0) // 다시 상한액을 정한다
					limit = M / k;
			} else { // 이 뒤로부터는 계속 상한가보다 높으므로 최대 예산은 상한가가 된다
				max = Math.max(max, limit);
				break;
			}
		}
		System.out.println(max);
	}
}
