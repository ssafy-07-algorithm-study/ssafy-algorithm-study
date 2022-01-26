import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트 {
	static class Belt {
		int power;
		boolean isRobot;

		public Belt(int power, boolean isRobot) {
			super();
			this.power = power;
			this.isRobot = isRobot;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Belt[][] cb = new Belt[2][N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int power = Integer.parseInt(st.nextToken());
			cb[0][i] = new Belt(power, false);
		}
		for (int i = N - 1; i >= 0; i--) {
			int power = Integer.parseInt(st.nextToken());
			cb[1][i] = new Belt(power, false);
		}

		int zeroPower = 0;
		int step = 0;

		while (zeroPower < K) {
			step++;

			// 벨트 이동
			Belt temp = cb[0][0];
			cb[0][0] = cb[1][0];
			for (int i = 1; i < N; i++) {
				cb[1][i - 1] = cb[1][i];
			}
			cb[1][N - 1] = cb[0][N - 1];
			for (int i = N - 2; i > 0; i--) {
				cb[0][i + 1] = cb[0][i];
			}
			cb[0][1] = temp;

			// 내리는 위치에 로봇 있으면 바로 내림
			cb[0][N - 1].isRobot = false;

			// 벨트에 먼저 올라간 로봇부터 벨트가 회전하는 방향으로 이동
			for (int i = N - 2; i >= 0; i--) {
				if (cb[0][i].isRobot) {
					if (!cb[0][i + 1].isRobot && cb[0][i + 1].power > 0) {
						cb[0][i].isRobot = false;
						cb[0][i + 1].isRobot = true;
						cb[0][i + 1].power--;
						if (cb[0][i + 1].power == 0)
							zeroPower++;

						// 내리는 위치이므로
						if ((i + 1) == N - 1) {
							cb[0][i + 1].isRobot = false;
						}

					}
				}
			}

			// 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇 올림
			if (!cb[0][0].isRobot && cb[0][0].power > 0) {
				cb[0][0].isRobot = true;
				cb[0][0].power--;
				if (cb[0][0].power == 0)
					zeroPower++;

			}

		}

		System.out.println(step);

	}
}
