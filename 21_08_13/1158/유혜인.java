

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 요세푸스 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		boolean[] arr = new boolean[n];
		int cnt = 0; // 이게 n이면 끝
		int curr = -1;
		int jump = 0;
		sb.append("<");
		
		while(true) {
			curr++;
			if(curr == n) {
				curr = 0;
			}
			if(arr[curr])	continue;
			else {
				jump++;
				if(jump == k) {
					jump = 0;
					cnt++;
					arr[curr] = true;
					sb.append((curr+1)+", ");
				}
			}
			if(cnt == n)	break;
			
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());
		

	}

}
