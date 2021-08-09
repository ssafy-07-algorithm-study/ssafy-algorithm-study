import java.io.*;
import java.util.*;

public class BOJ_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int num = Integer.parseInt(st.nextToken());
		int pop = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();

		// queue에 1부터 num까지 집어넣기
		for (int i = 1; i <= num; i++) {
			queue.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (!queue.isEmpty()) {
			for (int i = 0; i < pop - 1; i++) {
				queue.offer(queue.poll()); // 앞에서 뺀거 다시 뒤로 넣기
			}
			if (queue.size() > 1)
				sb.append(queue.poll()).append(", ");
			else
				sb.append(queue.poll()).append(">");
		}

		System.out.println(sb);

	}
}
