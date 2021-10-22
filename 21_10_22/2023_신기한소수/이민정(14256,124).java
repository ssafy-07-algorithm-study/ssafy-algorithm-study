import java.io.*;

//	14256	124

public class BOJ_2023_신기한소수 {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs("", 0);
	}

	private static void dfs(String str, int cnt) {

		if (cnt == N) {
			System.out.println(str);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (isPrime(Integer.parseInt(str + i))) {
				dfs(str + i, cnt + 1);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num == 1)
			return false;

		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0)
				return false;
		}

		return true;
	}
}
