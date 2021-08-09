import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Character [][]chess;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		chess = new Character[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = bufferedReader.readLine();
			for(int j=0;j<M;j++) {
				chess[i][j] = tmp.charAt(j);
			}
		}

		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				check(i,j);
			}
		}
		System.out.println(answer);
	}//main

	private static void check(int x, int y) {
		int count = 0;
		char f = chess[x][y];

		for(int i=x;i<x+8;i++) {
			for(int j=y;j<y+8;j++) {
				if(i%2 == 0 && j%2 == 0) {
					if(chess[i][j] != f) {
						count++;
					}
				}
				else if(i%2 == 0 && j%2 == 1) {
					if(chess[i][j] == f) {
						count++;
					}
				}
				else if(i%2 == 1 && j%2 == 0) {
					if(chess[i][j] == f) {
						count++;
					}
				}
				else if(i%2 == 1 && j%2 == 1) {
					if(chess[i][j] != f) {
						count++;
					}
				}
			}
		}//for
		
		count = Math.min(count, 64-count);
		answer = Math.min(count, answer);
	}//check
}