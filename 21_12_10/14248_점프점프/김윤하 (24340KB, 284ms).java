package silver.s2_14248_점프점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] stones = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = Integer.parseInt(br.readLine())-1;
		int answer = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int index = q.poll();
			System.out.println(index + "방문");
			int value = stones[index];
			if (value < 0) continue;
			
			int nextIndex = index+value;
			
			stones[index] = -1;
			answer++;
			
			
			if (index+value < n && stones[index+value] != -1) {
				q.add(index+value);
			}
			if (index-value >=0 && stones[index-value] != -1) {
				q.add(index-value);
			}
			
		}
		System.out.println(answer);
	}
}
