import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int []arr = new int[1001];
		int a=0; int b=0; int max=0; int sum=0; int sumMax=0; int answerS = 0; int answerE = T;
		
		for(int n=0;n<N;n++) {
			int K = Integer.parseInt(br.readLine());
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				max = max>b?max:b;
				for(int i=a;i<b;i++) arr[i]++;
			}
		}
		
		for(int i=0;i<T;i++) sum += arr[i];
		sumMax = sum;
	
		for(int i=T;i<max;i++) {
			sum+=arr[i];
			sum -= arr[i-T];
			if(sum > sumMax) {
				sumMax = sum;
				answerE = i+1;
				answerS = answerE-T;
			}
		}
		
		System.out.println(answerS + " "+answerE);
	}	//main
}
