import java.io.*;
import java.util.StringTokenizer;

//14552KB 140ms

public class BOJ_4796_캠핑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caseCnt = 1;

		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken()); // L일동안 사용 가능
			int P = Integer.parseInt(st.nextToken()); // 연속하는 P일 동안
			int V = Integer.parseInt(st.nextToken()); // V일짜리 휴가

			// 마지막 줄에는 0이 3개
			if (L == 0 && P == 0 && V == 0)
				break;

			// 먼저 V일동안에 있는 P일만큼의 뭉탱이 개수 * L
			int maxUse = (V / P) * L;

			// 나머지 일수가 L보다 작으면 그 나머지 일수 다 더해주고
			if ((V % P) < L)
				maxUse += (V % P);
			// 아니면 L일 다 더해줌
			else
				maxUse += L;

			sb.append("Case ").append(caseCnt).append(": ").append(maxUse).append("\n");
			caseCnt++;
		}
		System.out.println(sb);
	}
}
