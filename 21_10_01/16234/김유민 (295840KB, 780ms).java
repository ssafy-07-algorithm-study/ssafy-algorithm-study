import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, L, R;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		boolean [][]visited;
		int [][]arr = new int[N][N];
		ArrayList<int[]> list = new ArrayList<>();
		int []start = new int[2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sum;
		int count = 0;
		int answer = 0;
		while (true) {
			visited = new boolean [N][N];
			count = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visited[i][j]==true) continue;
					sum = 0;
					start[0]=i; start[1]=j; 
					list = bfs(arr, visited, start);
					if(list.size()>1) count++;
					for(int []tmp : list) sum += arr[tmp[0]][tmp[1]];
					for(int []tmp : list) arr[tmp[0]][tmp[1]]=sum/list.size();
				}
			}
			if(count==0) break;
			answer++;
		}
		System.out.println(answer);
	}//main
	
	public static ArrayList<int[]> bfs(int [][]arr, boolean [][]visited, int []start) {
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		Queue<int[]> queue = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		queue.add(start);
		visited[start[0]][start[1]]=true;
		int tmp=0;
		
		while(!queue.isEmpty()) {
			start = queue.poll();
			list.add(start);
			for(int i=0;i<4;i++) {
				int nx = start[0] + dx[i];
				int ny = start[1] + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				tmp = Math.abs(arr[start[0]][start[1]]-arr[nx][ny]);
				if(visited[nx][ny]==false && tmp<=R && tmp>=L) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny]=true;
				}
			}
		}
		return list;
	}
}
