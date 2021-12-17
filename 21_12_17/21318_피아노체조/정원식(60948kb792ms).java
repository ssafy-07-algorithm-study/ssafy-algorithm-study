import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//누적 실수 배열
		int[] psum = new int[N+1];
		for(int i = 1; i < N; i++) {	// 마지막은 고려하지 않아도 됨.(실수하지 않음)
			psum[i] = (arr[i] > arr[i+1]) ? 1 : 0;	// 실수하면 1 저장
			psum[i] += psum[i-1];	// 누적합
		}
		//psum[N] = psum[N-1];
		
//		System.out.println(Arrays.toString(psum));
		
		int Q = Integer.parseInt(br.readLine());
		
		for(int q = 0; q < Q; q++) {
			int res = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			res = prefixSum(x, y, psum);
						
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int prefixSum(int l, int r, int[] psum) {
		
		if(l==r) return 0;
		
		int first = l - 1;
		
		int last = r - 1;
		
//		System.out.println(first + " " + last);
		return psum[last] - psum[first];
	}
}
