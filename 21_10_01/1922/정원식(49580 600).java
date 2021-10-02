import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents;			// 노드의 부모 노드 배열
	static ArrayList<Edge> list;	// 간선 정보 리스트
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int w;
		
		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int res = 0;
		int N = Integer.parseInt(br.readLine());	// node
		int M = Integer.parseInt(br.readLine());	// edge
		
		parents = new int[N+1];	// parents of nodes
		for (int i = 1; i <= N; i++) { // init
			parents[i] = i;
		}
		list = new ArrayList<Edge>();	// edges list
		
		for(int i = 0; i < M; i++) {	// edge info
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));	
		}
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			Edge e = list.get(i);
			// 싸이클 제외
			if(find(e.from) != find(e.to)) {
				res += e.w;
				union(e.from, e.to);
			}
		}
		
		System.out.println(res);
		
	}
	
	public static int find(int x) {
		if(x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parents[y] = x;
		}
	}
}