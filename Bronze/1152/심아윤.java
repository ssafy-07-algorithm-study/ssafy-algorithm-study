package argust.oneweek;
//	25692KB	208ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1152_단어의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int cnt = 0;
		while (st.hasMoreTokens()) {
			st.nextToken();
			cnt++;
		}
		System.out.println(cnt);
	}
}
