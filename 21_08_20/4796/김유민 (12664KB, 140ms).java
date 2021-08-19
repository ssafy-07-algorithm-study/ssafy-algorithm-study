import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int tc=1;
		while((s=bufferedReader.readLine())!=null) {
			if(s.equals("0 0 0")) break;
			StringTokenizer st = new StringTokenizer(s);
			StringBuilder sb = new StringBuilder();
			sb.append("Case ").append(tc).append(": ");
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int q = V/P;
			int r = V%P;	
			
			if(r>L) r=L;
			int answer = r;
			answer+=L*q;
			
			sb.append(answer);
			System.out.println(sb);
			tc++;
		}//while
	}
}