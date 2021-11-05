package silver.s4_1764_듣보잡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		ArrayList<String> answer = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(N-- != 0) 
			set.add(br.readLine());
		
		while(M-- != 0) {
			String a = br.readLine();
			if (set.contains(a)) answer.add(a);
		}
		Collections.sort(answer);
		
		sb.append(answer.size()).append("\n");
		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i));
			if (i != answer.size()-1)
				sb.append("\n");
		}
			
		System.out.println(sb);
		
	}
}
