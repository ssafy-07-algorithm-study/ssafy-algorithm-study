package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922 {
	public static class Node implements Comparable<Node>{
		int a, b, weight;
		
		public Node (int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> nodeList = new PriorityQueue();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
			if (a == b) continue;
			nodeList.offer(new Node(a, b, weight));
		}
		
		int[] parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) parents[i] = i;
		
		int count = 0;
		int result = 0;
		while (count < N - 1) {
			Node current = nodeList.poll();
			
			if (findParent(parents, current.a) == findParent(parents, current.b)) continue;
			unionParent(parents, current.a, current.b);
			++count;
			result += current.weight;
		}
		
		System.out.println(result);
	}
	
	public static int findParent(int[] parents, int x) {
		if (parents[x] != x) return parents[x] = findParent(parents, parents[x]);
		return x;
	}
	
	public static void unionParent(int[] parents, int a, int b) {
		int ap = findParent(parents, a);
		int bp = findParent(parents, b);
		
		if (ap < bp) parents[bp] = ap;
		else parents[ap] = bp;
	}
}
