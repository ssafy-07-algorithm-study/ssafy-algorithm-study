import java.io.*;
import java.util.StringTokenizer;

//	15368	200

public class BOJ_16987_계란으로계란치기 {

	static class Egg {
		int power, weight;

		public Egg(int power, int weight) {
			this.power = power;
			this.weight = weight;
		}

	}

	static int N, maxCnt;
	static Egg[] eggs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 계란 개수

		eggs = new Egg[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int power = Integer.parseInt(st.nextToken()); // 내구도
			int weight = Integer.parseInt(st.nextToken()); // 무게
			eggs[i] = new Egg(power, weight);
		}

		maxCnt = 0; // 최대로 깬거
		breakEgg(0, 0);

		System.out.println(maxCnt);
	}

	private static void breakEgg(int idx, int cnt) {
		if (idx == N) { // 제일 오른쪽 계란 들은거
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}

		Egg egg = eggs[idx];

		// 손에 든게 깨졌거나 다른거 이미 다 깨져있으면
		if (egg.power <= 0 || cnt == N - 1) {
			breakEgg(idx + 1, cnt);
			return;
		}

		int copyCnt = cnt;

		for (int i = 0; i < N; i++) {
			// 손에 쥔거거나 깨진 계란이면 pass
			if (i == idx)
				continue;
			if (eggs[i].power <= 0)
				continue;

			egg.power -= eggs[i].weight;
			eggs[i].power -= egg.weight;

			if (egg.power <= 0) {
				cnt++;
			}
			if (eggs[i].power <= 0) {
				cnt++;
			}

			breakEgg(idx + 1, cnt);

			// 다시 원래 상태로
			egg.power += eggs[i].weight;
			eggs[i].power += egg.weight;
			cnt = copyCnt;

		}
	}
}
