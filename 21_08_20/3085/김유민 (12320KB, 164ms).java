import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static char [][]arr;
	public static boolean [][]visited;
	public static int N;
	public static int tmpAnswer;
	public static int answer=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];				
		
		for(int i=0;i<N;i++) arr[i]= bufferedReader.readLine().toCharArray();
		
		change();
		System.out.println(answer);
	}//main
	
	public static void change() {	//사탕 교환
		int dx[] = {-1,0,1,0};	//시계방향으로
		int dy[] = {0,1,0,-1};
		
		for(int i=0;i<N;i++) {	//돌아가면서 swap
			for(int j=0;j<N;j++) {
				visited[i][j]=true;
				for(int z=0;z<4;z++) {
					if(i+dx[z]<0 || i+dx[z]>=N || j+dy[z]<0 || j+dy[z]>=N) continue;	//범위 확인
					if(arr[i][j] == arr[i+dx[z]][j+dy[z]]) continue;	//값이 같으면 넘어가기
					if(visited[i+dx[z]][j+dy[z]]) continue;	//이미 확인했을 경우 넘어가기
					swap(i, j, i+dx[z], j+dy[z]);
					search();					
					swap(i, j, i+dx[z], j+dy[z]);	//다시 원상복구
				}
			}
		}		
	}
	
	public static void search() {	//같은 색으로 이루어져 있는 사탕 세기
		for(int i=0;i<N;i++) {	//행 검색
			char tmp = arr[i][0];
			tmpAnswer=0;
			for(int j=0;j<N;j++) {
				if(tmp==arr[i][j]) tmpAnswer++;
				else {
					answer = Math.max(answer, tmpAnswer);
					tmp=arr[i][j];
					tmpAnswer=1;
				}
			}
			answer = Math.max(answer, tmpAnswer);
		}
		
		for(int j=0;j<N;j++) {	//열 검색
			char tmp = arr[0][j];
			tmpAnswer=0;
			for(int i=0;i<N;i++) {	
				if(tmp==arr[i][j]) tmpAnswer++;
				else {
					answer = Math.max(answer, tmpAnswer);
					tmp=arr[i][j];
					tmpAnswer=1;
				}
			}
			answer = Math.max(answer, tmpAnswer);
		}
	}//search
	
	public static void swap(int x1, int y1, int x2, int y2) {	//사탕 교환
		char tmp = arr[x1][y1];
		arr[x1][y1]= arr[x2][y2];
		arr[x2][y2]= tmp;		
	}//swap
}