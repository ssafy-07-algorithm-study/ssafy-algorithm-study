import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		System.out.println(bfs(S, T));
	}
	
	public static int bfs(String S, String T) {
		Queue<String> queue = new LinkedList<>();
		String tmp = "";
		queue.add(T);
		while(!queue.isEmpty()) {
			tmp = queue.poll();
			if(tmp.equals(S)) return 1;
			if(S.length()>tmp.length()) return 0;
			if(tmp.charAt(tmp.length()-1)=='A') queue.add(tmp.substring(0,tmp.length()-1));
			if(tmp.charAt(0)=='B') {
				StringBuilder sb = new StringBuilder();
				sb.append(tmp).reverse();
				queue.add(sb.substring(0,sb.length()-1));
			}
		}
		return 0;
	}
}
