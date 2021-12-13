package december.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B_16987_계란으로계란치기 {

	static int maxEgg; // 최종 결과값

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		List<egg> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new egg(s, w));
		}

		eggBreak(N, 0, list);

		System.out.println(maxEgg);
	}

	private static void eggBreak(int N, int turnEgg, List<egg> list) {
		if (turnEgg == N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (list.get(i).stamina <= 0) {
					cnt++;
				}
			}
			maxEgg = Math.max(maxEgg, cnt);
			return;
		}
		if (list.get(turnEgg).stamina <= 0) { // 이미 깨진 경우
			eggBreak(N, turnEgg + 1, list);
			return;
		}
		boolean flag = false; // 깰 계란이 없을 경우
		for (int i = 0; i < N; i++) {
			if (i == turnEgg || list.get(i).stamina <= 0)
				continue;
			flag = true;

			list.get(turnEgg).stamina -= list.get(i).weight;
			list.get(i).stamina -= list.get(turnEgg).weight;

			eggBreak(N, turnEgg + 1, list);

			list.get(turnEgg).stamina += list.get(i).weight;
			list.get(i).stamina += list.get(turnEgg).weight;
		}
		if (!flag) // 모두 continue였을 경우 다음으로 넘어간다. **
			eggBreak(N, turnEgg + 1, list);
	}

	static class egg {
		int stamina;
		int weight;

		public egg(int stamina, int weight) {
			super();
			this.stamina = stamina;
			this.weight = weight;
		}

	}
}
