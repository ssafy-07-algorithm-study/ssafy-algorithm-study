import java.io.*;
import java.util.StringTokenizer;

//23668	264
public class BOJ_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if (sum < arr[i]) {
				sum = arr[i];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
