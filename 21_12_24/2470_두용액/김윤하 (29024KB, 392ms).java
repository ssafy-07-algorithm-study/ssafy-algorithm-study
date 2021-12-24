package gold.g5_2470_두용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int start = 0, end = N-1;
		long minSum = Long.MAX_VALUE, n1 = 0, n2 = 0;
		
		while (start != end) {
			long sum = arr[start] + arr[end];
			long absSum = Math.abs(sum);
			if (absSum < minSum) {
				n1 = arr[start];
				n2 = arr[end];
				minSum = absSum;
			}
			if (sum >= 0) end--;
			else start++;
		}
		
		System.out.println(n1 + " " + n2);
		
	}
}
