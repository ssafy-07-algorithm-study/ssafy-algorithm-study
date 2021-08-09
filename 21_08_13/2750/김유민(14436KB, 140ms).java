// 14436KB, 140ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int []arr = new int[N];
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(bufferedReader.readLine());
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			stringBuilder.append(arr[i]).append("\n");
		}
		System.out.println(stringBuilder);
	}
}