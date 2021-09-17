import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class Destination{	//위치 담는 클래스
		private int x;
		private int y;
		public Destination(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	private static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [][]arr = new int[N][M];
		int [][]visited = new int[N][M];
		String tmp="";
		for(int i=0;i<N;i++) {
			tmp = br.readLine();
			for(int j=0;j<M;j++) arr[i][j]= tmp.charAt(j)-'0';
		}
		bfs(arr, visited);
		System.out.println(visited[N-1][M-1]+1);
	}//main
	
	public static void bfs(int [][]arr, int [][]visited) {
		int []dx = {-1,0,1,0};
		int []dy = {0,1,0,-1};
		Queue<Destination> queue = new LinkedList<>();
		queue.add(new Destination(0,0));
		while (!queue.isEmpty()) {
			Destination tmp = queue.poll();
			int x = tmp.x;
			int y = tmp.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(visited[nx][ny]==0 && arr[nx][ny]==1) {
					queue.add(new Destination(nx, ny));
					visited[nx][ny] = visited[x][y] + 1;
				}
			}
		}
	}
}
