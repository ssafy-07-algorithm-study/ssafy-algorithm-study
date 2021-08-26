import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,K;
	public static int answer=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int []arr = new int[N];
		boolean []isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		muscle(0, 500, isSelected, arr);
		System.out.println(answer);
	}
	
	public static void muscle(int cnt, int weight, boolean []isSelected, int []arr) {
		if(cnt==N) {
			answer++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			int tmpWeight = weight + arr[i] -K;
			if(tmpWeight<500) continue;
			isSelected[i]=true;
			muscle(cnt+1, tmpWeight, isSelected, arr);
			isSelected[i]=false;			
		}
		
	}
}