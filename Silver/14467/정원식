// 22892kb			368ms
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14467_소가길을건너간이유1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/14476.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[10];
		int[] arrLog = new int[10];
		int sum = 0;
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());			
			if(arrLog[idx-1] > 0 && arr[idx-1] != pos)
				sum += 1;
			arr[idx-1] = pos;
			arrLog[idx-1] += 1;
		}
		System.out.println(sum);
	}
}
