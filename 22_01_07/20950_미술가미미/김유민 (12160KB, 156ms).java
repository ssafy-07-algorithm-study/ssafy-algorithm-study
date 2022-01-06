import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int [][]arr = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] gom = new int[3];
		for(int i=0;i<3;i++) gom[i] = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		solution(0,0,arr,gom,0,0,0);
		System.out.println(answer);
	}
	
	public static void solution(int start, int count, int [][]arr, int[] gom, int r, int g, int b) {
		if(count==7) return;
		count++;
		for(int i=start;i<N;i++) {
			r += arr[i][0];
			g += arr[i][1];
			b += arr[i][2];
			if(count>1) {
				int tmpAnswer = Math.abs(gom[0]-r/count) + Math.abs(gom[1]-g/count) + Math.abs(gom[2]-b/count);
				answer = Math.min(answer, tmpAnswer);
			}
			solution(i+1, count,arr,gom,r,g,b);
			r -= arr[i][0];
			g -= arr[i][1];
			b -= arr[i][2];
		}
	}
}
