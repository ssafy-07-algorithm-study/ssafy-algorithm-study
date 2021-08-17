

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤희영_14340KB_148ms {
	static int P; //연속하는 피일 중
	static int L; // 엘 일동안만 사용할 수 있다
	static int V;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		while(true) {
			String a = br.readLine();
			count++;
			if(a.equals("0 0 0")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(a, " ");
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			int an = V/P;
			int en = V%P > L? L: V%P;
			answer = (an*L)+(en);
			
			sb.append("Case ").append(count).append(": ").append(answer).append("\n");
			
		}
		System.out.println(sb);

	}

}
