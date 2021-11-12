//14260 KB  140 ms

package silver_17179_스네이크버드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1431_시리얼번호 {
	
	static class Gt implements Comparable<Gt> {
		String serial;		
		
		public Gt(String serial) {
			super();
			this.serial = serial;
		}

		@Override
		public int compareTo(Gt o) {
			
			if(this.serial.length() != o.serial.length()) {
				return this.serial.length() - o.serial.length();
			} else {
				int x = 0, y = 0;
				for(int i = 0; i < this.serial.length(); i++) {
					int c = this.serial.charAt(i) - '0';
					if( c >= 0 && c <= 9) {
						x += c;
					}
				}
				for(int i = 0; i < o.serial.length(); i++) {
					int c = o.serial.charAt(i) - '0';
					if( c >= 0 && c <= 9) {
						y += c;
					}
				}
				
				if(x-y != 0) {
					return x - y;
				} else {
					return this.serial.compareTo(o.serial);
				}
			}

			
		}
		
	}
	
	static int N;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		List<Gt> gts = new ArrayList<Gt>();
		for(int i = 0; i < N; i++) {
			gts.add(new Gt(br.readLine()));
		}
		Collections.sort(gts);
		for(int i = 0; i < N; i++) {
			sb.append(gts.get(i).serial).append("\n");
		}
		System.out.println(sb);
	}
}
