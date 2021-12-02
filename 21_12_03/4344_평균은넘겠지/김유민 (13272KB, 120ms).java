import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine());
		
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int []arr = new int[N];
			float avg = 0;
			for(int j=0;j<N;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				avg += arr[j];
			}
			avg /= N;
			float student_num = 0;
			for(int j=0;j<N;j++) if(arr[j]>avg) student_num++;
			System.out.printf("%.3f%%\n",(student_num/N)*100);
		}
	}
}
