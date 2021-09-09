package september.oneweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11725_트리의부모찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		boolean[] check = new boolean[N + 1];
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}

		check[1] = true;
		dfs(1, result, check, list);
		for (int i = 2; i <= N; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int start, int[] result, boolean[] check, ArrayList<Integer>[] list) {
		for (int i = 0; i < list[start].size(); i++) {
			int idx = list[start].get(i);
			if (!check[idx]) {
				check[idx] = true;
				result[idx] = start;
				dfs(idx, result, check, list);
			}
		}
	}
}
