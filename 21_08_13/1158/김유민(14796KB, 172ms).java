import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<");
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int tmpN = N;
		int K = Integer.parseInt(stringTokenizer.nextToken())-1;
		LinkedList<Integer> table = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			table.add(i+1);
		}
		
		int first = 0;
		for(int i=0;i<tmpN;i++) {
			first = (first + K)%N;
			N-=1;
			if(i==tmpN-1) {
				stringBuilder.append(table.remove(first)).append(">");
				continue;
			}
			stringBuilder.append(table.remove(first)).append(", ");
		}
		System.out.println(stringBuilder);		
	}
}