import java.io.*;
import java.util.*;

//	14240	132

public class BOJ_1431_시리얼번호 {

	static class serialNum implements Comparable<serialNum> {
		int len;
		int sum;
		String serial;

		public serialNum(int len, int sum, String serial) {
			super();
			this.len = len;
			this.sum = sum;
			this.serial = serial;
		}

		@Override
		public int compareTo(serialNum o) {
			if (this.len != o.len) {
				return this.len - o.len;
			} else if (this.len == o.len && this.sum != o.sum) {
				return this.sum - o.sum;
			}
			return this.serial.compareTo(o.serial);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		List<serialNum> guitar = new ArrayList<serialNum>();
		for (int i = 0; i < N; i++) {
			String sn = br.readLine();
			int sum = 0;
			for (int j = 0; j < sn.length(); j++) {
				int num = sn.charAt(j) - '0';
				if (num >= 0 && num <= 9) {
					sum += num;
				}
			}
			guitar.add(new serialNum(sn.length(), sum, sn));
		}

		Collections.sort(guitar);

		for (serialNum sN : guitar) {
			sb.append(sN.serial).append("\n");
		}

		System.out.println(sb);
	}
}
