import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	
	static int[][] board;
	static boolean isComplete;
	
	static class Pos{
		int r;
		int c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		board = new int[9][9];
		ArrayList<Pos> list = new ArrayList<Pos>();	// 0인 좌표 리스트
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0)
					list.add(new Pos(i, j));	// 0인 좌표값 저장
			}
		}
		
		dfs(list, 0);
		
		for (int[] row : board) {
			for (int i : row) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(ArrayList<Pos> list, int idx) {
		
		if(isComplete == true) return;		
		
		if(idx == list.size()) {	// 다 채워지면
			
			isComplete = true;
			return;
		}
		
		Pos pos = list.get(idx);
		
		for(int i = 1; i <= 9; i++) {
			
			if(isPossible(pos, i)) {
				board[pos.r][pos.c] = i;
				
				dfs(list, idx+1);
				if(isComplete == true) return;		
				board[pos.r][pos.c] = 0;
				
			}
			
		}
		
	}

	private static boolean isPossible(Pos pos, int i) {	// 유효성 검사
		
		// 행검사
		for(int c = 0; c < 9; c++) {
			if(board[pos.r][c] == i)
				return false;
		}
		// 열검사
		for(int r = 0; r < 9; r++) {
			if(board[r][pos.c] == i)
				return false;
		}
		// 3*3 검사
		int tr = pos.r/3*3;
		int tc = pos.c/3*3;
		for(int r = tr; r < tr+3; r++) {
			for(int c = tc; c < tc+3; c++) {
				if(board[r][c] == i)
					return false;
			}
		}
		
		return true;
	}	
	
}
