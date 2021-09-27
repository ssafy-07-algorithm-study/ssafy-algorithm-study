package gold.g5_1922_네트워크연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Prim pq 구현
public class Main {
	
	static class Edge implements Comparable<Edge>{
		int v;
		int cost;
		
		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.cost, e.cost);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N];

		ArrayList<Edge>[] edges = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) -1;
			int v2 = Integer.parseInt(st.nextToken()) -1;
			int cost = Integer.parseInt(st.nextToken());
			
			edges[v1].add(new Edge(v2, cost));
			edges[v2].add(new Edge(v1, cost));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();	
		pq.offer(new Edge(0, 0));
		int answer = 0;
		
		while(!pq.isEmpty()) {
			
			
			Edge cur = pq.poll();
			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			
			answer += cur.cost;
			
			for (Edge next : edges[cur.v]) {
				pq.offer(new Edge(next.v, next.cost));
			}
		}
		System.out.println(answer);
		
	}
}