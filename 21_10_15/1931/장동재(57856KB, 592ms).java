package week11;

import java.io.*;
import java.util.*;

public class BOJ1931 {
	public static class Conference implements Comparable<Conference> {
		int start, end;
		
		public Conference (int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo (Conference o) {
			if (this.end == o.end) return this.start - o.start;
			return this.end - o.end;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Conference> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String[] info = br.readLine().split(" ");
			pq.add(new Conference(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
		}
		
		int result = 1;
		Conference current = pq.poll();
		
		while (!pq.isEmpty()) {
			Conference next = pq.poll();
			if (current.end > next.start) continue;
			++result;
			current = next;
		}
		
		System.out.println(result);
	}
}
