package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21278_호석이두마리치킨 {

	static int totalmax = 100001;
	static int a, b;
	static int INF = 100001;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dist = new int[N][N];
		for (int[] d : dist) { // 모든 정점 사이의 거리를 INF(최대)로 셋팅
			Arrays.fill(d, INF);
		}
		for (int i = 0; i < N; i++) {
			dist[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			dist[a][b] = 2; // 왕복
			dist[b][a] = 2;
		}

		// 플로이드-와샬 알고리즘을 통해 모든 거리의 최소값을 구한다.
		allDist(N, dist);

		// 두개의 치킨집을 통해 최소거리를 구한다.
		for (int i = 0; i < N; i++) { // 첫번째 치킨집
			for (int j = i + 1; j < N; j++) { // 두번째 치킨집
				int[] chicken = { i, j };
				reDist(chicken, N, dist);
			}
		}

		System.out.println(a + " " + b + " " + totalmax);
	}

	// 치킨집 추가 - 다시 최소거리 구하기
	private static void reDist(int[] chicken, int N, int[][] dist) {
		int sum = 0; // 현재 치킨집일 경우의 총 거리합
		for (int i = 0; i < N; i++) {
			int Min = Integer.MAX_VALUE;
			for (int j = 0; j < 2; j++) {
				int idx = chicken[j];
				Min = Math.min(Min, dist[i][idx]); // 2개의 치킨집 중 가장 가까운 치킨집 선택
			}
			sum += Min;
		}
		if (sum < totalmax) { // 가장 최소의 거리 갱신
			totalmax = sum;
			a = chicken[0] + 1;
			b = chicken[1] + 1;
		}
	}

	// 플로이드-와샬
	private static void allDist(int N, int[][] dist) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
