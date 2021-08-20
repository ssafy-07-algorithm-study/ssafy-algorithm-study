// 틀렸습니다
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_S5_1789_수들의합 {
	static ArrayList<Long> list;
	static int max;
	static Long S;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Long.parseLong(br.readLine());
		//System.out.println(S);
		list = new ArrayList<Long>();
		recur(0);
		System.out.println(max);
	}
	
	static void recur(long sum) {
		
		if(sum > S)
			return;
		if(sum == S) {
			max = Math.max(max, list.size());
			System.out.println(list.size());
			return;
		}
		
		for(long l = 1; l < Long.MAX_VALUE; l++) {
			if(l > S) break;
			list.add(l);
			recur(sum+l);
			list.remove(l);
		}
	}
}
