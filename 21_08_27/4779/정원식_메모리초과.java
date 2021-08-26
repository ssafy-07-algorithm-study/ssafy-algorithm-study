package silver_4779_칸토어집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4779_칸토어집합 {
	
	static String recur(int len) {
		String str = "";
		
		if(len == 1) {
			return "-";
		}
		
		str += recur(len/3);
		for(int i = 0; i < len/3; i++) {
			str += " ";
		}
		str += recur(len/3);
		
		return str;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String check = "";
		while((check = br.readLine()) != null) {
			int N = Integer.parseInt(check);
			System.out.println(recur((int) Math.pow(3, N)));
		}
	}
}
// 0과 1 사이의 실수로 이루어진 집합
// - 3^n
