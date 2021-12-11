package december.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B_20291_파일정리 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String file = in.readLine();
			int dotIdx = file.lastIndexOf("."); // . 인덱스 구하기
			String extend = file.substring(dotIdx + 1); // . 다음부터 확장자
			if (map.containsKey(extend)) {
				int cnt = map.get(extend);
				map.put(extend, cnt + 1);
			} else {
				map.put(extend, 1);
			}
		}
		Object[] mapKey = map.keySet().toArray();
		Arrays.sort(mapKey);

		for (Object key : mapKey) {
			sb.append(key + " " + map.get(key) + "\n");
		}
		System.out.println(sb);
	}

}
