import java.io.*;
import java.util.StringTokenizer;

//81160	272

public class BOJ_20950_미술가미미 {
	static class RGB {
		int R, G, B;

		public RGB(int r, int g, int b) {
			super();
			R = r;
			G = g;
			B = b;
		}

		@Override
		public String toString() {
			return "R=" + R + ", G=" + G + ", B=" + B;
		}

	}

	static int mix, N, minDiff;
	static RGB colors[], gomdori, mondori, selected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colors = new RGB[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			colors[i] = new RGB(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine(), " ");
		gomdori = new RGB(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));

		int maxMix = 0;

		if (N < 8)
			maxMix = N;
		else
			maxMix = 7;

		minDiff = Integer.MAX_VALUE;

		for (mix = 2; mix <= maxMix; mix++) {
			selected = new RGB[mix];
			choice(0, 0);
		}

		System.out.println(minDiff);
	}

	private static void choice(int cnt, int start) {
		if (cnt == mix) {
			// 혼합
			mixColor();
			// 곰두리랑 차이
			diff();
			return;
		}

		for (int i = start; i < N; i++) {
			selected[cnt] = colors[i];
			choice(cnt + 1, i + 1);
		}
	}

	private static void diff() {
		minDiff = Math.min(minDiff,
				Math.abs(gomdori.R - mondori.R) + Math.abs(gomdori.G - mondori.G) + Math.abs(gomdori.B - mondori.B));
	}

	private static void mixColor() {
		int R = 0;
		int G = 0;
		int B = 0;
		for (int i = 0; i < mix; i++) {
			R += selected[i].R;
			G += selected[i].G;
			B += selected[i].B;
		}

		mondori = new RGB(R / mix, G / mix, B / mix);
	}
}
