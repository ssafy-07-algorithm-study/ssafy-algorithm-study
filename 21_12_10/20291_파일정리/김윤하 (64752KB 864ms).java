package silver.s3_20291_파일정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> map = new TreeMap<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String extension = br.readLine().split("\\.")[1];
			if (!map.containsKey(extension))
				map.put(extension, 1);
			else
				map.put(extension, map.get(extension)+1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Integer> e : map.entrySet()) {
			sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
		}
		System.out.println(sb);
	}
}
