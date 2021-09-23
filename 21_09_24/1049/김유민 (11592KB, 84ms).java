import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max_one = Integer.MAX_VALUE;
		int max_six = Integer.MAX_VALUE;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			max_six = Math.min(max_six, Integer.parseInt(st.nextToken()));
			max_one = Math.min(max_one, Integer.parseInt(st.nextToken()));
		}
		
		if(max_one*6 < max_six) max_six = max_one*6;
		max_one = Integer.min(max_one*(N%6), max_six);
		int answer = (N/6)*max_six + max_one;
		
		System.out.println(answer);
	}
}
