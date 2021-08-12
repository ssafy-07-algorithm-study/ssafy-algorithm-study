package study.algo.boj0813;

// 66976	392

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_20154_이구역승자 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < str.length(); i++) {
			queue.offer(translate(str.charAt(i)));
		}
		
		while(queue.size() != 1) {
			int len = queue.size();
			int a = 0;
			int b = 0;
			for(int i = 1; i <= len; i++) {
				if(i%2 == 1) {
					a = queue.poll();
				} else {
					b = queue.poll();
					queue.offer((a+b)%10);
				}
			}
			if(len%2 == 1)
				queue.offer(a);
		}
		if(queue.poll()%2 == 1) {
			System.out.println("I'm a winner!");			
		}
		else {
			System.out.println("You're the winner?");		
		}
	}
	
	private static int translate(char c) {
	
		if( c == 'A' || c == 'E' || c == 'F' || c == 'G' || c == 'H' 
				|| c == 'K' || c == 'M' || c == 'N' ) {
			return 3;			
		} else if( c == 'B' || c == 'D' || c == 'P' || c == 'Q' || c == 'R' ||
				 c == 'T' || c == 'W' || c == 'X' || c == 'Y' ) {
			return 2;
		} else if( c == 'C' || c == 'I' || c == 'J' || c == 'L' || c == 'O' ||
				 c == 'S' || c == 'U' || c == 'V' || c == 'Z' ) {
			return 1;
		}
		return -1;
		
	}
}
