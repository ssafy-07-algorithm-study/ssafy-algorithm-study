package study.algo.boj0813;
// 14900	160
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_2750_수정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(in.readLine()));
		}
		
		Collections.sort(list);
		for(int i = 0; i < N; i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
