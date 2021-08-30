package s1_5547_일루미네이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int[][][] dydx;
	static boolean[][] visited, zeroVisited;
	static int W,H, answer, zeroAnswer;
	static boolean isIn;
	
	public static void main(String[] args) throws Exception{
		// (검은색 지점의 내, 외부 테두리 모두를 계산) - (내부의 하얀색 외부 지점의 테두리) = 답!!

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		answer = 0;
		board = new int[H][W];
		visited = new boolean[H][W];
		zeroVisited = new boolean[H][W];
		dydx = new int[][][] { { {-1, 0}, { 0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1} },
				{ {-1, -1}, { 0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1, 0} } };
				// 홀, 짝
		
		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++)
				board[h][w] = Integer.parseInt(st.nextToken());
		}
		
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++){
				if (board[h][w] == 1)
					calTotal(h, w, 0);
				else {
					zeroAnswer = 0;
					isIn = true;
					calIn(h, w, 0);
					
					if (isIn)
						answer -= zeroAnswer;
				}
				
			}
			
		}
		System.out.println(answer);
		
	}
	
	public static void calTotal(int y, int x, int arrow) {
		if (y < 0 || y >= H || x < 0 || x >= W || board[y][x] == 0) { // 만약 해당 방향이 범위 밖이거나 하얀색이면 테두리인 것. 따라서 answer++
			answer++;
			return;
		}
		
		if (visited[y][x]) return;
		visited[y][x] = true;
		
		for (int i = arrow ; i < arrow+6; i++)
			calTotal(y+dydx[y%2][i%6][0], x + dydx[y%2][i%6][1], 0);
	}
	
	public static void calIn(int y, int x, int arrow) {
		if (y < 0 || y >= H || x < 0 || x >= W) { // 만약 해당 방향이 범위 밖이면 내부의 하얀색 지점이 아닌 것. 
			isIn = false;
			return;
		}
		
		if (board[y][x] == 1) { // 만약 해당 방향이 검은색이면 테두리인 것. 따라서 zeroAnswer++
			zeroAnswer++;
			return;
		}
			
		if (zeroVisited[y][x]) return;
		zeroVisited[y][x] = true;
		
		for (int i = arrow ; i < arrow+6; i++)
			calIn(y+dydx[y%2][i%6][0], x + dydx[y%2][i%6][1], i%6+4);
	}
}
