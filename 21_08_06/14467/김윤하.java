// 14156KB, 132ms
package s5_14467;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		int[] cow = new int[10];
		Arrays.fill(cow, -1);
		
//		BufferedReader br = new BufferedReader(new FileReader("src/s5_14467/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), answer = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cowNumber = Integer.parseInt(st.nextToken()) - 1;
			int observetaionResult = Integer.parseInt(st.nextToken());
			
			if (cow[cowNumber] != -1 && cow[cowNumber] != observetaionResult)
				answer++;
			cow[cowNumber] = observetaionResult;
		}
		System.out.print(answer);
	}
}
