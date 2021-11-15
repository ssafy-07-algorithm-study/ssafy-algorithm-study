import java.io.*;
import java.util.*;

public class BOJ_16960_스위치와램프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 스위치 개수
		int M = Integer.parseInt(st.nextToken()); // 램프 개수

		List<int[]> switchs = new ArrayList<int[]>();

		int[] lamp = new int[M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int connect = Integer.parseInt(st.nextToken());
			int list[] = new int[connect];
			for (int j = 0; j < connect; j++) {
				int num = Integer.parseInt(st.nextToken());
				list[j] = num;
				lamp[num]++;
			}
			switchs.add(list);
		}

		for (int i = 0; i < N; i++) {
			boolean flag = true;
			int list[] = switchs.get(i);

			int copyLamp[] = new int[M + 1];
			for (int j = 1; j <= M; j++) {
				copyLamp[j] = lamp[j];
			}

			for (int k : list) {
				if (--copyLamp[k] == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println('1');
				return;
			}
		}

		System.out.println('0');
	}
}
