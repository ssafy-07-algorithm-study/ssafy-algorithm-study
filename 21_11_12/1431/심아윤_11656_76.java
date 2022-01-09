package november.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B_1431_시리얼번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.readLine();
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					// 2. 숫자만의 합으로
					int len = o1.length(); // 길이가 같으므로
					int sum1 = 0;
					int sum2 = 0;
					for (int i = 0; i < len; i++) {
						int num = o1.charAt(i) - '0';
						if (num >= 0 && num <= 9)
							sum1 += num;
						num = o2.charAt(i) - '0';
						if (num >= 0 && num <= 9)
							sum2 += num;
					}
					if (sum1 == sum2) {
						// 3. 사전순 (숫자 -> 알파벳)
						return o1.compareTo(o2);
					}
					return Integer.compare(sum1, sum2);
				}
				return Integer.compare(o1.length(), o2.length());
			}

		});

		for (int i = 0; i < N; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}
}
