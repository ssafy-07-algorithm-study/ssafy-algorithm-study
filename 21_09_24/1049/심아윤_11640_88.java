package september.fourweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1049_기타줄 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄
		int M = Integer.parseInt(st.nextToken()); // 브랜드 수
		int[] piece = new int[M];
		int[] set = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			set[i] = Integer.parseInt(st.nextToken());
			piece[i] = Integer.parseInt(st.nextToken());
		}

		// 어차피 최소만을 사용해야 함으로 정렬 후 인덱스 0의 값만을 이용
		Arrays.sort(piece);
		Arrays.sort(set);

		// 구매할 수 있는 경우 중 최소를 선택함.
		int min = Integer.MAX_VALUE;

		// 세트로만
		if (N % 6 == 0) // 6세트로 나누어 떨어질 때
			min = Math.min(set[0] * (N / 6), min);
		else // 그렇지 않고 여분을 가지며 6세트를 구매할 때
			min = Math.min(set[0] * ((N / 6) + 1), min);

		// 세트와 낱개
		min = Math.min(set[0] * (N / 6) + piece[0] * (N % 6), min);
		// 낱개로만
		min = Math.min(piece[0] * N, min);

		System.out.println(sb.append(min));
	}
}
