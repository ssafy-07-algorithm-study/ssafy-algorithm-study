package december.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2417_정수제곱근 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(in.readLine());
		long result = (long) Math.sqrt(N);
		if ((long) Math.pow(result, 2) >= N)
			System.out.println(result);
		else
			System.out.println(result + 1);
	}
}
