package october.threeweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1780_종이의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] result = new int[3];

		int num = arr[0][0];
		boolean flag = true;
		// 처음 모두가 같을 경우를 빼먹으면 안됨..
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != num) {
					flag = false;
					break;
				}
			}
		}
		if (flag) {
			result[num + 1] = 1;
		} else { // 첫번째 전체가 같지 않을 경우 나눠서 종이 확인
			go(0, 0, N, arr, result);
		}
		for (int i = 0; i < 3; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void go(int sw, int sh, int size, int[][] arr, int[] result) {
		int m = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int w = sw + (i * m);
				int h = sh + (j * m);
				if (check(w, h, m, arr)) {
					int now = arr[w][h];
					result[now + 1] += 1;
				} else {
					go(w, h, m, arr, result);
				}
			}
		}
	}

	private static boolean check(int w, int h, int m, int[][] arr) {
		int num = arr[w][h];
		for (int i = w; i < w + m; i++) {
			for (int j = h; j < h + m; j++) {
				if (arr[i][j] != num) {
					return false;
				}
			}
		}
		return true;
	}
}
