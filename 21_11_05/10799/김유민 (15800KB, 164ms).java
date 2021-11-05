import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		char [] bracket = bufferedReader.readLine().toCharArray();
		Stack<Boolean> stack = new Stack<>();
		int answer = 0;
		int tmp = 0;
		
		for(int i=0;i<bracket.length;i++) {
			if(bracket[i] == '(') {
				if(i+1<bracket.length && bracket[i+1] == ')') {
					answer +=tmp;
					i+=1;
					continue;
				}
				else{
					tmp +=1;
				}
			}

			if(bracket[i] == ')') {
				answer +=1;
				tmp-=1;
			}			
		}//for i
		
		System.out.println(answer);
		
	}
}
