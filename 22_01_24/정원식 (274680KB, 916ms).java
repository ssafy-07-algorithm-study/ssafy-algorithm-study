package boj2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075_N번째큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());				
		//int[][] board = new int[N][N];
		//int[] arr = new int[N*N];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				//board[i][j] = Integer.parseInt(st.nextToken());
				//arr[cnt] = Integer.parseInt(st.nextToken());
				//cnt++;
				q.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
//		Arrays.sort(arr);
//		System.out.println(arr[(N*N)-N]);
		
		for(int i = 0; i < N-1; i++) {
			q.poll();
		}
		System.out.println(q.poll());
	}
}
