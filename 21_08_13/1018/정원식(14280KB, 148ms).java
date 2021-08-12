package study.algo.boj0813;
//14280	148
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j) == 'B') {
					map[i][j] = 1;
				} else {
					map[i][j] = -1;					
				}
					
			}
		}
		for(int r = 0; r <= N - 8; r++) {
			
			for(int c = 0; c <= M - 8; c++) {
				
				for(int com = -1; com < 2; com += 2) {	// wb순, bw순 비교.
					int compare = com;
					int cnt = 0;
					for(int i = 0; i < 8; i++) {
						
						
						if(i%2 == 0) {
							
							for(int j = 0; j < 8; j++) {
								
								if(map[i+r][j+c] != compare)
									cnt++;
								compare = -compare;
							}
							
						} else {
							
							for(int j = 7; j >= 0; j--) {
								
								if(map[i+r][j+c] != compare)
									cnt++;
								compare = -compare;
								
							}
							
						}
						
					} // i
					
					if(cnt < min)
						min = cnt;
					
				} // com
				
				
			} // c
			
		} // r
		System.out.println(min);
	} // main
}
