package com.ssafy;

import java.io.*;

public class �������ϱ� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ca = Integer.parseInt(br.readLine());
		int arr[] = new int[ca];
		int brr[] = new int[ca];
		for(int test =0 ; test < ca; test++) { //arr �迭�� ���� �߰��ϴ� �κ�
			arr[test] = Integer.parseInt(br.readLine());
		}
		
		int min = 1500;
		int x = 0;
		for(int t = 0; t < ca; t++) {
			
			for(int test =0 ; test < ca; test++) { // �߰� �� �迭���� �ּҰ��� ã�Ƴ� ���� ���ڸ��� �ִ���� �־����.
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
