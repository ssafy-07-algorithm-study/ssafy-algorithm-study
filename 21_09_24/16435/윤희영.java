package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤희영 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //과일의 갯수
		int L = Integer.parseInt(st.nextToken()); //초기 길이 정수
		
		int []arr = new int[N];
		
		StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
		
		for(int tc=0; tc< N; tc++) {
			arr[tc] = Integer.parseInt(stt.nextToken());
		}
		
		Arrays.sort(arr);
		int ans = 0;
		
		for(int tc=0; tc< N; tc++) {
			if(L==arr[tc]) {
				ans = arr[tc];
			}
			else
				ans = L;
		}
		
		for(int tc=0; tc< N; tc++) {
			if(ans==arr[tc]) {
				ans++;
			}
			else
				break;
		}
		
		System.out.println(ans);
	
		
	}

}
