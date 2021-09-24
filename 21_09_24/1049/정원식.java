
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		
		int[][] arr = new int[M][2];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 1. pack
		int minPack = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			minPack = Math.min(minPack, arr[i][0]);
		}
		if(N % 6 == 0) {
			min = minPack * (N/6);
		} else {
			min = minPack * (N/6 + 1);
		}
		
		// 2. 낱
		int minNat = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			minNat = Math.min(minNat, arr[i][1]);
		}
		min = Math.min(min, minNat*N);
		
		// 3. pack + 낱
		min = Math.min(min, (minPack*(N/6)) + (minNat*(N%6)));
		
		System.out.println(min);

	}
}
