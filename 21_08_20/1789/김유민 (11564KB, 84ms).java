import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(bufferedReader.readLine());
		long tmp=0;	// 임시 자연수
		int count=0;	//자연수 개수 세기
		
		while (tmp<N) {
			tmp++;			
			N = N-tmp;
			count++;
		}
		System.out.println(count);
	}
}