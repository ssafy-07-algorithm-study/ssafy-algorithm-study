package s5_수들의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine());
		
		//binary search 사용할 것. high가 100,000인 이유는 1부터 10만까지 합이 대강 50억이라서
		long low = 0, high = 100000, mid;
		
		while(true) {
			mid = (high+low)/2;
			
			long sum = mid*(mid+1)/2;
			if (Math.abs(low-high) == 1) { // 정확한 값을 찾지 못했을 때 binary search 중단 후 결과 출력
				System.out.println(Math.min(low, high));
				break;
			}
				
			if(sum < S) {
				low = mid;
			}
			else if (sum > S) {
				high = mid;
			}
			else {
				System.out.println(mid);
				break;
			}
		}
	}
}
