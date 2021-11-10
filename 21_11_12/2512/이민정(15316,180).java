import java.io.*;
import java.util.StringTokenizer;

//15316	180
public class BOJ_2512_예산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 지방의 수

		int[] arr = new int[N];
		int max = 0;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}

		int M = Integer.parseInt(br.readLine()); // 총 예산

		// 총 합이 총 예산보다 작거나 같으면
		if (sum <= M) {
			// 최대값을 상한액으로
			System.out.println(max);
		} else { // 총 예산보다 커버리면
			int ans = 0; // 상한액
			int avg = 0; // 평균
			int min = 0; // 최소값
			while (true) {
				avg = (max + min) / 2; // 최대와 최소값의 평균을 상한액으로 정함
				System.out.println("avg : " + avg + ", max : " + max + ", min : " + min);
				if (avg == min) // 최소값과 평균이 같으면 끝~!
					break;

				// avg를 상한액으로 하는 총합 구하기
				int total = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i] < avg) {
						total += arr[i];
					} else {
						total += avg;
					}
				}

				if (total <= M) { // 총합이 총예산보다 작거나 같으면
					min = avg; // 최소값을 평균으로하고
					ans = Math.max(ans, avg); // 최대상한액 구하기 위해
				} else {
					max = avg;
				}
			}

			System.out.println(ans);
		}

	}
}
