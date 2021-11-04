import java.io.*;

//	15648	152

public class BOJ_10799_쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int piece = 0;
		int total = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(') {
				piece++;
			} else {
				piece--;

				if (str.charAt(i - 1) == '(') { // 레이저
					total += piece;
				} else { // ')' 였을 때
					total += 1;
				}
			}
		}

		System.out.println(total);

	}
}
