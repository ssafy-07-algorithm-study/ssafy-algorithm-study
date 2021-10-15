import java.io.*;
import java.util.StringTokenizer;

//	311632	1016

public class BOJ_1780_종이의개수 {

	static int N, paper[][];
	static int minus, zero, plus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		paper = new int[N][N];åç

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minus = zero = plus = 0;

		cut(0, 0, N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	private static void cut(int r, int c, int N) {
		int color = paper[r][c];
		boolean same = true;

		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (paper[i][j] != color) {
					same = false;
					break;
				}
			}
			if (!same)
				break;
		}

		if (same) {
			switch (color) {
			case 1:
				plus++;
				break;

			case -1:
				minus++;
				break;

			case 0:
				zero++;
				break;
			}
			return;
		}

		int size = N / 3;

		// 9등분
		cut(r, c, size);
		cut(r, c + size, size);
		cut(r, c + size * 2, size);

		cut(r + size, c, size);
		cut(r + size, c + size, size);
		cut(r + size, c + size * 2, size);

		cut(r + size * 2, c, size);
		cut(r + size * 2, c + size, size);
		cut(r + size * 2, c + size * 2, size);

	}
}
