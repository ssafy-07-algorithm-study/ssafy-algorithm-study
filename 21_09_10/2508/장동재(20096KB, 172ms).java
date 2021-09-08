package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2508 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			char[][] board = new char[R][C];
			
			for (int i = 0; i < R; i++) board[i] = br.readLine().toCharArray();
			
			int count = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (board[i][j] == '>' && j < C - 2 && checkHorizontal(board, i, j)) {
						count++;
						for (int k = 0; k < 3; k++) board[i][j + k] = '.';
					}
					if (board[i][j] == 'v' && i < R - 2 && checkVertical(board, i, j)) {
						count++;
						for (int k = 0; k < 3; k++) board[i + k][j] = '.';
					}
				}
			}
			
			answer.append(count).append("\n");
		}
		System.out.println(answer);
	}
	
	private static boolean checkHorizontal(char[][] board, int i, int j) {
		if (board[i][j] == '>' && board[i][j + 1] == 'o' && board[i][j + 2] == '<') return true;
		return false;
	}
	
	private static boolean checkVertical(char[][] board, int i, int j) {
		if (board[i][j] == 'v' && board[i + 1][j] == 'o' && board[i + 2][j] == '^') return true;
		return false;
	}
}
