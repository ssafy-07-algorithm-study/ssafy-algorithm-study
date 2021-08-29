package s5_2477_참외밭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 파인 부분의 면적을 구하고 싶다.
		// 파인 부분의 가로 변을 지나고, 반드시 3번 이후에 가장 긴 가로변이 나온다 (해보면 앎)
		// 파인 부분의 세로 변을 지나고, 반드시 3번 이후에 가장 긴 세로 변이 나온다.
		// 가장 긴 가로변과 가장 긴 세로변의 인덱스를 저장하고 나면, 파인 부분의 가로 세로를 쉽게 구할 수 있다
		
		int K = Integer.parseInt(br.readLine());
		int[] side = new int[7];
		int maxRow = 0, maxCol = 0, maxRowIndex = 0, maxColIndex = 0;
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arrow = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			side[i] = length;
			if (arrow >= 3) {
				if (length > maxRow) {
					maxRowIndex = i;
					maxRow = length;
				}
			}
			else {
				if (length > maxCol) {
					maxColIndex = i;
					maxCol = length;
				}
			}
		}
		int maxArea = maxCol*maxRow;
				
		if (maxColIndex < 3) maxColIndex += 6;
		if (maxRowIndex < 3) maxRowIndex += 6;
		
		int minArea = side[maxColIndex-3] *  side[maxRowIndex-3];
		
		int answerArea = maxArea-minArea;
		System.out.println(maxArea);
		System.out.println(minArea);
		System.out.println(answerArea*K);
		
	}
}
