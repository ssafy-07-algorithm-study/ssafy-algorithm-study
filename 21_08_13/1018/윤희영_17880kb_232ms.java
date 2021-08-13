package com.ssafy;

import java.util.Scanner;

public class ����_17880kb_232ms {
	
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
		
		int N_row = N -7; //n m �� �ּ� 8���� �����Ѵ�
		int M_col = M - 7; //n m �� 10 �̰� 13�� �� 3 6
		
		for(int i=0; i< N_row; i++) { //3 �� �ݺ�
			for(int j=0; j< M_col; j++) { //6 �� �ݺ�
				find(i, j); // �� 18�� �ݺ� find(0, 0) find(0, 1) ... find(2, 5)
			}
		}
		System.out.println(min);
		

	}

	private static void find(int x, int y) {
		int end_x = x+8; //find(2,5)�϶�  endx 10, endy 13
		int end_y = y+8;
		int count = 0;
		
		boolean TF = arr[x][y]; //arr[2][5]
		
		for(int i = x; i< end_x; i++) { //x�� 2���� y �� 5���� ���� 8���� �˻縦�Ѵ�
			for(int j = y; j< end_y; j++) {
				
				if(arr[i][j] != TF) { //��Ģ�� ����������
					count++;
				}
				TF = (!TF); // ó�������� tf�� �ٲٸ鼭 ���� arr[2][5]�� �����̵�.
				
			}
			TF = !TF;
		}
		
		count = Math.min(count, 64-count);
		min = Math.min(min, count);		
	}

}
