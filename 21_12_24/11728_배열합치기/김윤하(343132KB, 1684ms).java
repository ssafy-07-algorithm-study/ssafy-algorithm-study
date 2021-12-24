package silver.s5_11728_배열합치기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		while(N-- > 0) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		while(M-- > 0) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int a : arr)
			sb.append(a).append(" ");
		
		System.out.println(sb.toString());
	}
}
