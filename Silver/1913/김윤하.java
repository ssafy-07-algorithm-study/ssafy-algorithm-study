package s5_1913_달팽이;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] dydx = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} }; // 아 오 위 왼
		
		int N = Integer.parseInt(bf.readLine());
		int target = Integer.parseInt(bf.readLine());
		
		int[][] board = new int[N][N];
		int[] targetXY = new int[2];
		int mode = 0;
		
		for (int y = 0, x = 0, i = N*N ; i > 0 ; y += dydx[mode%4][0], x += dydx[mode%4][1], i--) {
			int nextY = y + dydx[mode%4][0], nextX = x + dydx[mode%4][1];
			
			if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) mode++;
			else if (board[nextY][nextX] != 0) mode++;
			
			
			board[y][x] = i;
			if (i == target)
				targetXY = new int[]{y+1, x+1};
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(board[i][j]).append(" ");
			sb.append("\n");
		}
		sb.append(targetXY[0]).append(" ").append(targetXY[1]);
		
		System.out.print(sb);	
	}
}
