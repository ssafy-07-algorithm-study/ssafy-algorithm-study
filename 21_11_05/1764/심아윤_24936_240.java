package november.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B_1764_듣보잡 {

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
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < M; i++) {
			String str = in.readLine();
			if (map.containsKey(str)) {
				list.add(str);
			}
		}
		int size = list.size();
		Collections.sort(list);
		sb.append(size + "\n");
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb);
	}
}
