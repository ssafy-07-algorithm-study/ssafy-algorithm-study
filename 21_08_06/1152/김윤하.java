// 25312KB, 320ms
package b2_1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int answer = 0;
		
		while(st.hasMoreTokens()) {
			st.nextToken();
			answer++;
		}
		System.out.println(answer);
	}
}
