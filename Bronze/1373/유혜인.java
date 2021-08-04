//42968KB 444ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int[] arr = new int[a.length()];
		int len = arr.length;
		for (int i = len - 1; i >= 0; i--) {
			arr[len - 1 - i] = a.charAt(i) - '0';
		}
		
//		System.out.println(Arrays.toString(arr));
		int iter = len / 3 + 1;
		int rest = len % 3;
		String[] result = new String[iter];

		for (int i = 0; i < iter; i++) {
			long digit = 0;
			if (i == iter - 1) {
				for (int j = 0; j < rest; j++) {
					int num = arr[i * 3 + j];
					digit += (int) (num * Math.pow(2, j));
				}
			} else {

				for (int j = 0; j < 3; j++) {
					int num = arr[i * 3 + j];
					digit += (int) (num * Math.pow(2, j));
				}
			}
			
			result[i] = digit + "";
		}
		StringBuilder output = new StringBuilder("");
		for(int i=0;i<iter;i++) {
			if(i == 0 && result[iter-1-i].equals("0") )	continue;
			output.append(result[iter-1-i]);
			
		}
//		System.out.println(output.toString() +"aaaaaaaaaaaaaaaa");
		if(output.toString().equals("") )	System.out.println("0");
		else	System.out.println(output.toString());
	}

}
