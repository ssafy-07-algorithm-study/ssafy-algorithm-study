package december.third;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_21318_피아노체조 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] failNum = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i - 1] > arr[i]) {
				failNum[i] = failNum[i - 1] + 1;
			} else
				failNum[i] = failNum[i - 1];
		} // 마지막은 실수하지 않지만 뒤에 자리로 카운트를 함.
		int Q = Integer.parseInt(in.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(failNum[end - 1] - failNum[start - 1] + "\n");
		}
		System.out.println(sb);
	}
}
