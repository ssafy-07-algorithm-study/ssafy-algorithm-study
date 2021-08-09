
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이구역의승자는누구야 {

	public static void main(String[] args) throws IOException {
		int[] alpha = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		int len = a.length();
		int sum = 0;
		for(int i=0;i<len;i++) {
			sum += alpha[a.charAt(i)- 65];
		}
		if(sum %2 == 0) {/
}
