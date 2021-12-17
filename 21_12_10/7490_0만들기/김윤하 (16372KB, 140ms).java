package gold.g5_7490_0만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static StringBuilder answerSb = new StringBuilder();
	static String[] modeString = { " ", "+", "-" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder("1");
			cal(0, sb, 1, -1, 1);
			answerSb.append("\n");
		}
		System.out.println(answerSb);
	}

	static void cal(int result, StringBuilder sb, int depth, int preMode, int calNum) {
		if (depth == N) {
			if (preMode == 1)
				result += calNum;
			else if (preMode == 2)
				result -= calNum;
			else if (preMode == -1)
				result = calNum;
			
			if (result == 0)
					answerSb.append(sb).append("\n");
			return;
		}

		String currentString = sb.toString();
		for (int mode = 0; mode < 3; mode++) {
			StringBuilder nextSb = new StringBuilder(currentString);
			int nextResult = result, nextMode = preMode, nextCalNum = calNum;

			if (mode == 0) { // ' '일 때
				StringBuilder calSb = new StringBuilder();

				calSb.append(calNum).append(depth+1);
				nextCalNum = Integer.parseInt(calSb.toString());
			}
			if (mode == 1 || mode == 2) { // +, -일 때
				if (preMode == 1 || preMode == -1)
					nextResult += calNum;
				else if (preMode == 2)
					nextResult -= calNum;
				nextMode = mode;
				nextCalNum = depth+1;
			}
			

			nextSb.append(modeString[mode]).append(depth + 1);
			cal(nextResult, nextSb, depth + 1, nextMode, nextCalNum);
		}

	}
}
