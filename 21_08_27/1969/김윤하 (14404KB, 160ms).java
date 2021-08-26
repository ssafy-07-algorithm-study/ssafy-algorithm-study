package s5_1969_DNA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] count = new int[M][4];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			char[] alpa = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (alpa[j] == 'A')
					count[j][0]++;
				if (alpa[j] == 'C')
					count[j][1]++;
				if (alpa[j] == 'G')
					count[j][2]++;
				if (alpa[j] == 'T')
					count[j][3]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < M; j++) {
			int maxCount = -1, maxIndex = -1, sum = 0;

			maxCount = Math.max(count[j][0], count[j][1]);
			maxCount = Math.max(maxCount, count[j][2]);
			maxCount = Math.max(maxCount, count[j][3]);
			for (int i = 0; i < 4; i++) {
				sum += count[j][i];
				if (maxCount == count[j][i] && maxIndex==-1)
					maxIndex = i;
			}
			
			if (maxIndex == 0)
				sb.append('A');
			if (maxIndex == 1)
				sb.append('C');
			if (maxIndex == 2)
				sb.append('G');
			if (maxIndex == 3)
				sb.append('T');
			
			answer += (sum-maxCount);
			
		}
		System.out.println(sb);
		System.out.println(answer);
	}
}
