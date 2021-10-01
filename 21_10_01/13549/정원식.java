package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	
	private static class Point implements Comparable<Point> {
		int pos;
		int cnt;
		public Point(int pos, int cnt) {
			super();
			this.pos = pos;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int res = 0;
		
		boolean[] isVisited = new boolean[100001];
		
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		q.offer(new Point(N, 1));
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			isVisited[point.pos] = true;
			
			if(point.pos == K) {
				res = point.cnt;
			}
			if(point.pos+1 <= 100000 && !isVisited[point.pos+1])
				q.offer(new Point(point.pos+1, point.cnt+1));
			if(point.pos-1 >= 0 && !isVisited[point.pos-1])
				q.offer(new Point(point.pos-1, point.cnt+1));
			if(point.pos * 2 <= 100000 && !isVisited[point.pos * 2])
				q.offer(new Point(point.pos * 2, point.cnt));			
			
			
			
		}
		
		System.out.println(res-1);
		
	}
}
