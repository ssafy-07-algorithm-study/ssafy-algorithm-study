package gold.g3_19237_어른상어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Smell {
		int sharkNum;
		int time;
		
		public Smell(int sharkNum, int time) {
			this.sharkNum = sharkNum;
			this.time = time;
		}
	}
	
	static class Shark {
		int y;
		int x;
		int arrow;
		boolean isAlive = true;
		//arrowOrder[i][j] = 상어가 i방향일 때, j번째 우선순위를 가진 방향
		int[][] arrowOrder = new int[4][4];
		
		public Shark(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static Smell[][] smellInfo;
	static Shark[] sharks;
	static int[][] dydx;
	static int N, M, k, curTime = 0, totalShark = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		smellInfo = new Smell[N][N];
		sharks = new Shark[M];
		dydx = new int[][] { {-1,0}, {1,0}, {0,-1}, {0,1} }; // 위 아래 왼쪽 오른쪽
		
		// board 채우고 상어 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num > 0) {
					smellInfo[i][j] = new Smell(num-1, 0);
					sharks[num-1] = new Shark(i, j);
					totalShark++;
				}
			}
		}
		
		// 상어 방향 세팅
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int arrow = Integer.parseInt(st.nextToken()) -1;
			sharks[i].arrow = arrow;
		}
		
		// 방향 우선순위 세팅
		for (int m = 0; m < M; m++) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					int arrow = Integer.parseInt(st.nextToken())-1;
					// m번째 상어가 i방향일 때 j번째 우선순위를 가지는 방향 = arrow
					sharks[m].arrowOrder[i][j] = arrow;
				}
			}
		}
		
		while (curTime++ <= 1000 && totalShark > 1) {
			// 여기에 상어 이동 정보를 일단 넣고, 나중에 한꺼번에 움직여준다. (잡아먹기 구현을 위함)
			// {num, y, x, arrow} = num번째 상어가 y,x로 이동하며, 바라보는 방향이 arrow가 된다. 
			Queue<int[]> moveShark = new LinkedList<>();
			
			// 상어가 이동할 곳을 확인하고, moveShark에 저장한다.
			saveMove(moveShark);
			
			// 상어를 실제로 옮겨준다.
			doMove(moveShark);
		}
		
		if (curTime == 1002) {
			System.out.println("-1");
		}
		else System.out.println(curTime-1);
		
		
		
	}
	
	public static void saveMove(Queue<int[]> moveShark) {
		for (int i = 0; i < M; i++) {
			Shark curShark = sharks[i];
			
			// 상어가 죽어있으면 스킵
			if (!curShark.isAlive) continue;
			
			int cy = curShark.y;
			int cx = curShark.x;
			int arrow = curShark.arrow;
			
			boolean movePossible = false;
			// 아무 냄새가 없는 칸을 확인
			for (int j : curShark.arrowOrder[arrow]) {
				int ny = cy + dydx[j][0];
				int nx = cx + dydx[j][1];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				Smell curSmell = smellInfo[ny][nx];
				
				// 냄새가 없는 칸일 때
				// 냄새 칸에 기록된 시간이 현재-k 보다 작으면 그곳은 빈칸임 (시간 지나 사라진 것)
				if (curSmell == null || curSmell.time < curTime-k) {
					moveShark.offer(new int[] {i, ny, nx, j});
					movePossible = true;
					break;
				}
			}
			
			// 아무 냄새가 없는 칸이 없었을 경우, 자신의 냄새가 있는 칸을 본다
			if (!movePossible) {
				for (int j : curShark.arrowOrder[arrow]) {
					int ny = cy + dydx[j][0];
					int nx = cx + dydx[j][1];
					
					if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					Smell curSmell = smellInfo[ny][nx];
					
					// 자신의 냄새가 있는 칸일 때
					if (curSmell != null && curSmell.time >= curTime-k && curSmell.sharkNum == i) {
						moveShark.offer(new int[] {i, ny, nx, j});
						break;
					}
				}
			}
		}
	}
	
	public static void doMove(Queue<int[]> moveShark) {
		while(!moveShark.isEmpty()) {
			int[] info = moveShark.poll();
			int sharkNum = info[0];
			int y = info[1];
			int x = info[2];
			int arrow = info[3];
			
			Shark curShark = sharks[sharkNum];
			
			// 이동하려는 칸에 다른 상어가 있을 때
			// (냄새 칸에 기록된 시간이 현재 시간과 같으면, 거기에 진짜로 상어가 있는 것)
			if (smellInfo[y][x] != null && smellInfo[y][x].time == curTime) {
				// 기존 상어의 번호가 더 작다면, 이동하려는 상어를 죽인다
				if (smellInfo[y][x].sharkNum < sharkNum) {
					curShark.isAlive = false;
					totalShark--;
					continue;
				}
				else {// 기존 상어의 번호가 더 크다면, 기존 상어를 죽인다
					sharks[smellInfo[y][x].sharkNum].isAlive = false;
					totalShark--;
				}
			}
			
			// 이동하려는 상어를 이동시킨다.
			smellInfo[y][x] = new Smell(sharkNum, curTime);
			curShark.y = y;
			curShark.x = x;
			curShark.arrow = arrow;
		}
	}
}
