import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int answerl = 0; int answerr = 0;
		int tmpl = 0; int tmpr = N-1; int sum = Integer.MAX_VALUE; int tmpSum = 0;
		while(tmpl<tmpr) {
			tmpSum = arr[tmpl]+arr[tmpr];
			if(sum>Math.abs(tmpSum)) {
				answerl = tmpl;
				answerr = tmpr;
				sum = Math.abs(tmpSum);
			}
			if(tmpSum<0) tmpl++;
			else tmpr--;
		}
		
		System.out.println(arr[answerl] + " " +arr[answerr]);
	}
	
}
