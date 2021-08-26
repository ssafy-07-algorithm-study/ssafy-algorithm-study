import java.io.*;

public class BOJ_4779_칸토어집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			int len = (int) Math.pow(3, N);

			char[] cantor = new char[len];

			for (int i = 0; i < len; i++)
				cantor[i] = ' ';

			divide(cantor, 0, len - 1, len);

			System.out.println(cantor);
		}
	}

	private static void divide(char[] cantor, int start, int end, int len) {
		if (len == 1)
			cantor[start] = '-';
		else {
			int temp = len / 3;

			divide(cantor, start, start + temp - 1, temp);
			divide(cantor, end - temp + 1, end, temp);
		}
	}
}
