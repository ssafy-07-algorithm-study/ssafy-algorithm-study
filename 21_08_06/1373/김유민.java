import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리 : 23692KB, 시간 : 388ms
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		char []binary= bufferedReader.readLine().toCharArray();
		int x=0;
		
		if(binary.length%3 !=0) {
			int tmp=0;
			for(int i=binary.length%3-1;i>=0;i--) {
				if(binary[x]=='1') {
					tmp += Math.pow(2, i);
				}
				x++;
			}
			stringBuilder.append(tmp);
		}
		
		for(int i=0;i<(binary.length/3);i++) {
			int tmp=0;
			for(int j=2;j>=0;j--) {
				if(binary[x]=='1') {
					tmp += Math.pow(2, j);
				}
				x++;
			}
			stringBuilder.append(tmp);
		}
		
		System.out.println(stringBuilder);
	}
}
