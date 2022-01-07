import java.io.*;
import java.util.StringTokenizer;

//	14572	132
public class BOJ_12869_뮤탈리스크 {

	static int N, minCnt;
	static boolean visited[][][];
	static int[] damage = { 9, 3, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] power = new int[3];
		for (int i = 0; i < N; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}

		minCnt = Integer.MAX_VALUE;
		visited = new boolean[61][61][61];

		attack(power[0], power[1], power[2], 0);
		System.out.println(minCnt);
	}

	private static void attack(int p1, int p2, int p3, int cnt) {
		// 음수면 무조건 0으로
		p1 = Math.max(0, p1);
		p2 = Math.max(0, p2);
		p3 = Math.max(0, p3);

		// 정렬
		int max = Math.max(Math.max(p1, p2), p3);
		int min = Math.min(Math.min(p1, p2), p3);
		int mid = p1 + p2 + p3 - max - min;

		p1 = max;
		p2 = mid;
		p3 = min;

		if (p1 == 0 && p2 == 0 && p3 == 0) {
			minCnt = Math.min(cnt, minCnt);
			return;
		}

		// 방문했던 곳이면 pass
		if (visited[p1][p2][p3])
			return;

		visited[p1][p2][p3] = true;

		attack(p1 - 9, p2 - 3, p3 - 1, cnt + 1);
		attack(p1 - 9, p2 - 1, p3 - 3, cnt + 1);
		attack(p1 - 3, p2 - 1, p3 - 9, cnt + 1);
		attack(p1 - 3, p2 - 9, p3 - 1, cnt + 1);
		attack(p1 - 1, p2 - 3, p3 - 9, cnt + 1);
		attack(p1 - 1, p2 - 9, p3 - 3, cnt + 1);

		return;
	}

}
