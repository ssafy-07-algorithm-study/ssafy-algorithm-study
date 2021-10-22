import java.io.*;

//	84704	284
public class BOJ_1436_영화감독숌 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		int ans = 1;

		while (cnt != N) {
			ans++;

			if (Integer.toString(ans).contains("666"))
				cnt++;
		}
		System.out.println(ans);
	}
}
