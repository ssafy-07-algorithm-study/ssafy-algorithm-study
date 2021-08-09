package s5_1158_요세푸스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 순서대로 K번째 사람을 제거하면 되므로, 현재 제거한 사람을 제외한 다음 K 번째 사람, 즉 K-1만큼 다음 사람을 제거
		// 이 때 남아있는 인원수 만큼 k %= N
		StringTokenizer strT = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(strT.nextToken());
		int K = Integer.parseInt(strT.nextToken());
		
		
		ArrayList<Integer> people = new ArrayList<>(N);
		for (int i = 0; i < N; i++)
			people.add(i+1);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append('<');
		for (int k = K-1, n = N; ; k += K-1, k %= --n) {
			sb.append(people.get(k));
			people.remove(k);
			
			if (people.isEmpty())
				break;
			sb.append(", ");
			
		}
		sb.append('>');
		System.out.print(sb.toString());
	}
	
}
