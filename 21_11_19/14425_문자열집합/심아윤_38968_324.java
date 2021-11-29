package november.third;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_14425_문자열집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Boolean> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			map.put(str, true);
		}
		int result = 0;
		for (int i = 0; i < M; i++) {
			String str = in.readLine();
			if (map.containsKey(str)) {
				result += 1;
			}
		}
		System.out.println(result);
	}
}
