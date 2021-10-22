import java.io.*;
import java.util.StringTokenizer;

//	14472	148
public class BOJ_11722_가장긴감소하는부분수열 {

	static int N, arr[], dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(dp());

	}

	private static int dp() {
		int maxSize = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxSize = Math.max(maxSize, dp[i]);
		}

		return maxSize;
	}

}
