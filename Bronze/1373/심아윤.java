package argust.oneweek;
// 50340KB	432ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B_1373_2진수8진수 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) { // 배열 반대로 넣음
			stack.push(str.charAt(i) - '0');
		}
		List<Integer> result = new ArrayList<Integer>();
		int cnt = 1, sum = 0;
		while (!stack.empty()) {
			sum += stack.pop() * cnt;
			cnt *= 2;
			if (cnt > 4) {
				cnt = 1;
				result.add(sum);
				sum = 0;
			}
		}
		if (sum > 0)
			result.add(sum);
		if (result.size() == 0) // 0일 경우 **
			sb.append(0);
		else {
			for (int i = result.size() - 1; i >= 0; i--)
				sb.append(result.get(i));
		}
		System.out.println(sb);
	}
}
