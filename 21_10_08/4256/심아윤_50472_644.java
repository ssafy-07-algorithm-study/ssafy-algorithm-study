package october.oneweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4256_트리 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			int[] pre = new int[N];
			int[] mid = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				pre[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				mid[j] = Integer.parseInt(st.nextToken());
			}

			solve(0, 0, N - 1, pre, mid);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void solve(int root, int start, int end, int[] pre, int[] mid) {
		for (int i = start; i <= end; i++) {
			if (pre[root] == mid[i]) {
				// root + 1 => 다음 pre에서의 인덱스로 root를 찾아야 한다.
				solve(root + 1, start, i - 1, pre, mid); // 왼쪽 트리
				// 다음 루트가 될 i에서 start를 빼면 i가 루트일 때의 왼쪽 트리의 개수가 나온다.
				// 현재 root번째부터 시작이므로 root + 왼쪽의 값을 더하면 딱 왼쪽까지이고,
				// 다음 i의 루트를 기준으로 오른쪽을 탐색하기 위해서 +1의 값을 해주어야 한다.
				solve(root + (i - start) + 1, i + 1, end, pre, mid);
				sb.append(pre[root] + " ");
			}
		}
	}
}
