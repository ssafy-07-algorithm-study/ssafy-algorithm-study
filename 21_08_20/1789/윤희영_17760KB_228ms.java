

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class À±Èñ¿µ_17760KB_228ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		long a = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long sum = 0;
		long ans =0;
		int count =0;
		while(true) {
			sum++;
			ans = ans + sum;
			if(ans>a)
				break;
			count++;
		}
		System.out.println(count);
		
		

	}

}
