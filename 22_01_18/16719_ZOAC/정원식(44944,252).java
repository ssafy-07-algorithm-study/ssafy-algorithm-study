import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_ZOAC {
	
	static class Str implements Comparable<Str> {
		int i;
		String s;
		public Str(int i, String s) {
			super();
			this.i = i;
			this.s = s;
		}
		@Override
		public int compareTo(Str o) {
			return this.s.compareTo(o.s);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] arr = br.readLine().toCharArray();
		boolean[] visited = new boolean[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			
			sb.setLength(0);
			List<Str> list = new ArrayList<Str>();
			for(int j = 0; j < arr.length; j++) {
				
				if(!visited[j]) {
					String string = "";
					for(int k = 0; k < arr.length; k++) {
						if(j == k || visited[k]) {
							string += arr[k];
						}
					}
					list.add(new Str(j, string));
				}
				
			}
			Collections.sort(list);
			sb.append(list.get(0).s);
			visited[list.get(0).i] = true;
			System.out.println(sb);
		}
	}
}
