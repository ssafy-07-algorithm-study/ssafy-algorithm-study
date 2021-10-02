package gold.g4_1520_내리막길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dydx, board, validCount;
	static int M, N, answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		dydx = new int[][] { {0,1}, {1,0}, {-1,0}, {0,-1} };
		board = new int[M][N];
		validCount = new int[M][N];
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		if (validCount[0][0] < 0) validCount[0][0] = 0;
		System.out.println(validCount[0][0]);
		
	}
	
	// 일단 목적지까지 가는 코드임
	// validCount[y][x] = (y,x) 에서 시작하여 목적지까지 도달한 경로의 횟수
	// --> 구하는 법 : 그냥 목적지에 도달했으면 1을 리턴, 못했다면 0을 리턴하게 하면 됨.
	//     --> 그리고 이걸 지나온 모든 경로의 validCount[y][x] 에 더해주면 됨.
	//     --> 즉 dfs 여야만 풀 수 있다. (일단 경로를 시작했으면, 목적지에 도달할 때 까지 다른길로 새면 안됨)
	
	// --> 이 때 도달하지 못한 점은 -1로 하고, 다시 해당 지점에 도달했을 때 더이상 탐색을 못하게 한다.
	// --> 또한 다음 validCount[y][x] 를 봤을 때 0 이상이면, 그걸 현재 validCount에 더해줌.
	// --> 최종적으로 validCount[0][0]이 답이 된다.
	public static int dfs(int y, int x) {
		if (y == M-1 && x == N-1) return 1;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dydx[i][0];
			int nx = x + dydx[i][1];
			
			if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
			if (board[y][x] <= board[ny][nx] || validCount[ny][nx] < 0) continue;
			if (validCount[ny][nx] > 0) {
				validCount[y][x] += validCount[ny][nx];
				continue;
			}
			
			validCount[y][x] += dfs(ny, nx);
		}
		if (validCount[y][x] <= 0) {
			validCount[y][x] = -1;
			return 0;
		}
		else return validCount[y][x];
	}
}
