package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2580 {
	static StringBuilder answer;
	static int[][] board;
	static List<int[]> zeroList;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		board = new int[9][9];
		zeroList = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) zeroList.add(new int[] {i, j});
			}
		}

		flag = false;
		sudoku(0);
	}
	public static void sudoku(int index) {
		if (index == zeroList.size()) {
			flag = true;
			answer = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) answer.append(board[i][j]).append(" ");
				answer.append("\n");
			}
			System.out.println(answer);
			System.exit(0);
			return;
		}
		if (flag) return;
		
		int[] current = zeroList.get(index);
		int x = current[0];
		int y = current[1];
		
		for (int i = 1; i < 10; i++) {
			if (checkLine(x, y, i) && checkRect(x, y, i)) {
				board[x][y] = i;
				sudoku(index + 1);
				board[x][y] = 0;
			}
		}
	}
	
	
	public static boolean checkLine(int x, int y, int target) {		
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == target) return false;
			if (board[i][y] == target) return false;
		}
		
		return true;
	}
	
	public static boolean checkRect(int x, int y, int target) {
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		int endX = startX + 3;
		int endY = startY + 3;
		
		for (int i = startX; i < endX; i++) for (int j = startY; j < endY; j++) if (board[i][j] == target) return false;
			
		return true;
	}
}
