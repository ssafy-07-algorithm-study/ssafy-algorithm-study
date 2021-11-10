import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//	15824	204
public class BOJ_2473_세용액 {

	static int N;
	static long arr[], selected[];
	static long total;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		selected = new long[3];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		total = Long.MAX_VALUE;
		for (int i = 0; i < N - 2; i++) {
			mix(i);
		}

		Arrays.sort(selected);
		for (long n : selected) {
			System.out.print(n + " ");
		}
	}

	private static void mix(int i) {
		int left = i + 1;
		int right = N - 1;

		while (left < right) {
			long sum = arr[i] + arr[left] + arr[right];

			if (Math.abs(sum) < total) {
				total = Math.abs(sum);
				selected[0] = arr[i];
				selected[1] = arr[left];
				selected[2] = arr[right];
			}

			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}
	}
}
