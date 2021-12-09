import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

//	27000	396
public class BOJ_2217_로프 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Integer[] rope = new Integer[N];

		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		// 내림차순 정렬
		Arrays.sort(rope, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

//		Arrays.sort(rope, Comparator.reverseOrder());

		int weight;
		int maxWeight = 0;

		for (int i = 0; i < N; i++) {
			weight = rope[i] * (i + 1);
			maxWeight = Math.max(maxWeight, weight);
		}

		System.out.println(maxWeight);
	}
}
