import java.io.*;
import java.util.*;

//	16788	160

public class BOJ_9079_동전게임 {

	static class Value {
		int val, cnt;

		public Value(int val, int cnt) {
			super();
			this.val = val;
			this.cnt = cnt;
		}

	}

	static StringBuilder sb;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int[][] coins = new int[3][3];
			visited = new boolean[512];

			// H : 1 , T : 0
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					String s = st.nextToken();
					if (s.equals("H"))
						coins[i][j] = 1;
					else if (s.equals("T"))
						coins[i][j] = 0;
				}
			}

			sb.append(game(coins)).append("\n");
		}
		System.out.println(sb);
	}

	private static int game(int[][] coins) {
		String str = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				str += coins[i][j];
			}
		}

		Queue<Value> q = new LinkedList<Value>();
		q.offer(new Value(Integer.parseInt(str, 2), 0));
		visited[Integer.parseInt(str, 2)] = true;

		while (!q.isEmpty()) {
			Value val = q.poll();
			if (val.val == 0 || val.val == 511) {
				return val.cnt;
			}

			String s = "";
			// 열
			s = change((val.val + ""), 0, 3, 6);
			if (!visited[Integer.parseInt(s, 2)]) {
				q.offer(new Value(Integer.parseInt(s, 2), val.cnt + 1));
				visited[Integer.parseInt(s, 2)] = true;
			}

			s = change((val.val + ""), 1, 4, 7);
			if (!visited[Integer.parseInt(s, 2)]) {
				q.offer(new Value(Integer.parseInt(s, 2), val.cnt + 1));
				visited[Integer.parseInt(s, 2)] = true;
			}

			s = change((val.val + ""), 2, 5, 8);
			if (!visited[Integer.parseInt(s, 2)]) {
				q.offer(new Value(Integer.parseInt(s, 2), val.cnt + 1));
				visited[Integer.parseInt(s, 2)] = true;
			}

			// 행
			s = change((val.val + ""), 0, 1, 2);
			if (!visited[Integer.parseInt(s, 2)]) {
				q.offer(new Value(Integer.parseInt(s, 2), val.cnt + 1));
				visited[Integer.parseInt(s, 2)] = true;
			}

			s = change((val.val + ""), 3, 4, 5);
			if (!visited[Integer.parseInt(s, 2)]) {
				q.offer(new Value(Integer.parseInt(s, 2), val.cnt + 1));
				visited[Integer.parseInt(s, 2)] = true;
			}

			s = change((val.val + ""), 6, 7, 8);
			if (!visited[Integer.parseInt(s, 2)]) {
				q.offer(new Value(Integer.parseInt(s, 2), val.cnt + 1));
				visited[Integer.parseInt(s, 2)] = true;
			}

			// 대각선
			s = change((val.val + ""), 0, 4, 8);
			if (!visited[Integer.parseInt(s, 2)]) {
				q.offer(new Value(Integer.parseInt(s, 2), val.cnt + 1));
				visited[Integer.parseInt(s, 2)] = true;
			}

			s = change((val.val + ""), 2, 4, 6);
			if (!visited[Integer.parseInt(s, 2)]) {
				q.offer(new Value(Integer.parseInt(s, 2), val.cnt + 1));
				visited[Integer.parseInt(s, 2)] = true;
			}
		}

		return -1;
	}

	private static String change(String v, int i, int j, int k) {
		char[] arr = new char[9];
		for (int l = 0; l < 9; l++) {
			arr[l] = '0';
		}
		char[] ch = Integer.toBinaryString(Integer.parseInt(v)).toCharArray();
		for (int l = ch.length; l > 0; l--) {
			arr[9 - l] = ch[ch.length - l];
		}

		arr[i] = arr[i] == '0' ? '1' : '0';
		arr[j] = arr[j] == '0' ? '1' : '0';
		arr[k] = arr[k] == '0' ? '1' : '0';

		String changeStr = new String(arr);
		return changeStr;
	}
}
