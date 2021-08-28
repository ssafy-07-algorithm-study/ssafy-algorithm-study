package september.oneweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2477_참외밭 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] arr = new int[6];
		int K = Integer.parseInt(in.readLine());
		int even = 0, odd = 0; // 가장 긴 세로와 가로
		int eidx = 0, oidx = 0; // 그 인덱스

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			arr[i] = len;
			if (i % 2 == 0) { // 짝
				if (even < arr[i]) {
					even = arr[i];
					eidx = i;
				}
			} else { // 홀
				if (odd < arr[i]) {
					odd = arr[i];
					oidx = i;
				}
			}
		}

		int x = 0, y = 0; // 작은 사각형
		// 가장 긴 줄 옆이 안쪽 사각형의 변이 아님.
		// 그 두 변을 뺀 값이 안쪽 변
		if (eidx == 0) {
			int idx = (eidx - 1) + 6;
			x = Math.abs(arr[idx] - arr[(eidx + 1) % 6]);
			y = Math.abs(arr[oidx - 1] - arr[(oidx + 1) % 6]);
		} else if (oidx == 0) {
			int idx = (oidx - 1) + 6;
			x = Math.abs(arr[idx] - arr[(oidx + 1) % 6]);
			y = Math.abs(arr[eidx - 1] - arr[(eidx + 1) % 6]);
		} else {
			x = Math.abs(arr[oidx - 1] - arr[(oidx + 1) % 6]);
			y = Math.abs(arr[eidx - 1] - arr[(eidx + 1) % 6]);
		}
		int result = ((even * odd) - (x * y)) * K;
		System.out.println(sb.append(result));
	}

}
