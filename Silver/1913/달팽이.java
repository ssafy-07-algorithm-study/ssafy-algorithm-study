

import java.io.*;

public class ¥ﬁ∆ÿ¿Ã {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int N = Integer.parseInt(a);
		String b = br.readLine();
		int search_num = Integer.parseInt(b);
		int start = N*N;
		int arr[][]	= new int[N][N];
		
		int o = 0;
		int p = 0;
		
		
		int [][]move = {{0,1},{1,0},{0,-1},{-1,0}};
		int d = 0;
		int x = 0, y = 0;
		while(true) {
			arr[y][x] = start;
			
				if(x + move[d][0]<0 || x + move[d][0] >= N || y + move[d][1] < 0 || y + move[d][1] >= N || arr[y+move[d][1]][x+move[d][0]] != 0) {
					d = (d+1)%4;
				}
				y = y + move[d][1];
				x = x + move[d][0];
				start--;
				if(start == 0)
					break;
			
			
		}
		for(int i=0; i < N;i++) {
			for(int j=0; j< N; j++) {
				System.out.print(arr[i][j]);
				if(arr[i][j] == search_num) {
					o = i+1;
					p = j+1;
				}
			}
			System.out.println();
		}
		System.out.println(o+" "+p);

	}

}
