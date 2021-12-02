import java.io.*;
import java.util.StringTokenizer;

//	15488	176

public class BOJ_4344_평균은넘겠지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int C = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < C; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());

			int[] score = new int[N];
			int total = 0;
			double avg = 0;

			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				total += score[i];
			}

			avg = (double) total / N;

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				if (score[i] > avg)
					cnt++;
			}

			double result = ((double) cnt / (double) N) * 100;

			// Math.round()함수는 소수점아래가 0일경우 절삭하지만 String.format은 절삭하지 않고 그대로 리턴

//			sb.append(Math.round(result * 1000) / 1000.0).append("%").append("\n");
			sb.append(String.format("%,.3f", result)).append("%").append("\n");
		}
		System.out.println(sb);
	}
}
