import java.io.*;
import java.util.*;

// 62160	204

public class BOJ_5014_스타트링크 {

	static int F, S, G, U, D;
	static boolean visited[];

	static class Loc {
		int floor, cnt;

		public Loc(int floor, int cnt) {
			super();
			this.floor = floor;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		F = Integer.parseInt(st.nextToken()); // 총 F층
		S = Integer.parseInt(st.nextToken()); // 강호 위치
		G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
		U = Integer.parseInt(st.nextToken()); // 위로 U층 이동
		D = Integer.parseInt(st.nextToken()); // 아래로 D층 이동

		visited = new boolean[F + 1];

		System.out.println(move());

	}

	private static String move() {

		// 스타트링크 위치와 강호 위치 비교해서 애초에 갈수 없는 상황이면 바로 리턴
		if (G > S) {
			if (U == 0)
				return "use the stairs";
		} else if (G < S) {
			if (G == 0)
				return "use the stairs";
		} else if (G == S) {
			return "0";
		}

		Queue<Loc> q = new LinkedList<Loc>();

		q.offer(new Loc(S, 0)); // 처음 시작 위치
		visited[S] = true;

		while (!q.isEmpty()) {
			Loc cur = q.poll();
			int floor = cur.floor;
			int cnt = cur.cnt;

			if (floor == G) // 목적지 도착하면
				return Integer.toString(cnt);

			// 이동할 위치가 범위안에 있고 방문하지 않았으면 고
			if (floor + U <= F && !visited[floor + U]) {
				q.offer(new Loc(floor + U, cnt + 1));
				visited[floor + U] = true;
			}

			if (floor - D > 0 && !visited[floor - D]) {
				q.offer(new Loc(floor - D, cnt + 1));
				visited[floor - D] = true;
			}
		}

		// 다 돌았는데도 못 도착했으면 계단 이용
		return "use the stairs";

	}
}
