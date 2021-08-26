import java.io.*;
import java.util.StringTokenizer;

//15012KB 168MS

public class BOJ_18429_근손실 {

	static int N, K;
	static int[] kg;
	static int[] kgCase;
	static boolean[] isSelected;
	static int caseCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		kg = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			kg[i] = Integer.parseInt(st.nextToken());
		}

		isSelected = new boolean[N];
		kgCase = new int[N];
		caseCnt = 0;
		makeCase(0);
		System.out.println(caseCnt);
	}

	private static void makeCase(int cnt) {
		if (cnt == N) {
			checkKG();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			kgCase[cnt] = kg[i];
			isSelected[i] = true;
			makeCase(cnt + 1);
			isSelected[i] = false;
		}

	}

	private static void checkKG() {
		int weight = 500;
		for (int inc : kgCase) {
			if ((weight - K + inc) < 500)
				return;
			weight = weight - K + inc;
		}
		caseCnt++;
	}
}
