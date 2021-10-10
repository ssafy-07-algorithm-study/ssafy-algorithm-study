package week11;

import java.io.*;
import java.util.*;

public class BOJ5014 {
	public static class Stairs {
		int stair, count;
		
		public Stairs(int stair, int count) {
			this.stair = stair;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());	// 꼭대기
		int S = Integer.parseInt(st.nextToken());	// 현재
		int G = Integer.parseInt(st.nextToken());	// 목적지
		int U = Integer.parseInt(st.nextToken());	// 위
		int D = Integer.parseInt(st.nextToken());	// 아래
		
		Queue<Stairs> queue = new LinkedList<>();
		queue.add(new Stairs(S, 0));	// 현재 층, count 0
		
		boolean[] visited = new boolean[F + 1];
		visited[S] = true;
		
		while (!queue.isEmpty()) {
			Stairs current = queue.poll();
			
			int stair = current.stair;
			int count = current.count;
			
			int up = stair + U, down = stair - D;	// 윗 방향, 아랫 방향
			
			if (stair == G) {	// 해당 층이면 출력 및 종료
				System.out.println(count);
				System.exit(0);
			}
			
			if (up <= F && !visited[up]) {	// 윗 방향 가능 + 안 간 곳
				visited[up] = true;
				queue.add(new Stairs(up, count + 1));
			}
			if (down >= 1 && !visited[down]) {	// 아랫 방향 가능 + 안 간 곳
				visited[down] = true;
				queue.add(new Stairs(down, count + 1));
			}
		}
		System.out.println("use the stairs");
	}
}
