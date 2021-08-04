package argust.oneweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14467_소가길을건너간이유1 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] cow = new int[11];
		int cnt = 0;
		Arrays.fill(cow, -1);
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int state = Integer.parseInt(st.nextToken());
			if (cow[c] == -1) {
				cow[c] = state;
			} else if (cow[c] != state) {
				cnt++;
				cow[c] = state;
			}
		}
		System.out.println(cnt);
	}
}
