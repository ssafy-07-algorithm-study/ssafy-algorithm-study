// 14204KB 132ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[11];
		int count = 0;
		Arrays.fill(arr, -1);
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer( br.readLine());
			int cow_num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			if(arr[cow_num] == -1)	arr[cow_num] = dir;
			else if(arr[cow_num] != dir) {
				arr[cow_num] = dir;
				count++;
			}
		}
		System.out.println(count);
		

	}

}
