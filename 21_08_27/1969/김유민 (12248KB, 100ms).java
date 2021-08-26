import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String []arr = new String[N];
		char []answer = new char[M];
		int []count;
		int answerNum=0;
		char []dna = {'A','T','G','C'};
		Arrays.sort(dna);
		String s;
		for(int i=0;i<N;i++) arr[i] = br.readLine();	//입력받기
		
		for(int i=0;i<M;i++) {
			count = new int[4];
			for(int j=0;j<N;j++) {
				if(arr[j].charAt(i)=='A') count[0]+=1;
				else if(arr[j].charAt(i)=='C') count[1]+=1;
				else if(arr[j].charAt(i)=='G') count[2]+=1;
				else if(arr[j].charAt(i)=='T') count[3]+=1;
			}
			int max=0;
			for(int j=0;j<4;j++) max = Math.max(max, count[j]);
			boolean c = false;	//사전순으로 처리해주기 위해
			for(int j=0;j<4;j++) {
				if(c==false && count[j]==max) {
					c=true;
					answer[i]= dna[j];
				}
				else answerNum+=count[j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			sb.append(answer[i]);
		}
		sb.append("\n").append(answerNum);
		System.out.println(sb);
	}//main
}
