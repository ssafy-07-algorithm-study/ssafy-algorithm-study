package september.threeweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_14501_퇴사 {

	static class Node {
		int T, P;

		public Node(int t, int p) {
			super();
			T = t;
			P = p;
		}

	}

	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list.add(new Node(t, p));
		}

		dp(0, N, 0, list);

		System.out.println(sb.append(result));
	}

	private static void dp(int start, int N, int gain, List<Node> list) {
		if (start == N) {
			result = Math.max(result, gain);
			return;
		}
		int time = list.get(start).T;
		int pay = list.get(start).P;
		if (start + time <= N) { // start를 0으로 했기 때문에 time을 더하면 끝나는 날이 된다.
			// 만약 start를 1로 시작했다면 T-1를 더해주어야 한다. (해당 일을 1일차로 포함하기 때문에)
			dp(start + time, N, gain + pay, list);
		}
		dp(start + 1, N, gain, list);
	}
}
