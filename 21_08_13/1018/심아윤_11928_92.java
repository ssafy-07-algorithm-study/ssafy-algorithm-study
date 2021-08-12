package argust.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1018_체스판다시칠하기 {

	static int N, M;
	static boolean[][] arr;
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];
		// W = true; B = false;
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				if ('W' == str.charAt(j))
					arr[i][j] = true;
				else
					arr[i][j] = false;
			}
		}

		// (N-8)+1
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				solve(i, j);
			}
		}

		System.out.println(sb.append(Min));
	}

	private static void solve(int x, int y) {
		boolean start = arr[x][y];
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (start != arr[x + i][y + j])
					cnt++;
				start = !start;
			}
			start = !start;
		}
		cnt = Math.min(cnt, 64 - cnt);
		Min = Math.min(Min, cnt);
	}
}
