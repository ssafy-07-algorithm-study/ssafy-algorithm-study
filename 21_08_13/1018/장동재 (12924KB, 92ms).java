// 12924KB	92ms
package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
	private BufferedReader br;
	private StringTokenizer st;
	private char[][] fullBoard;
	private int N, M;
	private int minCount;

	BOJ1018() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		this.N = Integer.parseInt(st.nextToken());
		this.M = Integer.parseInt(st.nextToken());
		
		this.fullBoard = new char[this.N][this.M];
		this.minCount = 64;

		initBoard();
		findGlobalMinimum();
	}

	private void initBoard() throws IOException {
		for (int i = 0; i < N; i++) {
			this.fullBoard[i] = br.readLine().toCharArray();
		}
	}

	private void getLocalMinimum(int row, int col) {
		// row가 짝수일 때, col이 짝수이면 B, 홀수이면 W를 기준으로
		// row가 홀수일 때, col이 홀수이면 B, 짝수이면 W를 기준으로
		int currentCount = 0;
		for (int i = row; i < row + 8; i++) {
			for (int j = col; j < col + 8; j++) {
				if (((i % 2 == 0) && (j % 2 == 0) && this.fullBoard[i][j] == 'W')
						|| ((i % 2 == 0) && (j % 2 == 1) && this.fullBoard[i][j] == 'B')
						|| ((i % 2 == 1) && (j % 2 == 0) && this.fullBoard[i][j] == 'B')
						|| ((i % 2 == 1) && (j % 2 == 1) && this.fullBoard[i][j] == 'W'))
					currentCount++;
			}
		}
		int currentMinCount = Math.min(currentCount, 64 - currentCount);
		this.minCount = Math.min(this.minCount, currentMinCount);
	}

	private void findGlobalMinimum() {
		for (int row = 0; row <= this.N - 8; row++) {
			for (int col = 0; col <= this.M - 8; col++) {
				getLocalMinimum(row, col);
			}
		}
	}

	public int getMinCount() {
		return this.minCount;
	}

	public static void main(String[] args) throws IOException {
		BOJ1018 board = new BOJ1018();
		System.out.println(board.getMinCount());
	}
}
