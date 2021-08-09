import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int COL = Integer.parseInt(st.nextToken());
		int ROW = Integer.parseInt(st.nextToken());

		char[][] BOARD = new char[COL][ROW];

		for (int i = 0; i < COL; i++) {
			String str = br.readLine();
			for (int j = 0; j < ROW; j++) {
				BOARD[i][j] = str.charAt(j);
			}
		}

		int changeCnt, changeCntB, changeCntW;
		int minChange = 64; // 배열을 다 바꿔야되는 상황이 최대니깐

		for (int i = 0; i < COL - 7; i++) {
			for (int j = 0; j < ROW - 7; j++) {
//				changeCnt = 0;
				changeCntB = 0;
				changeCntW = 0;
				char start = BOARD[i][j];
				// 8*8 배열 만들어가면서 최소 변화 개수 찾음
				for (int n = 0; n < 8; n++) {
					for (int m = 0; m < 8; m++) {
						// B로 시작할 경우
						if (n % 2 == 0) { // 홀수줄
							if ((m % 2 == 0) && (BOARD[i + n][j + m]) != 'B') // 홀수칸
								changeCntB++;
							if ((m % 2 != 0) && (BOARD[i + n][j + m]) != 'W') // 짝수칸
								changeCntB++;
						} else { // 짝수줄
							if ((m % 2 == 0) && (BOARD[i + n][j + m]) != 'W')
								changeCntB++;
							if ((m % 2 != 0) && (BOARD[i + n][j + m]) != 'B')
								changeCntB++;
						}

						// W로 시작할 경우
						if (n % 2 == 0) { // 홀수줄
							if ((m % 2 == 0) && (BOARD[i + n][j + m]) != 'W')
								changeCntW++;
							if ((m % 2 != 0) && (BOARD[i + n][j + m]) != 'B')
								changeCntW++;
						} else { // 짝수줄
							if ((m % 2 == 0) && (BOARD[i + n][j + m]) != 'B')
								changeCntW++;
							if ((m % 2 != 0) && (BOARD[i + n][j + m]) != 'W')
								changeCntW++;
						}

					}
				}
				minChange = changeCntB < minChange ? changeCntB : minChange;
				minChange = changeCntW < minChange ? changeCntW : minChange;
			}
		}
		System.out.println(minChange);
	}
}
