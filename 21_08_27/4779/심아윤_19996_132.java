package argust.fourweek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_4779_칸토어집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = new String[13];
		str[0] = "-";
		String blank = " ";
		for (int i = 1; i < 13; i++) {
			String s = str[i - 1];
			if (i != 1) {
				String before = blank;
				for (int j = 0; j < 2; j++) {
					blank += before;
				}
			}
			s += blank + str[i - 1];
			str[i] = s;
		}

		String N = "";
		while ((N = in.readLine()) != null) {
			int num = Integer.parseInt(N);
			bw.write(str[num]);
			bw.newLine();
			bw.flush();
		}

	}
}
