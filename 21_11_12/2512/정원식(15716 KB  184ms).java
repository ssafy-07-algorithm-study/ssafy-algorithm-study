//15716 KB  184ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr[N-1];
		int res = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			for(int bud : arr) {
//				if(bud >= mid) sum += mid;
//				else sum += bud;
				sum += Math.min(bud, mid);
			}
			if(sum > M) right = mid - 1;
			else {
				left = mid + 1;
				res = Math.max(res, mid);
			}
		}
		System.out.println(res);
	}
}
