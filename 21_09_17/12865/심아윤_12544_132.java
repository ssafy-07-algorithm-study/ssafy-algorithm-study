package september.threeweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_12865_평범한배낭 {

	static class Node {
		int w, v;

		public Node(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int[] W = new int[K + 1];
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= 0; j--) {
				int ww = list.get(i).w;
				int vv = list.get(i).v;
				if (j >= ww) { // 변수 작성 후 시간 복잡도 비교해보기
					W[j] = Math.max(W[j], W[j - ww] + vv);
				}
			}
		}

		System.out.println(sb.append(W[K]));
	}
}
