package com.ssafy;

import java.io.*;

public class 수정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ca = Integer.parseInt(br.readLine());
		int arr[] = new int[ca];
		int brr[] = new int[ca];
		for(int test =0 ; test < ca; test++) { //arr 배열에 값을 추가하는 부분
			arr[test] = Integer.parseInt(br.readLine());
		}
		
		int min = 1500;
		int x = 0;
		for(int t = 0; t < ca; t++) {
			
			for(int test =0 ; test < ca; test++) { // 추가 된 배열에서 최소값을 찾아낸 다음 그자리에 최대수를 넣어버림.
				if(arr[test]<min) {
					min = arr[test];
				}
			}
			for(int test =0 ; test < ca; test++) { 
				if(arr[test]==min) {
					x = test;
				}
			}
			brr[t] = min;
			arr[x] = Integer.MAX_VALUE;
			min = 1000;
		}
			
	
		
		for(int test =0 ; test < ca; test++) {
			System.out.println(brr[test]);
		}
	}

}
