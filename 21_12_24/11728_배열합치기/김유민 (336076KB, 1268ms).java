import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int []a = new int[N];
		int []b = new int[M];
		int []answer = new int[N+M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) a[i]= Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) b[i]= Integer.parseInt(st.nextToken());
		
		int i=0; int j=0;
		for(int c=0;c<N+M;c++) {
			if(i==N) {
				while (j<M) answer[c++] = b[j++];
				break;
			}
			else if(j==M) {
				while (i<N) answer[c++] = a[i++];
				break;
			}
			else if(a[i]>b[j]) answer[c]=b[j++];
			else answer[c] = a[i++];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int c=0;c<N+M;c++) sb.append(answer[c]).append(" ");
		System.out.println(sb);
	}
}
