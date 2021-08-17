import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] num = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i = N; i <= M; i++) {
			String s = i + "";
			String str = "";
			for (int j = 0; j < s.length(); j++) {
				str += num[s.charAt(j) - '0'] + " ";
			}
			m.put(str, i);
		}

		List<Entry<String, Integer>> list = new ArrayList<>(m.entrySet());
		list.sort(Entry.comparingByKey());

		for (int i = 0; i < list.size(); i++) {
			int k = i;
			if (k != 0 && k % 10 == 0)
				sb.append("\n");
			sb.append(list.get(k).getValue() + " ");
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}
}
