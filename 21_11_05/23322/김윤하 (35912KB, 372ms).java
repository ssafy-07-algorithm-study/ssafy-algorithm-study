package silver.s2_23322_초콜릿뺏어먹기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int maxCho = 0;
		int minDay = 0;
		
		int[] cho = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cho[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = K;
		while(true) {
			while (index < N && cho[index] == cho[index-K]) {
				index++;
				
			}
			if (index >= N) break;
			
			maxCho += cho[index] - cho[index-K];
			cho[index] = cho[index-K];
			minDay++;
			
			// 굳이 sort 안해도 된다 (안하면 160ms인 듯)
			Arrays.sort(cho);
		}
		
		System.out.println(maxCho + " " + minDay);
		
	}
}

