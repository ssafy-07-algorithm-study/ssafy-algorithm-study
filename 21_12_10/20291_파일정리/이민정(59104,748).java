import java.io.*;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

//59104	748
public class BOJ_20291_파일정리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		TreeMap<String, Integer> fileExtension = new TreeMap<String, Integer>();

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			String name = st.nextToken();
			if (fileExtension.containsKey(name)) {
				fileExtension.put(name, fileExtension.get(name) + 1);
			} else {
				fileExtension.put(name, 1);
			}
		}

		for (Entry<String, Integer> entry : fileExtension.entrySet()) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}

		System.out.println(sb);
	}
}
