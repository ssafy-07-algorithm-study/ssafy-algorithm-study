import java.io.*;

//14216	132	
// T->S로 가는거 찾는게 훨 효율적!!

public class BOJ_12919_A와B2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();

		System.out.println(check(S, T));
	}

	private static int check(String S, String T) {
		// S랑 같으면 종료
		if (T.length() == S.length()) {
			if (T.equals(S)) {
				return 1;
			}
			return 0;
		}

		int result = 0;

		if (T.charAt(T.length() - 1) == 'A') {
			result += check(S, T.substring(0, T.length() - 1));
		}

		if (T.charAt(0) == 'B') {
			result += check(S, new StringBuffer(T.substring(1, T.length())).reverse().toString());
		}

		return result > 0 ? 1 : 0;
	}
}
