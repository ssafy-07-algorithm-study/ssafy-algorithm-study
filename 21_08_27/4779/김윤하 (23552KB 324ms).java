import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number;
		while((number = br.readLine()) != null) {
			int N = Integer.parseInt(number);
			StringBuilder sb = new StringBuilder();
			divide(sb, N);
			System.out.println(sb);
		}
		
		
	}
	
	static void divide(StringBuilder sb, Integer N) {
		if (N == 0) {
			sb.append("-");
			return;
		}
		
		divide(sb, N-1);
		int pow = 1;
		for (int j = 0; j < N-1; j++)
			pow *= 3;
		for(int i = 0 ; i < pow; i++)
			sb.append(" ");
		divide(sb, N-1);
	}
}
