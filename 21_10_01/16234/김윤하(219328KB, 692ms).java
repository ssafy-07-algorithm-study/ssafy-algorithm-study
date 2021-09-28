package gold.g5_16234_인구이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 큐 두개 (q1, q2) 로 탐색한다.
	// 처음에는 q1을 이용하여 BFS를 돌며 해당 영역의 총 인구수, 총 나라 수를 구한다. 이 때 각 나라를 q2에도 넣어준다
	// 이후 q2를 돌면서 위에서 구한 인구수/나라수로 갱신해준다.
	// 이를 모든 점에 대해서 반복하면 하루가 끝난다.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] dydx = { {-1,0}, {1,0}, {0,1}, {0,-1} };
		
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		boolean isEnd = false;
		int answer = -1;
		
		while(!isEnd) {
			answer++;
			
			isEnd = true;
			boolean[][] visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					
					q1.offer(new int[] {i, j});
					visited[i][j] = true;
					
					int size = 0, sum = 0;
					
					// i,j부터 시작하여 영역 체크 (사이즈 계산, 인구수 계산)
					while(!q1.isEmpty()) {
						
						size++;
						
						int[] cur = q1.poll();
						int cy = cur[0];
						int cx = cur[1];
						sum += board[cy][cx];
						
						for (int k = 0; k < 4; k++) {
							int ny = cy + dydx[k][0];
							int nx = cx + dydx[k][1];
							
							if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
							
							int sub = Math.abs(board[ny][nx] - board[cy][cx]);
							if (sub < L || sub > R) continue;
							
							visited[ny][nx] = true;
							q1.offer(new int[] {ny, nx});
							q2.offer(new int[] {ny, nx});
						}
					}
					
					// 위에서 방문한 애들을 다시 방문하여 값 갱신
					int value = sum/size;
					if (!q2.isEmpty()) {
						q2.offer(new int[] {i, j});
						isEnd = false;
					}
					while(!q2.isEmpty()) {
						int[] cur = q2.poll();
						int cy = cur[0];
						int cx = cur[1];
						board[cy][cx] = value;
					}
					
				}
			}
		}
		
		System.out.println(answer);

	}
	
}
