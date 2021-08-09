package s5_1018_체스판;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];

		for (int n = 0; n < N; n++)
			board[n] = bf.readLine().toCharArray();
		
		int answer = 100;
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				int tempAnswer = 0;
				char current = board[i][j];
				int check = (i+j)%2;
				
				for (int n = i; n < i+8; n++) {
					for (int m = j; m < j+8; m++) {
						
						// check는 시작 위치의 i+j가 짝수인지 홀수인지를 저장
						// check와 현재 위치%2가 같으면 문자도 같아야만 한다
						if (((n+m)%2 == check && board[n][m] != current ||
							((n+m)%2 != check && board[n][m] == current)))
							tempAnswer++;

					}
				}
				tempAnswer = tempAnswer < 64 ? tempAnswer : 64 - tempAnswer;
				
				answer = answer < tempAnswer ? answer : tempAnswer;
			}
		}
		
		System.out.println(answer);
	}
}
