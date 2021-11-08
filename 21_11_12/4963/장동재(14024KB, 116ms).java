package week15;

import java.io.*;
import java.util.*;

public class BOJ4963 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			int col = Integer.parseInt(st.nextToken()), row = Integer.parseInt(st.nextToken());
			if (row == 0 && col == 0) break;
			
			int[][] board = new int[row][col];
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++) board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (board[i][j] == 1) {
						bfs(board, row, col, i, j);
						++result;
					}
				}
			}
			
			answer.append(result).append("\n");
		}
		System.out.println(answer);
	}

	private static void bfs(int[][] board, int row, int col, int i, int j) {
		int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (board[current[0]][current[1]] != 1) continue;
			board[current[0]][current[1]] = 2;
			
			for (int d = 0; d < 8; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				
				if (outOfRange(row, col, nx, ny) || board[nx][ny] != 1) continue;
				queue.add(new int[] {nx, ny});
			}
		}
	}
	
	private static boolean outOfRange(int row, int col, int x, int y) {
		if (x < 0 || y < 0 || x == row || y == col) return true;
		return false;
	}
}
