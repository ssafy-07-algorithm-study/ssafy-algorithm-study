package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<Integer>();
		
		int[] parents = new int[N + 1];
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		bfs(graph, parents);
		
		for (int i = 2; i <= N; i++) answer.append(parents[i]).append("\n");
		System.out.println(answer);
	}
	
	private static void bfs(List<Integer>[] graph, int[] parents) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			for (int i = 0; i < graph[current].size(); i++) {
				int next = graph[current].get(i);
				if (parents[next] == 0) {
					parents[next] = current;
					queue.offer(next);
				}
			}
		}
	}
}
