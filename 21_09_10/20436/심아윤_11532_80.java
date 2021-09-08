package september.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_20436_ZOAC3 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Character, int[]> keyboard = new HashMap<>();
		keyboard.put('q', new int[] { 0, 0, 0 }); // 위치 y,x/좌우확인
		keyboard.put('w', new int[] { 0, 1, 0 });
		keyboard.put('e', new int[] { 0, 2, 0 });
		keyboard.put('r', new int[] { 0, 3, 0 });
		keyboard.put('t', new int[] { 0, 4, 0 });
		keyboard.put('y', new int[] { 0, 5, 1 });
		keyboard.put('u', new int[] { 0, 6, 1 });
		keyboard.put('i', new int[] { 0, 7, 1 });
		keyboard.put('o', new int[] { 0, 8, 1 });
		keyboard.put('p', new int[] { 0, 9, 1 });
		keyboard.put('a', new int[] { 1, 0, 0 });
		keyboard.put('s', new int[] { 1, 1, 0 });
		keyboard.put('d', new int[] { 1, 2, 0 });
		keyboard.put('f', new int[] { 1, 3, 0 });
		keyboard.put('g', new int[] { 1, 4, 0 });
		keyboard.put('h', new int[] { 1, 5, 1 });
		keyboard.put('j', new int[] { 1, 6, 1 });
		keyboard.put('k', new int[] { 1, 7, 1 });
		keyboard.put('l', new int[] { 1, 8, 1 });
		keyboard.put('z', new int[] { 2, 0, 0 });
		keyboard.put('x', new int[] { 2, 1, 0 });
		keyboard.put('c', new int[] { 2, 2, 0 });
		keyboard.put('v', new int[] { 2, 3, 0 });
		keyboard.put('b', new int[] { 2, 4, 1 });
		keyboard.put('n', new int[] { 2, 5, 1 });
		keyboard.put('m', new int[] { 2, 6, 1 });

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		char SL = st.nextToken().charAt(0);
		char SR = st.nextToken().charAt(0);
		String str = in.readLine();
		int size = str.length();
		int result = size; // 클릭할 때 시간 1 이므로 길이만큼의 시간을 먼저 더한다.
		for (int i = 0; i < size; i++) {
			char alpha = str.charAt(i);
			int[] now = keyboard.get(alpha);
			if (now[2] == 0) { // 왼쪽 손
				int[] left = keyboard.get(SL);
				result += Math.abs(left[0] - now[0]) + Math.abs(left[1] - now[1]);
				SL = alpha;
			} else { // 오른쪽 손
				int[] right = keyboard.get(SR);
				result += Math.abs(right[0] - now[0]) + Math.abs(right[1] - now[1]);
				SR = alpha;
			}
		}
		System.out.println(sb.append(result));
	}
}
