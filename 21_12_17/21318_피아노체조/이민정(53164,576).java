import java.io.*;
import java.util.StringTokenizer;

//	53164	576

public class BOJ_21318_피아노체조 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 악보 개수
		int[] level = new int[N + 1]; // 난이도
		int[] miss = new int[N + 1]; // 실수

		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			level[i] = Integer.parseInt(st.nextToken());
			if (i > 1 && level[i] < level[i - 1])
				miss[i] = ++cnt; // 실수하면 1
			miss[i] = cnt;
		}

		int Q = Integer.parseInt(br.readLine()); // 질문 개수

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(miss[end] - miss[start]).append("\n");
		}

		System.out.println(sb);
	}
}
