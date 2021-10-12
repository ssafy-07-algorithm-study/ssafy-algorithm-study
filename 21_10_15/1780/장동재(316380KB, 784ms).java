package week11;

import java.io.*;
import java.util.*;

public class BOJ1780 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] result = new int[3];
		cut(board, 0, 0, N, result);

		for (int i = 0; i < 3; i++) answer.append(result[i]).append("\n");

		System.out.println(answer);
	}

	public static void cut(int[][] board, int x, int y, int len, int[] result) {
		if (len == 1 || isSame(board, x, y, len)) {
			++result[board[x][y] + 1];
			return;
		}

		int nextLen = len / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cut(board, x + nextLen * i, y + nextLen * j, nextLen, result);
			}
		}
	}

	public static boolean isSame(int[][] board, int x, int y, int len) {
		int standard = board[x][y];
		for (int i = x; i < x + len; i++) for (int j = y; j < y + len; j++)	if (board[i][j] != standard) return false;
		return true;
	}
}