package october.oneweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_2580_스도쿠 {

	static int[][] arr = new int[9][9];
	static List<Node> list = new ArrayList<>(); // 0의 인덱스
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					list.add(new Node(i, j));
				}
			}
		}
		sudoku(0);
	}

	private static void sudoku(int idx) {
		if (idx == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]);
					if (j != 8)
						sb.append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		int y = list.get(idx).y;
		int x = list.get(idx).x;
		for (int k = 1; k <= 9; k++) {
			if (possible(y, x, k)) {
				arr[y][x] = k;
				sudoku(idx + 1);
				// 유효하면 다시 돌아오지 않음
				arr[y][x] = 0; // 다음에서 유효하지 않은 결과가 나오면 다시 돌아온다.
			}
		}
	}

	private static boolean possible(int y, int x, int n) {
		// 가로, 세로
		for (int i = 0; i < 9; i++) {
			if (arr[y][i] == n) {
				return false;
			}
			if (arr[i][x] == n) {
				return false;
			}
		}

		// 정사각형
		// 정사각형의 위치 구하기
		int sy = (y / 3) * 3;
		int sx = (x / 3) * 3;
		for (int i = sy; i < sy + 3; i++) {
			for (int j = sx; j < sx + 3; j++) {
				if (arr[i][j] == n)
					return false;
			}
		}
		return true;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
