package january.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_20950_미술가미미 {

	static int Min = Integer.MAX_VALUE;
	static int R, B, G;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		List<Color> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Color(r, g, b));
		}
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		comb(0, 0, N, list, 0, 0, 0);
		System.out.println(Min);
	}

	private static void comb(int cnt, int start, int N, List<Color> list, int mr, int mb, int mg) {
		if (cnt >= 7) { // 숫자 7 => 7개를 이미 계산하였다.의 의미
			return;
		}
		for (int i = start; i < N; i++) {
			mr += list.get(i).r;
			mb += list.get(i).b;
			mg += list.get(i).g;
			if (cnt > 0) {
				int diff = Math.abs(R - (mr / (cnt + 1))) + Math.abs(G - (mg / (cnt + 1)))
						+ Math.abs(B - (mb / (cnt + 1)));
				Min = Math.min(Min, diff);
			}
			comb(cnt + 1, i + 1, N, list, mr, mb, mg);
			mr -= list.get(i).r;
			mb -= list.get(i).b;
			mg -= list.get(i).g;
		}
	}

	static class Color {
		int r, g, b;

		public Color(int r, int g, int b) {
			super();
			this.r = r;
			this.g = g;
			this.b = b;
		}

	}
}
