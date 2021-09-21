package september.fourweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17179_케이크자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] point = new int[M + 1];
		for (int i = 0; i < M; i++) {
			point[i] = Integer.parseInt(in.readLine());
		}
		point[M] = L; // 마지막 좌표 입력

		for (int i = 0; i < N; i++) { // 연산 시작
			int cutNum = Integer.parseInt(in.readLine());
			int result = 0; // 결과값
			int left = 0;
			int right = L;
			int center = 0;
			while (left <= right) {
				int cnt = 0; // 조각 카운트
				int prev = 0; // 맨 왼쪽 - 기준의 시작 좌표
				center = (left + right) / 2;
				for (int j = 0; j <= M; j++) { // 범위 조심!!
					if (point[j] - prev >= center) {
						prev = point[j];
						cnt++;
					}
				}

				if (cnt > cutNum) {
					result = Math.max(result, center);
					left = center + 1;
				} else
					right = center - 1;
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
