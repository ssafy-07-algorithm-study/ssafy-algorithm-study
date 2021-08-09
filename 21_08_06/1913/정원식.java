//82608 KB		672 ms
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1913_달팽이2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileStreamReader(""));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int target = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		int rr = 0;
		int cc = 0;
		
		int[] dr = {-1, 0, 1, 0};	// 상 우 하 좌
		int[] dc = {0, 1, 0, -1};
		
		int r = (N / 2);
		int c = (N / 2);
		int d = 0;
		
		int a = 1;
		int b = 1;
		int cnt = 0;
		
		for(int i = 0; i < N * N; i++) {
			
			if(i+1 == target) {
				rr = r;
				cc = c;
			}
			map[r][c] = i+1;
			//System.out.println(r + " : " + c + " -> " + (i+1));
			r = r + dr[d];
			c = c + dc[d];
			if(b >= a) {
				cnt++;
				d = changeDirec(d);				
				if( cnt >= 2 ) {
					a++;
					cnt = 0;
				}
				b = 0;
			}
			b++;
			if(0 > r || r >= N || 0 > c || c >= N) {
				break;
			}
		}
		
		for (int[] i : map) {
			for (int j : i) {
				//System.out.printf("%d ", j);
				sb.append(j + " ");
			}
			sb.append("\n");
		}
		sb.append((rr+1)).append(" ").append((cc+1));
		System.out.println(sb);
	}
	
	private static int changeDirec(int d) {
		if(d == 3)
			return 0;
		return ++d;
	}
}
