import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev=0, now=0;
		for(int i=1;i<=N;i++) {
			if(i==1) prev = Integer.parseInt(st.nextToken());
			else {
				if(i!=2) prev = now;
				now = Integer.parseInt(st.nextToken());
				if(prev>now) arr[i] = arr[i-1]+1;
				else arr[i] = arr[i-1];
			}
		}
		int Q = Integer.parseInt(br.readLine());
		int x, y;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			sb.append(arr[y]-arr[x]).append("\n");
		}
		System.out.println(sb);
	}
}
