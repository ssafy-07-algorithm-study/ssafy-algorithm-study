import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//14460	136
public class BOJ_16435_스네이크버드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 과일의 개수
		int L = Integer.parseInt(st.nextToken()); // 스네이크버드의 초기 길이

		int[] fruits = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fruits); // 오름차순 정렬

		for (int i = 0; i < N; i++) {
			if (fruits[i] <= L)
				L++;
			else
				break;
		}

		System.out.println(L);
	}
}
