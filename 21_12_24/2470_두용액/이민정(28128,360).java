import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//28128	360
public class BOJ_2470_두용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		int minL = 0;
		int minR = 0;

		int L = 0;
		int R = N - 1;

		while (L < R) {
			int mix = arr[L] + arr[R];

			if (mix == 0) {
				minL = arr[L];
				minR = arr[R];
				break;
			}

			if (Math.abs(mix) < min) {
				minL = arr[L];
				minR = arr[R];
				min = Math.abs(mix);
			}

			if (mix < 0)
				L++;
			else
				R--;
		}
		System.out.println(minL + " " + minR);
	}
}
