// 25560KB, 348ms
package b2_1373_2진수_8진수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder numbers = new StringBuilder(bf.readLine());
		while(numbers.length() % 3 != 0)
			numbers.insert(0, '0');
		
		int[] twoPow = new int[]{4,2,1};
		
		int currentNumber = 0, numbersLength = numbers.length(); ;
		
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < numbersLength; i++) {
			currentNumber += (numbers.charAt(i)-'0') * twoPow[i%3];
			
			if (i%3 == 2 || (i == numbersLength-1 && i%3 < 2)) {
				answer.append(currentNumber);
				currentNumber = 0;
			}
		}
		
		System.out.print(answer.toString());
	}
}
