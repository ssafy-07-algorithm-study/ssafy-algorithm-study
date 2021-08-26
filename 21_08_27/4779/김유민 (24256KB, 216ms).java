import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null){
			int length = (int)Math.pow(3, Integer.parseInt(s));
			char []arr = new char[length];
			Arrays.fill(arr, '-');
			recur(arr, length,0);
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<length;i++) sb.append(arr[i]);
			System.out.println(sb);
		}		
	}//main
	public static void recur(char []arr, int length, int start) {
		int tmpLength = length/3;
		if(tmpLength==0) return;
		for(int i=start+tmpLength;i<start+tmpLength*2;i++) arr[i]=' ';
		recur(arr, tmpLength,start);
		recur(arr, tmpLength,start+tmpLength*2);
	}
}