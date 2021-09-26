package september.fiveweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_1922_네트워크연결_prim {

	static int N, M;
	static List<Edge>[] list;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
		}

		boolean[] visited = new boolean[N];
		int[] minDist = new int[N];
		Arrays.fill(minDist, Integer.MAX_VALUE);

		// start
		int result = 0; // 최종 결과 비용 값
		minDist[0] = 0;

		for (int i = 0; i < N; i++) {
			int idx = -1;
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < N; j++) {
				if (visited[j])
					continue;
				if (minDist[j] < min) {
					idx = j;
					min = minDist[j];
				}
			}

			visited[idx] = true;
			result += min;

			for (int j = 0; j < list[idx].size(); j++) {
				int e = list[idx].get(j).end;
				int w = list[idx].get(j).weight;
				if (visited[e]) // 현재노드에서 "다음노드"의 방문처리
					continue;
				if (minDist[e] > w)
					minDist[e] = w;
			}
		}

		System.out.println(sb.append(result));
	}

	static class Edge implements Comparable<Edge> {
		int end, weight;

		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}
}
