
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_1755_숫자놀이2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Num[] nums = new Num[N-M+1];
		for(int i = M; i < N+1; i++) {
			nums[i-M] = new Num(i);
		}
//		for (Num num : nums) {
//			System.out.print(num.num + " ");
//		}
		Arrays.sort(nums);
		for (Num num : nums) {
			System.out.print(num.num + " ");
		}
//		for(int i = 0; i < N-M+1; i++) {
//			if(i%10 == 0 && i!=0)
//				sb.append("\n");
//			sb.append(nums[i].num).append(" ");
//		}
//		System.out.println(sb);
	}
	
	static class Num implements Comparable<Num> {

		int num;
		String nstr;
		
		public Num(int number) {
			this.num = number;
			if(num>=10) {
				nstr = "" + trans(num%10) + trans(num/10);
			} else {
				nstr = "" + trans(num);
			}
		}
		
		@Override
		public int compareTo(Num o) {
			return this.nstr.compareTo(o.nstr);
		}
		
	}
	static String trans(Integer i) {
		switch (i) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		default:
			return "0";
		}
	}	
}
