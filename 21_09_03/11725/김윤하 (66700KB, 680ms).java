package s2_11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] parrent = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		ArrayList<ArrayList<Integer>> connect = new ArrayList<>(N+1);
		
		for (int i = 0; i < N+1; i++)
			connect.add(new ArrayList<Integer>());
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer strT = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(strT.nextToken());
			int n2 = Integer.parseInt(strT.nextToken());
			
			connect.get(n1).add(n2);
			connect.get(n2).add(n1);
		}
		
		q.offer(1);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int next : connect.get(cur)) {
				if (parrent[next] == 0) {
					parrent[next] = cur;
					q.offer(next);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < N+1; i++)
			sb.append(parrent[i]).append("\n");
		
		System.out.print(sb);	
	}
}
