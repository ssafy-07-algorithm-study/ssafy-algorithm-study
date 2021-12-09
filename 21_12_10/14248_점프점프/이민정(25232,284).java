import java.io.*;
import java.util.*;

//	25232	284
public class BOJ_14248_점프점프 {

	static int N, start, stone[], total;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 돌다리 개수
		stone = new int[N + 1];
		visited = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			stone[i] = Integer.parseInt(st.nextToken());
		}

		start = Integer.parseInt(br.readLine());
		total = 1;
		jump();

		System.out.println(total);
	}

	private static void jump() {
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			int move = cur - stone[cur];
			if (move > 0 && !visited[move]) {
				q.offer(move);
				total++;
				visited[move] = true;
			}

			move = cur + stone[cur];
			if (move <= N && !visited[move]) {
				q.offer(move);
				total++;
				visited[move] = true;
			}
		}
	}
}
