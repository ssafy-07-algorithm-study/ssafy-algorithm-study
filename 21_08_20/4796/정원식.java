
// 시간초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_4796_캠핑2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int L = 0, P = 0, V = 0;
		int tc = 0;
		do {
			tc++;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			int cntPsb = 0;
			for(int i = 0; i < V; ) {
				cntPsb += L;
				i += L;
				if(i >= V) cntPsb -= i-V;
				i += P-L;
			}
			
			if(L!=0 || P!=0 || V!=0)
				sb.append("Case ").append(tc).append(": ").append(cntPsb).append("\n");
		} while(L!=0 || P!=0 || V!=0);
		System.out.println(sb);
		
	}
}
