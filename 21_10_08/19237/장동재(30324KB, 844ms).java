package boj_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ19237 {
	public static class Position {
		int index, x, y, time;
		
		public Position(int index, int x, int y, int time) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static class Shark implements Comparable<Shark>{
		int index, x, y;
		int direction;
		int[][] directionOrder;
		
		public Shark(int index, int x, int y) {
			this.index = index;
			this.x = x;
			this.y = y;
			
			directionOrder = new int[4][4];
		}

		@Override
		public int compareTo(Shark o) {
			return this.index - o.index;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][N];
		List<Shark> sharkList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if (temp != 0) sharkList.add(new Shark(temp, i, j));
				board[i][j] = temp;
			}
		}
		
		sharkList.sort(null);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) sharkList.get(i).direction = Integer.parseInt(st.nextToken()) - 1;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int d = 0; d < 4; d++) {
					sharkList.get(i).directionOrder[j][d] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		List<Position> smellList = new ArrayList<>();
		int second = 0;
		
		while (sharkList.size() != 1) {
			if (second++ == 1000) {
				System.out.println(-1);
				System.exit(0);
			}
			// 뿌려졌던 냄새 하나씩 줄이기
			for (int i = smellList.size() - 1; i >= 0; i--) {
				smellList.get(i).time--;
				if (smellList.get(i).time == 0) {
					board[smellList.get(i).x][smellList.get(i).y] = 0;
					smellList.remove(i);
				}
			}
			
			// 상어 각 자리에 냄새 뿌리기
			for (int i = 0; i < sharkList.size(); i++) {
				Shark current = sharkList.get(i);
				
				smellList.add(new Position(current.index, current.x, current.y, k));
				board[current.x][current.y] = current.index;
			}
			
			List<int[]> nextPosition = new ArrayList<>();
			// 상어가 옮길 자리 찾기
			for (int i = 0; i < sharkList.size(); i++) {
				Shark shark = sharkList.get(i);
				// 인접한 칸 중 냄새가 없는 곳 먼저
				boolean flag = false;
				for (int d = 0; d < 4; d++) {
					int nextX = shark.x + dx[shark.directionOrder[shark.direction][d]];
					int nextY = shark.y + dy[shark.directionOrder[shark.direction][d]];
					
					if (outOfRange(N, nextX, nextY) || board[nextX][nextY] != 0) continue;
					flag = true;
					nextPosition.add(new int[] {nextX, nextY, shark.directionOrder[shark.direction][d]});
					break;
				}
				
				if (flag) continue;
				// 못찾았으면 내 냄새 쪽으로 가야함
				for (int d = 0; d < 4; d++) {
					int nextX = shark.x + dx[shark.directionOrder[shark.direction][d]];
					int nextY = shark.y + dy[shark.directionOrder[shark.direction][d]];
					
					if (outOfRange(N, nextX, nextY) || board[nextX][nextY] != shark.index) continue;
					nextPosition.add(new int[] {nextX, nextY, shark.directionOrder[shark.direction][d]});
					for (int j = 0; j < smellList.size(); j++) {
						Position smell = smellList.get(j);
						if (smell.x == nextX && smell.y == nextY && smell.index == shark.index) {
							smellList.remove(j);
							break;
						}
					}
					break;
				}
			}
			List<Integer> deleteList = new ArrayList<>();
			
			// 상어 자리 업데이트
			for (int i = 0; i < nextPosition.size(); i++) {
				Shark shark = sharkList.get(i);
				int[] nextPos = nextPosition.get(i);
				
				if (board[nextPos[0]][nextPos[1]] != 0 && board[nextPos[0]][nextPos[1]] < shark.index) {
					deleteList.add(shark.index);
					continue;
				}
				sharkList.get(i).x = nextPos[0];
				sharkList.get(i).y = nextPos[1];
				sharkList.get(i).direction = nextPos[2];
				board[nextPos[0]][nextPos[1]] = shark.index;
			}
			
			while (deleteList.size() > 0) {
				int idx = deleteList.remove(0);
				for (int i = 0; i < sharkList.size(); i++) {
					if (sharkList.get(i).index == idx) {
						sharkList.remove(i);
						break;
					}
				}
			}
		}
		
		System.out.println(second);
	}
	
	public static boolean outOfRange(int N, int x, int y) {
		if (x < 0 || y < 0 || x == N || y == N) return true;
		return false;
	}
}
