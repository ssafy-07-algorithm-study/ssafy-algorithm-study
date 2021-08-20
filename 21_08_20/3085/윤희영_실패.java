

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ����_���� {
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
		
		
		for(int i=0; i< n; i ++) { //���δ� 4�� �ٲ�
			for(int j = 0; j < n-1; j++) {
				brr = arr; //�ݺ������� brr �迭 �ʱ�ȭ
				char temp = arr[i][j];
				brr[i][j] = arr[i][j+1]; //brr �迭�� ���纻 �־������
				brr[i][j+1] = temp;
				check(brr);
			}			
		}
		
		for(int i=0; i< n-1; i ++) { //���δ� 4�� �ٲ�
			for(int j = 0; j < n; j++) {
				brr = arr; //�ݺ������� brr �迭 �ʱ�ȭ
				char temp = arr[i][j];
				brr[i][j] = arr[i+1][j]; //brr �迭�� ���纻 �־������
				brr[i+1][j] = temp;
				check(brr);
			}			
		}
		
		System.out.println(max);

	}

	private static void check(char[][] arr) {
		int count = 0;
		for(int i=0; i< n; i++) { //���� ī��Ʈ
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
		
		for(int i=0; i< n-1; i++) { //���� ī��Ʈ
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
