import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static class Node implements Comparable<Node>{
		private int a;
		private int b;
		private int v;
		public Node(int a, int b, int v) {
			this.a = a;
			this.b = b;
			this.v = v;
		}

		@Override
		public int compareTo(Node node) {
			return this.v - node.v;
		}
	}
	public static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Node> list = new ArrayList<>();
		parent = new int[N+1];
		for(int i=0;i<N+1;i++) parent[i]=i;
		int answer = 0;
		int a,b,c;
		for(int t=0;t<M;t++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list.add(new Node(a,b,c));
		}
		Collections.sort(list);
		for(Node n:list) {
			if(union(n.a, n.b)) answer += n.v;
		}
		System.out.println(answer);
	}//main
	public static boolean union(int x, int y) {
		int x1 = findSet(x);
		int y1 = findSet(y);
		if(x1!= y1) {
			parent[y1]=x1;
			return true;
		}
		return false;
	}

	public static int findSet(int x) {
		if(x==parent[x]) return x;
		return parent[x]=findSet(parent[x]);
	}
}
