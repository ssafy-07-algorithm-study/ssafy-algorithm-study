package august.threeweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_3085_사탕게임 {
	static int Max = Integer.MIN_VALUE;
	static int N;
	static char[][] arr;

	public static void main(String[] args) throws Exception { // 오른쪽, 아래 방향만 탐색
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				if (j + 1 < N && arr[i][j] != arr[i][j + 1]) { // 바꾸지 않았을 경우를 포함하여 계산하기 위해
				if (j + 1 < N) {
					temp(i, j, i, j + 1); // 수평
					// 바꾸는 부분에 영향을 받는 부분의 행과 열만 계산
					Max = Math.max(Max, verticality(j)); // 수직
					Max = Math.max(Max, verticality(j + 1));
					Max = Math.max(Max, horizontality(i)); // 수평
					temp(i, j + 1, i, j);
				}
//				if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {
				if (i + 1 < N) {
					temp(i, j, i + 1, j); // 수직
					Max = Math.max(Max, horizontality(i)); // 수평
					Max = Math.max(Max, horizontality(i + 1));
					Max = Math.max(Max, verticality(j)); // 수직
					temp(i + 1, j, i, j);
				}
			}
		}

		System.out.println(sb.append(Max));
	}

	private static int verticality(int j) {
		int mmax = 0;
		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i][j] == arr[i + 1][j])
				cnt++;
			else
				cnt = 1;
			mmax = Math.max(mmax, cnt); // 이렇게 해야지 1로 바뀌어도 최댓값을 실시간으로 계산할 수 있다.
		}
		return mmax;
	}

	private static int horizontality(int i) {
		int mmax = 0;
		int cnt = 1;
		for (int j = 0; j < N - 1; j++) {
			if (arr[i][j] == arr[i][j + 1])
				cnt++;
			else
				cnt = 1;
			mmax = Math.max(mmax, cnt);
		}
		return mmax;
	}

	private static void temp(int s1, int e1, int s2, int e2) {
		char tmp = arr[s1][e1];
		arr[s1][e1] = arr[s2][e2];
		arr[s2][e2] = tmp;
	}

}
