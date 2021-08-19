package s4_1755_숫자놀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] eng = { "zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine " };
		
		StringTokenizer strT = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(strT.nextToken());
		int N = Integer.parseInt(strT.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int m = M; m <= N; m++)
			list.add(m);
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				String s1 = o1 < 10 ? eng[o1] : eng[o1/10] + eng[o1%10];
				String s2 = o2 < 10 ? eng[o2] : eng[o2/10] + eng[o2%10];
				
				return s1.compareTo(s2);
			}
			
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
			if (i % 10 == 9)
				System.out.println();
		}
	}
}
