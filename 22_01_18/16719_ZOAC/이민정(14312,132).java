import java.io.*;

//분할 정복,,,

public class BOJ_16719_ZOAC {

	static char[] ch;
	static int len;
	static boolean[] visited;
	static StringBuilder result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();

		ch = br.readLine().toCharArray();
		len = ch.length;
		visited = new boolean[len];
		sol(0, len);
		System.out.println(result);
	}

	private static void sol(int start, int end) {
		int idx = -1; // 가장 작은 문자의 idx
		int min = 43; // Z = 42

		for (int i = start; i < end; i++) {
			if (min > ch[i] - '0' && !visited[i]) {
				min = ch[i] - '0';
				idx = i;
			}
		}

		if (idx != -1) {
			visited[idx] = true;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < len; i++) {
				if (visited[i])
					sb.append(ch[i]);
			}
			result.append(sb).append("\n");
			// 현재 제일 작은 문자 뒤부터 검사
			sol(idx, end);
			// 그리고 앞에 검사
			sol(start, idx);
		}
	}
}
