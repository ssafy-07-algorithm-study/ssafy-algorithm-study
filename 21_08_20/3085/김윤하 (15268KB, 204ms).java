package s4_3085_사탕게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static int N, answer = 0;
	static char[][] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for (int i = 0; i < N; i++)
			board[i] = br.readLine().toCharArray();
		
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (x+1 < N && board[y][x] != board[y][x+1]) {
					swap(y, x, y, x+1);
					calMax();
					swap(y, x, y, x+1);
				}
				
				if (y+1 < N && board[y][x] != board[y+1][x]) {
					swap(y, x, y+1, x);
					calMax();
					swap(y, x, y+1, x);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void swap (int y, int x, int targetY, int targetX) {
		char temp = board[y][x];
		board[y][x] = board[targetY][targetX];
		board[targetY][targetX] = temp;
		return;
	}
	
	public static void calMax(){
		for (int y = 0; y < N; y++) {
			char current = board[y][0];
			int temp = 1;  // temp : 연속된 알파벳 개수, temp2 : 끊어진거 이은 뒤 개수
			
			for (int x = 1; x < N; x++) {
				if (current == board[y][x]) { // 
					temp++;
					answer = answer > temp ? answer : temp;
					continue;
				}
				
				current = board[y][x];
				answer = answer > temp ? answer : temp;
				temp = 1;
			}
		}
		
		for (int x = 0; x < N; x++) {
			char current = board[0][x];
			int temp = 1;  // temp : 연속된 알파벳 개수, temp2 : 끊어진거 이은 뒤 개수
			
			for (int y = 1; y < N; y++) {
				if (current == board[y][x]) {
					temp++;
					answer = answer > temp ? answer : temp;
					continue;
				}
				
				current = board[y][x];
				answer = answer > temp ? answer : temp;
				temp = 1;
			}
		}
	}
}
