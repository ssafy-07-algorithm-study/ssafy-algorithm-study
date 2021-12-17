package silver.s4_2217_로프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
//		ArrayList<Integer> arr = new ArrayList<>(N);
		
		
		for (int i = 0; i < N; i++) {
			int in = Integer.parseInt(br.readLine());
			arr[i] = in;
		}
		
		Arrays.sort(arr);
		int answer = arr[0] * (N);
		
		for (int i = 1; i < N; i++)
			answer = Math.max(answer, arr[i] * (N-i));
		
		System.out.println(answer);
	}
}
