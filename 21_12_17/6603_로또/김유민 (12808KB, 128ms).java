import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			int []arr = new int[N];
			int []select = new int[6];
			
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			Combination(0, 0, arr, select);
			System.out.println();
		}
	}
	
	public static void Combination(int cnt, int start, int []arr, int []select) {
		if(cnt == 6) {
			StringBuilder sb = new StringBuilder();
			for(int i:select) sb.append(arr[i]).append(" ");
			System.out.println(sb);
			return;
		}
		else {
			for(int i=start;i<N;i++) {
				select[cnt] = i;
				Combination(cnt+1, i+1, arr, select);
			}
		}
	}
}
