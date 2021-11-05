import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		HashSet<String> see = new HashSet<>();
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<String> answer = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			see.add(bufferedReader.readLine()); 
		}
		
		for(int i=0;i<M;i++) {
			String tmp = bufferedReader.readLine();
			if(see.contains(tmp)) {
				answer.add(tmp);
			}
		}
		
		Collections.sort(answer);
		int size = answer.size();
		for(int i=0;i<size;i++) {
			stringBuilder.append(answer.get(i)).append("\n");
		}
		System.out.println(size);
		System.out.println(stringBuilder);
	}//main
}
