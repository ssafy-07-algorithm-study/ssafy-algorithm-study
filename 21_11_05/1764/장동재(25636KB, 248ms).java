package week14;

import java.io.*;
import java.util.*;

public class BOJ1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String name;
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		Set<String> names = new HashSet<>();
		for (int i = 0; i < N; i++) names.add(br.readLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) if (names.contains(name = br.readLine())) list.add(name);
		list.sort(null);
		int count = list.size(); answer.append(count).append("\n");
		for (int i = 0; i < count; i++) answer.append(list.get(i)).append("\n");
		
		System.out.println(answer);
	}
}
