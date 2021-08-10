

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class À±Èñ¿µ_294784KB_648ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a= br.readLine();
		StringTokenizer st = new StringTokenizer(a, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		Queue<Integer>qu = new LinkedList<Integer>();
		
		for(int i=1; i<= N; i++) {
			qu.offer(i);		
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while(qu.size() > 1) {
			for(int i=0; i< M-1; i++) {
				qu.offer(qu.poll());
			}
			sb.append(qu.poll()).append(", ");
			
		}
		sb.append(qu.poll()).append('>');
		System.out.println(sb);

	}

}
