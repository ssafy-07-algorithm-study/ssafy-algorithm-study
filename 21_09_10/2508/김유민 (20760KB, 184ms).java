import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int answer;
		String tmp;
		
		for(int tc=0;tc<T;tc++) {
			answer=0;
			tmp = br.readLine();
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			char [][]arr = new char[r][c];
			
			for(int i=0;i<r;i++) {
				tmp = br.readLine();
				for(int j=0;j<c;j++) arr[i][j]=tmp.charAt(j);
			}
			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(arr[i][j]=='>') {
						if(j+2<c && arr[i][j+1]=='o' && arr[i][j+2]=='<') answer++;
					}
					else if(arr[i][j]=='v') {
						if(i+2<r && arr[i+1][j]=='o' && arr[i+2][j]=='^') answer++;
					}
				}
			}
			System.out.println(answer);
		}//tc
	}
}
