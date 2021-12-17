import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int K;
	static int[] arr, res;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			
			arr = new int[K];
			res = new int[6];
			for(int i = 0; i < K; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			comb(0, 0);
			System.out.println(sb);
		}
		
	}
	
	static public void comb(int cnt, int start) {
		
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return ;
		}
		
		for(int i = start; i < K; i++) {
			res[cnt] = arr[i];
			comb(cnt+1, i+1);			
		}
	}
}
