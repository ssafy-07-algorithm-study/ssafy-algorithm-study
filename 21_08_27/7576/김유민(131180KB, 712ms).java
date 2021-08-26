import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class tomato{
		private int x;
		private int y;
		public tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static int M,N, unriped;
	public static int answer=0;
	public static int count=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int [][]arr = new int[N][M];
		int [][]visited = new int[N][M];
		ArrayList<tomato> list = new ArrayList<>();
		int tmp;
		for(int i=0;i<N;i++) {	//입력받기
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) {	//익은 토마토의 위치를 저장
					visited[i][j] = 1;
					list.add(new tomato(i, j));
				}
				else if(tmp==0) unriped++;
				arr[i][j]= tmp; 
			}
		}		
		ripe(arr, visited, list);

		int answer=0;
		if(unriped==count) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					answer = Math.max(answer, visited[i][j]);
				}
			}
			System.out.println(answer-1);
		}
		else {
			System.out.println(-1);	//안 익은 토마토 초기 개수와 시간이 지나 익은 토마토의 개수가 안 맞을 경우 
		}
	}//main

	public static void ripe(int [][]arr, int [][]visited, ArrayList<tomato> list) {
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		Queue<tomato> queue = new LinkedList<>();
		for(int i=0;i<list.size();i++) {
			queue.add(list.get(i));
		}
		while(!queue.isEmpty()) {
			tomato tmpTomato = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = dx[i]+tmpTomato.x;
				int ny = dy[i]+tmpTomato.y;
				if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]!=0 || arr[nx][ny]==-1) continue;
				if(arr[nx][ny]==0) {
					arr[nx][ny]=1;
					visited[nx][ny] = visited[tmpTomato.x][tmpTomato.y]+1;
					count++;
					queue.add(new tomato(nx, ny));
				}
			}
		}
	}
}