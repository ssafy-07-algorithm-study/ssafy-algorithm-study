import java.io.*;
import java.util.*;

//26428	372

public class BOJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

		Set<String> set = new HashSet<String>();
		ArrayList<String> noHearnoSee = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String p = br.readLine();
			if (set.contains(p)) {
				noHearnoSee.add(p);
			}
		}

		System.out.println(noHearnoSee.size());
		Collections.sort(noHearnoSee);
		for (String str : noHearnoSee) {
			System.out.println(str);
		}

	}
}
