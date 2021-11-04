import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//	34896	364

public class BOJ_23322_초콜릿뺏어먹기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] tong = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			tong[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(tong);

		int day = 0;
		int choco = 0;
		int i = K + 1;
		boolean eat;

		while (true) {
			eat = false;
			if (tong[i] == 1 || tong[i] == tong[i - K]) {
				i++;
				if (i > N)
					break;
			}
			while (tong[i] != tong[i - K]) {
				tong[i]--;
				choco++;
				eat = true;
			}
			Arrays.sort(tong);
			if (eat)
				day++;
		}

		System.out.println(choco + " " + day);

	}
}
