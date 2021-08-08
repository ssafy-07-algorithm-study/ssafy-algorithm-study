// 12480KB / 108ms
package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()) - 1;
		List<Integer> array = new ArrayList<>();
		for (int i = 1; i<=N; i++) array.add(i);
		
		int size = array.size();
		int index = 0;
		while (size > 0) {
			index += K;
			index %= size;
			
			answer.append(array.remove(index)).append(", ");
			size--;
		}
		System.out.println("<" + answer.toString().substring(0, answer.toString().length() - 2)+">");
	}
}
