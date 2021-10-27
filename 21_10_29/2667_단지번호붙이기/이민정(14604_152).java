import java.io.*;
import java.util.*;

public class BOJ_2667_단지번호붙이기 {

	static int N, aCnt;
	static int[][] map;
	static boolean[][] isVisited;
	static ArrayList<Integer> apartCnt;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		apartCnt = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					aCnt = 0;
					danji(i, j);
					apartCnt.add(aCnt);
				}
			}
		}

		Collections.sort(apartCnt);
		System.out.println(apartCnt.size());
		for (int cnt : apartCnt) {
			System.out.println(cnt);
		}

	}

	private static void danji(int r, int c) {
		Queue<Loc> q = new LinkedList<Loc>();
		q.offer(new Loc(r, c));
		isVisited[r][c] = true;

		while (!q.isEmpty()) {
			Loc cur = q.poll();
			aCnt++;

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && !isVisited[nr][nc]) {
					q.offer(new Loc(nr, nc));
					isVisited[nr][nc] = true; // 들어갈때 방문체크 중요!!!
				}
			}
		}
	}
}
