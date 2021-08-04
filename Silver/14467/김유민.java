import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] cow = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cowNumber = Integer.parseInt(st.nextToken());
			int cowPosition = Integer.parseInt(st.nextToken());
			
			if (cow[cowNumber] == -1) {
				cow[cowNumber] = cowPosition;
			}
			else if (cow[cowNumber] != cowPosition) {
				answer++;
                cow[cowNumber] = cowPosition;
			}
		}
		System.out.println(answer);
	}
}
