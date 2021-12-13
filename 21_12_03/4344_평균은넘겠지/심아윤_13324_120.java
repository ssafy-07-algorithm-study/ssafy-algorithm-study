package december.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4344_평균은넘겠지 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(in.readLine());
		for (int c = 0; c < C; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			double avg = (double) sum / N;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] > avg) {
					cnt++;
				}
			}

			// String.format은 자동 반올림된다. return형은 String
			String upperAvg = String.format("%.3f", ((double) cnt / N) * 100) + "%";
			sb.append(upperAvg + "\n");
		}
		System.out.println(sb);
	}
}
