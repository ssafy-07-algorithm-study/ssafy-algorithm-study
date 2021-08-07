import java.io.*;
import java.util.Arrays;

public class BOJ_2750_수정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 몇개의 수를 읽을지
		int[] arr = new int[N]; // N개 크기의 배열 생성

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr); // 배열 오름차순 정렬

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
