package september.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_2776_암기왕 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			Map<Integer, Boolean> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				map.put(Integer.parseInt(st.nextToken()), true);
			}
			int M = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++) {
				if (map.containsKey(Integer.parseInt(st.nextToken()))) {
					sb.append(1 + "\n");
				} else
					sb.append(0 + "\n");
			}
		}
		System.out.println(sb);
	}
}
