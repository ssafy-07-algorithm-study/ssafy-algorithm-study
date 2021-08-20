import java.io.*;
//14684KB 192ms

public class BOJ_3085_사탕게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char candy[][] = new char[N][N];

		for (int i = 0; i < candy.length; i++) {
			candy[i] = br.readLine().toCharArray();
		}

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		int realMaxCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int row = i;
				int col = j;
				for (int d = 0; d < 4; d++) {
					if (row + dx[d] >= 0 && row + dx[d] < N && col + dy[d] >= 0 && col + dy[d] < N) {
						if (candy[row][col] != candy[row + dx[d]][col + dy[d]]) {
							char temp = candy[row][col];
							candy[row][col] = candy[row + dx[d]][col + dy[d]];
							candy[row + dx[d]][col + dy[d]] = temp;

							realMaxCnt = Math.max(realMaxCnt, candyCnt(candy, N));

							candy[row + dx[d]][col + dy[d]] = candy[row][col];
							candy[row][col] = temp;
						}
					}
				}
			}
		}
		System.out.println(realMaxCnt);
	}

	private static int candyCnt(char candy[][], int N) {
		int cnt;
		int maxCnt = 0;
		// 행 기준
		for (int i = 0; i < N; i++) {
			cnt = 0;
			char color = candy[i][0];
			for (int j = 0; j < N; j++) {
				if (candy[i][j] == color) {
					cnt++;
					maxCnt = Math.max(maxCnt, cnt);
				} else {
					color = candy[i][j];
					cnt = 1;
				}
			}
		}
		// 열 기준
		for (int i = 0; i < N; i++) {
			cnt = 0;
			char color = candy[0][i];
			for (int j = 0; j < N; j++) {
				if (candy[j][i] == color) {
					cnt++;
					maxCnt = Math.max(maxCnt, cnt);
				} else {
					color = candy[j][i];
					cnt = 1;
				}
			}
		}
		return maxCnt;
	}
}
