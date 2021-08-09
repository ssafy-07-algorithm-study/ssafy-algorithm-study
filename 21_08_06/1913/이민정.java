
//메모리 54464 KB
//시간 624ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913_달팽이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(bf.readLine());
		int find = Integer.parseInt(bf.readLine());

		int snail[][] = new int[N][N];

		// 처음 시작
		int col = N / 2;
		int row = N / 2;
		int moveCnt = 0;

		snail[col][row] = 1; // 첫시작 넣어줌
		int num = 2; // 2부터 배열에 넣으니깐
		int total = N * N; // 배열에 총 몇칸 있는지
		boolean move = true;

		// 달팽이 움직이는 순서 : 위->오른->아래->왼
		while (move) {

			moveCnt++;

			// 위로
			for (int i = 0; i < moveCnt; i++) {
				col--;
				snail[col][row] = num;
				num++;
				if (num > total) {
					move = false;
					break;
				}
			}
			if (!move)
				break;

			// 오른쪽으로
			for (int i = 0; i < moveCnt; i++) {
				row++;
				snail[col][row] = num;
				num++;

			}

			moveCnt++;

			// 아래로
			for (int i = 0; i < moveCnt; i++) {
				col++;
				snail[col][row] = num;
				num++;
			}
			;

			// 왼쪽으로
			for (int i = 0; i < moveCnt; i++) {
				row--;
				snail[col][row] = num;
				num++;
			}

		}

		int c = 0, r = 0;

		// 배열 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(snail[i][j]).append(" ");
				if (snail[i][j] == find) {
					c = i;
					r = j;
				}
			}
			sb.append("\n");
		}
		sb.append((c + 1)).append(" ").append((r + 1));

		System.out.println(sb);
	}
}
