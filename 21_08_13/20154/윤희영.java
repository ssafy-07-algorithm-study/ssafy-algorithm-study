package com.ssafy;

import java.io.*;;

public class ÀÌ±¸¿ªÀÇ½ÂÀÚ´Â´©±¸ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
		
		String a = br.readLine();
		int sum = 0;
		
		for(int i = 0; i<a.length(); i++) {
			sum = sum + arr[a.charAt(i) - 'A'];
			
		}
		
		if(sum%2==1) {
			System.out.println("I'm a winner!");
		}else {
			System.out.println("You're the winner?");
		}
		
		
		
		

	}

}
