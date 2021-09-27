package gold.g5_13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int[] minCost;
	static int maxCost;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		minCost = new int[100001];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		
		if (N >= K) {
			System.out.println(N-K);
			return;
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int node = cur[0];
			int second = cur[1];
			
			// 현재 초가 answer보다 크거나, 노드가 범위를 넘었거나, 같은 번호에 이전에 방문했던 초보다 지금 초가 크면
			if (second >= answer || node > 100000 || node < 0 || second >= minCost[node]) continue;
			minCost[node] = second;
			
			if (node == K) {
				answer = Math.min(second, answer);
				continue;
			}
			
			if (node < K) {
				q.offer(new int[] {node*2, second});
				q.offer(new int[] {node+1, second+1});
			}
			q.offer(new int[] {node-1, second+1});
		}
		System.out.println(answer);
		
	}
}