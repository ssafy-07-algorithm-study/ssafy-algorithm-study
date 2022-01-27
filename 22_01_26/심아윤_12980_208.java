package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20055_컨베이어벨트위의로봇 {

	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = 2 * N;
		int[] arr = new int[M];
		boolean[] robot = new boolean[N];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int time = 0; // 시작 - 1단계

		while (cnt < K) {
			time++; // 1단계
			rotate(arr, M, N, robot); // 1. 벨트 회전
			go(robot, arr, N); // 2. 로봇 이동
			if (arr[0] > 0) { // 3. 로봇 올리기 - 올리는 위치
				arr[0] -= 1;
				if (arr[0] == 0)
					cnt++;
				robot[0] = true;
			}
		}
		System.out.println(time); // 결과 출력
	}

	// 로봇 이동
	private static void go(boolean[] robot, int[] arr, int N) {
		for (int i = N - 1; i >= 0; i--) { // 로봇이 먼저 올라간 순서로
			if (i == N - 1) { // 내리는 위치
				robot[N - 1] = false;
				continue;
			}
			if (robot[i]) { // 로봇이 있다면
				if (!robot[i + 1] && arr[i + 1] >= 1) { // 2-1.이동이 가능하면
					arr[i + 1] -= 1; // 내구도 감소
					if (arr[i + 1] == 0)
						cnt++;
					robot[i] = false;
					robot[i + 1] = true; // 이동
				}
			}
		}
	}

	// 각 벨트의 회전
	private static void rotate(int[] arr, int M, int N, boolean[] robot) {
		int temp = arr[M - 1];
		for (int i = M - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = temp;
		// 벨트 이동과 함께 로봇 이동
		for (int i = N - 2; i >= 0; i--) {
			robot[i + 1] = robot[i];
		}
		robot[0] = false;
	}
}
