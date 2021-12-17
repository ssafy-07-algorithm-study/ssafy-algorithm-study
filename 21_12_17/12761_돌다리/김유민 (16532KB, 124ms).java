import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int A, B, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int []visited = new int[100001];
		int answer = 0;
		queue.add(N);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(x==M) {
				System.out.println(visited[x]);
				return;
			}
			for(int t=0;t<8;t++) {
				answer = stone(t, x);
				if(answer<0 || answer>100000 || visited[answer]!=0) continue;
				queue.add(answer);
				visited[answer] = visited[x]+1;
			}
		}
	}
	
	public static int stone(int t, int x) {
		if(t==0) return ++x;
		else if(t==1) return --x;
		else if(t==2) return x+A;
		else if(t==3) return x+B;
		else if(t==4) return x-A;
		else if(t==5) return x-B;
		else if(t==6) return x*A;
		else return x*B;
	}
}
