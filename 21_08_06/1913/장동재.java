// 51488KB	680ms
package week01;

import java.util.Scanner;

public class BOJ1913 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int target = sc.nextInt();

		makeSnail(num, target);

	}

	private static void makeSnail(int num, int target) {
		StringBuilder sb = new StringBuilder();

		int[][] board = new int[num][num];
		int maxNum = (int) Math.pow(num, 2);

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int d = 0;

		int x = 0, y = 0;
		int targetX = 0, targetY = 0;

		do {
			if (maxNum == target) {
				targetX = x + 1;
				targetY = y + 1;
			}
			board[x][y] = maxNum--;
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (outOfRange(num, nx, ny) || board[nx][ny] != 0)
				d++;
			if (d > 3)
				d %= 4;

			x += dx[d];
			y += dy[d];

		} while (maxNum > 0);

		for (int i = 0; i < num; i++)
			for (int j = 0; j < num; j++) {
				sb.append(board[i][j]);
				if (j == (num - 1))
					sb.append("\n");
				else
					sb.append(" ");
			}
		sb.append(targetX).append(" ").append(targetY);
		System.out.println(sb.toString());
	}

	private static boolean outOfRange(int num, int x, int y) {
		if (x < 0 || y < 0 || x == num || y == num)
			return true;
		return false;
	}
}
