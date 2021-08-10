package argust.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[N];
		sb.append("<");
		int cnt = 0, i = 0, num = 0; // K 확인, 순차증가, N 체크(',')
		while (true) {
			if (!arr[i % N]) { // 제거되지 않았으면
				cnt++;
				if (cnt == K) {
					arr[i % N] = true; // 제거
					sb.append((i % N) + 1);
					cnt = 0;
					num++;
					if (num == N) {
						break;
					}
					sb.append(", ");
				}
			}
			i++;
		}
		sb.append(">");
		System.out.println(sb);
	}
}
