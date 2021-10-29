import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int before = 3, after = 3;
		int k=0;
	
		while(after<N) {	//K 구하기
			k++;
			before = after;
			after = before*2+3+k;
		}
		moo(N, k, before);
	}
	
	public static void moo(int n, int k, int before) {
		if(n<=3) {
			if(n==1) System.out.println("m");
			else System.out.println("o");
			return;
		}
		if(before+k+3>=n && before<n) {	//o가 k+2개인 수열일 경우
			if(before+1==n) System.out.println("m");
			else System.out.println("o");
			return;
		} else if(before+k+3<n){	//두 번째(오른쪽) 재귀수열일 경우
			n -= (before+k+3);
		}
		k--;
		before = (before-k-3)/2;
		moo(n, k, before);
	}
}
