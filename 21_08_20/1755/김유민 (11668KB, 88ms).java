import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bufferedReader.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int length = N-M+1;

		String[] alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; //숫자를 문자열로 바꿀 때 사용
		HashMap<String, Integer> map = new HashMap<>();	//다시 숫자로 바꿀 때 사용
		map.put("zero", 0);	map.put("one", 1); map.put("two", 2); map.put("three", 3); map.put("four", 4);
		map.put("five", 5);	map.put("six", 6); map.put("seven", 7); map.put("eight", 8); map.put("nine", 9);
		
		String []arr = new String[length];	//문자열로 바꾼 숫자들을 저장		
		int tmp=0;
		
		for(int i=M;i<N+1;i++) {	// 배열에 넣기
			int q = i/10;
			int r= i%10;//한자리수일 경우
			
			if(q==0) arr[tmp]=alpha[r];
			else arr[tmp]=alpha[q] + " "+ alpha[r];
			tmp++;			
		}
		
		Arrays.sort(arr, new Comparator<String>() {	//정렬

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i=0;i<length;i++) {	//문자열 다시 숫자로 바꾸기
			st= new StringTokenizer(arr[i]);
			String t = st.nextToken();
			stringBuilder.append(map.get(t));
			if(st.hasMoreTokens()) {
				t = st.nextToken();
				stringBuilder.append(map.get(t));
			}
			stringBuilder.append(" ");
			if(i%10==9) stringBuilder.append("\n");
		}
		
		System.out.println(stringBuilder);
	}
}