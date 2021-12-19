import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_11728_배열합치기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
		int M = Integer.parseInt(st.nextToken()); // 배열 B의 크기
		st = new StringTokenizer(in.readLine(), " ");
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine(), " ");
		int[] B = new int[M];
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		Arrays.sort(A);
		Arrays.sort(B);
		List<Integer> list = new ArrayList<Integer>();
		int a = 0;
		int b = 0;
		boolean flag = true;
		while (flag) {
			if (A[a] <= B[b]) {
				list.add(A[a]);
				a++;
			} else {
				list.add(B[b]);
				b++;
			}
			if (a == N || b == M)
				flag = false;
		}
		while (a < N) {
			list.add(A[a]);
			a++;
		}
		while (b < M) {
			list.add(B[b]);
			b++;
		}
		for (int i = 0; i < N + M; i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.println(sb);
	}
}
