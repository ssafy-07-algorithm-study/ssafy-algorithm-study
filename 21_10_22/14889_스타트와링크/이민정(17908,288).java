import java.io.*;
import java.util.StringTokenizer;

//  	17908	288

public class BOJ_14889_스타트와링크 {

	static int N, power[][];
	static int[] startTeam, linkTeam;// 스타트팀과 링크팀
	static int minDiff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		power = new int[N][N];
		startTeam = new int[N / 2];
		linkTeam = new int[N / 2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minDiff = Integer.MAX_VALUE;

		comb(0, 0);
		System.out.println(minDiff);
	}

	private static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			int idx = 0;
			for (int j = 0; j < N; j++) {
				boolean contain = false;
				for (int i = 0; i < N / 2; i++) {
					if (startTeam[i] == j)
						contain = true;
				}
				if (!contain)
					linkTeam[idx++] = j;
			}
			comparePower();
			return;
		}

		for (int i = start; i < N; i++) {
			startTeam[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	private static void comparePower() {
		int startPower = 0;
		int linkPower = 0;

		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				startPower += power[startTeam[i]][startTeam[j]];
				startPower += power[startTeam[j]][startTeam[i]];
				linkPower += power[linkTeam[i]][linkTeam[j]];
				linkPower += power[linkTeam[j]][linkTeam[i]];
			}
		}

		minDiff = Math.min(minDiff, Math.abs(startPower - linkPower));
	}

}
