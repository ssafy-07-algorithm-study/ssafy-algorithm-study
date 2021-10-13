import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int F, S, G, U, D, answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		answer = -1;
		
		bfs();
		if(answer==-1) System.out.println("use the stairs");
		else System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		int []visited = new int[F+1];
		queue.add(S);
		visited[S] = 1;
		int now = 0;
		while(!queue.isEmpty()) {
			now = queue.poll();
			if(now == G) {
				answer = visited[now]-1;
				return;
			}
			if(now+U <= F && visited[now+U]==0) {
				visited[now+U] = visited[now]+1;
				queue.add(now+U);
			}
			if(now-D > 0 && visited[now-D]==0) {
				visited[now-D] = visited[now]+1;
				queue.add(now-D);
			}
		}
	}
}
