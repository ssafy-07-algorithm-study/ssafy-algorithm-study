import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//	14296	128
public class BOJ_1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 끊어진 줄 개수
		int M = Integer.parseInt(st.nextToken()); // 브랜드 개수

		int[] set = new int[M]; // 6개 묶음 가격
		int[] each = new int[M]; // 낱개 가격
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			set[i] = Integer.parseInt(st.nextToken());
			each[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(set);
		Arrays.sort(each);

		int res = 0;

		if (N <= 6) {
			res = Math.min(set[0], each[0] * N);
		} else {
			int six = N / 6; // 6개 묶음 덩어리
			int one = N % 6; // 6개씩 묶고 나서 남은거

			if (one != 0) { // 6으로 나누어 떨어지지 않는 경우
				// 묶음으로만 사는 경우 vs 낱개로만 사는 경우
				res = Math.min(set[0] * (six + 1), each[0] * N);
				// 위에서 구한 최소값 vs 묶음+낱개 섞어서 사는 경우
				res = Math.min(res, set[0] * six + each[0] * one);
			} else {// 6으로 나누어 떨어지는 경우
				// 묶음으로만 사는 경우 vs 낱개로만 사는 경우
				res = Math.min(set[0] * six, each[0] * N);
			}

		}

		System.out.println(res);
	}
}
