import java.io.*;

//	14216	124

public class BOJ_2417_정수제곱근 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		double Q = (double) Math.sqrt(N);

		long result = 0;

		if ((long) Q == Q) {
			result = (long) Q;
		} else {
			result = (long) Q + 1;
		}

		System.out.println(result);
	}
}
