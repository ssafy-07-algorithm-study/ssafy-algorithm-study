

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤희영_실패 {
	static int max;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[][] arr= new char[n][n];
		char[][] brr = new char[n][n];
		for(int i=0; i < n; i++) {
			String a = br.readLine();
			for(int j=0; j < n; j++) {
				arr[i][j] = a.charAt(j);
				brr[i][j] = a.charAt(j);
			}
		}
		
		
		for(int i=0; i< n; i ++) { //가로는 4번 바꿈
			for(int j = 0; j < n-1; j++) {
				brr = arr; //반복때마다 brr 배열 초기화
				char temp = arr[i][j];
				brr[i][j] = arr[i][j+1]; //brr 배열에 복사본 넣어줘야함
				brr[i][j+1] = temp;
				check(brr);
			}			
		}
		
		for(int i=0; i< n-1; i ++) { //세로는 4번 바꿈
			for(int j = 0; j < n; j++) {
				brr = arr; //반복때마다 brr 배열 초기화
				char temp = arr[i][j];
				brr[i][j] = arr[i+1][j]; //brr 배열에 복사본 넣어줘야함
				brr[i+1][j] = temp;
				check(brr);
			}			
		}
		
		System.out.println(max);

	}

	private static void check(char[][] arr) {
		int count = 0;
		for(int i=0; i< n; i++) { //가로 카운트
			for(int j=0; j< n-1; j++) {
				if(arr[i][j]==arr[i][j+1]) {
					count++;
				}
			}			
			if(max<count) {
				max = count;
			}
			count = 0;
		}
		
		for(int i=0; i< n-1; i++) { //세로 카운트
			for(int j=0; j< n; j++) {
				if(arr[i][j]==arr[i+1][j]) {
					count++;
				}
			}			
			if(max<count) {
				max = count;
			}
			count = 0;
		}						
		
	}

}
