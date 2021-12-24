package silver.s2_5212_지구온난화;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dydx =  { {-1,0}, {1,0}, {0,1}, {0,-1} };
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		char[][] newBoard = new char[R][C];
		
		for (int i = 0; i < R; i++) 
			board[i] = br.readLine().toCharArray();
		
		
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				newBoard[i][j] = board[i][j];
				
				if (board[i][j] == '.') continue;
				int sea = 0;
				for (int m = 0; m < 4; m++) {
					int ny = i + dydx[m][0];
					int nx = j + dydx[m][1];
					if (ny < 0 || ny >= R || nx < 0 || nx >= C
						||board[ny][nx] == '.')
						sea++;
				}
				if (sea >= 3) newBoard[i][j] = '.';
			}
		}
		
		int up = 0, down = 0, left = 0, right = 0;
		boolean isContinue = true;
		
		for (int i = 0; i < R && isContinue; i++) {
			for (int j = 0; j < C && isContinue; j++) {
				if (newBoard[i][j] == 'X') {
					up = i;
					isContinue = false;
				}
			}
		}
		
		isContinue = true;
		for (int j = 0; j < C && isContinue; j++) {
			for (int i = 0; i < R && isContinue; i++) {
				if (newBoard[i][j] == 'X') {
					left = j;
					isContinue = false;
				}
			}
		}
		
		isContinue = true;
		for (int i = R-1; i >= 0 && isContinue; i--) {
			for (int j = 0; j < C && isContinue; j++) {
				if (newBoard[i][j] == 'X') {
					down = i;
					isContinue = false;
				}
			}
		}
		
		isContinue = true;
		for (int j = C-1; j >= 0 && isContinue; j--) {
			for (int i = 0; i < R && isContinue; i++) {
				if (newBoard[i][j] == 'X') {
					right = j;
					isContinue = false;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = up; i <= down; i++) {
			for (int j = left; j <= right; j++) {
				sb.append(newBoard[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
