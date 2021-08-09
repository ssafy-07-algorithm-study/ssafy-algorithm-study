

import java.io.*;
import java.util.*;

public class À±Èñ¿µ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int n = 0;
		int []arr = new int[10];
		Arrays.fill(arr, 3);
				
		for(int i = 0; i < count; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			
			if(arr[X-1]== 3) {
				arr[X-1] = Y;
			}else if(arr[X-1] != Y) {
				arr[X-1] = Y;
				n++;
			}									
		}
		System.out.println(n);						

	}

}
