import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			Set<Integer> set = new HashSet<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) set.add(Integer.parseInt(st.nextToken()));
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (set.contains(tmp)) sb.append("1\n");
				else sb.append("0\n");
			}			
		}
		System.out.println(sb.toString());
	}
}
