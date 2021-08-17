package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3085 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
		
		int result = -1;
		boolean trueMax = false;
		// 우측 & 아래 두군데 체크
		int[] dx = {0, 1};
		int[] dy = {1, 0};
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d = 0; d < 2; d++) {
					int nextX = x + dx[d];
					int nextY = y + dy[d];
					
					if (outOfRange(N, nextX, nextY)) continue;
					
					if (isDifferent(board, x, y, nextX, nextY)) {
						swap(board, x, y, nextX, nextY);	// 변경하고
						result = Math.max(result, countMaximum(board, N));// 개수 세고
						swap(board, x, y, nextX, nextY);	// 제자리로
						if (result == N) {
							trueMax = true;
							break;
						}
					}
				}
				if (trueMax) break;
			}
			if (trueMax) break;
		}
		
		System.out.println(result);
	}
	// 범위 체크
	public static boolean outOfRange(int N, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N) return true;
		return false;
	}
	
	// 다음 위치랑 다른지 체크
	public static boolean isDifferent(char[][] board, int x1, int y1, int x2, int y2) {
		if (board[x1][y1] == board[x2][y2]) return false;
		return true;
	}
	
	// 개수 세기
	public static int countMaximum(char[][] board, int N) {
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			result = Math.max(result, countRow(board, i));
			result = Math.max(result, countCol(board, i));
			if (result == N) break;
		}
		
		return result;
	}

	public static int countRow(char[][] board, int x) {
		int result = 0;
		int temp = 1;
		char c = board[x][0];
		for (int i = 1; i < board.length; i++) {
			if (c == board[x][i]) temp++;
			else {
				result = Math.max(result, temp);
				temp = 1;
				c = board[x][i];
			}
			if (i == board.length - 1) result = Math.max(result, temp);
		}
		return result;
	}
	
	public static int countCol(char[][] board, int y) {
		int result = 0;
		int temp = 1;
		char c = board[0][y];
		for (int i = 1; i < board.length; i++) {
			if (c == board[i][y]) temp++;
			else {
				result = Math.max(result, temp);
				temp = 1;
				c = board[i][y];
			}
			if (i == board.length - 1) result = Math.max(result, temp);
		}
		return result;
	}
	
	// 위치 교환
	public static void swap(char[][] board, int x1, int y1, int x2, int y2) {
		char temp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = temp;
	}
}
