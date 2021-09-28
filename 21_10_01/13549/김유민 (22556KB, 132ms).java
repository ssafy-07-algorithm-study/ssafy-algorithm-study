import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int []arr = new int[1000001];
		boolean []visited = new boolean[1000001];
		bfs(arr,visited,N,K);
		System.out.println(arr[K]);
	}
	
	public static void bfs(int []arr, boolean []visited, int N, int K) {
		Queue<int[]> queue = new LinkedList<>();
		int []now= {N,0};
		queue.add(now);
		visited[N]=true;
		
		while(!queue.isEmpty()) {
			now=queue.poll();
			if(now[0]*2<=100000 && visited[now[0]*2]==false) {
				arr[now[0]*2] = now[1];
				queue.add(new int[] {now[0]*2, now[1]});
				visited[now[0]*2]=true;
			}
			if(now[0]-1>=0 && visited[now[0]-1]==false) {
				arr[now[0]-1] = now[1]+1;
				queue.add(new int[] {now[0]-1, now[1]+1});
				visited[now[0]-1]=true;
			}
			if(now[0]+1<=100000 && visited[now[0]+1]==false) {
				arr[now[0]+1] = now[1]+1;
				queue.add(new int[] {now[0]+1, now[1]+1});
				visited[now[0]+1]=true;
			}
		}
	}
}
