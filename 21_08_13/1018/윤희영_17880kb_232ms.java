package com.ssafy;

import java.util.Scanner;

public class 윤희영_17880kb_232ms {
	
	public static boolean[][]arr;
	public static int min = 64;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		arr= new boolean[N][M];
		in.nextLine();
		
		for(int i=0; i<N; i++) {
			String str = in.nextLine().trim();
			for(int j=0; j<M; j++) {
				if(str.charAt(j)=='W') {
					arr[i][j] = true;
				}else {
					arr[i][j]= false;
				}
			}
		}
		
		int N_row = N -7; //n m 은 최소 8부터 시작한다
		int M_col = M - 7; //n m 이 10 이고 13일 때 3 6
		
		for(int i=0; i< N_row; i++) { //3 번 반복
			for(int j=0; j< M_col; j++) { //6 번 반복
				find(i, j); // 총 18번 반복 find(0, 0) find(0, 1) ... find(2, 5)
			}
		}
		System.out.println(min);
		

	}

	private static void find(int x, int y) {
		int end_x = x+8; //find(2,5)일때  endx 10, endy 13
		int end_y = y+8;
		int count = 0;
		
		boolean TF = arr[x][y]; //arr[2][5]
		
		for(int i = x; i< end_x; i++) { //x는 2부터 y 는 5부터 각각 8개씩 검사를한다
			for(int j = y; j< end_y; j++) {
				
				if(arr[i][j] != TF) { //규칙에 맞지않을때
					count++;
				}
				TF = (!TF); // 처음시작은 tf를 바꾸면서 시작 arr[2][5]가 기준이됨.
				
			}
			TF = !TF;
		}
		
		count = Math.min(count, 64-count);
		min = Math.min(min, count);		
	}

}
