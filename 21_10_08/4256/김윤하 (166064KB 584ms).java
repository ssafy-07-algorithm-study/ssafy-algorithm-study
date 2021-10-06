package gold.g4_4256_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// preorder의 0번째 인덱스부터 inorder에서 찾는다.
// 찾게 되면 찾은 위치의 왼쪽은 왼쪽서브트리, 찾은 위치의 오른쪽은 오른쪽 서브트리가 된다.
// 따라서 찾을 때마다 찾은 위치를 기준으로 왼쪽, 오른쪽을 나눠 재귀한다.
// 왼쪽, 오른쪽을 모두 본 노드에 대해서 출력 (리프노드도 포함됨) 하면 postorder로 출력할 수 있다.
public class Main {
	
	static int preIndex, n;
	static int[] pre;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			preIndex = 0;
			
			n = Integer.parseInt(br.readLine());
			pre = new int[n];
			int[] in = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}
			
			cal(in);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void cal(int[] tempIn) {
		if (tempIn.length == 0) return;
		
		int currentPre = pre[preIndex++];
		if (tempIn.length == 1) {
			sb.append(tempIn[0]).append(" ");
			return;
		}
		
		
		for (int i = 0; i < tempIn.length; i++) {
			if (currentPre == tempIn[i]) {
				cal(Arrays.copyOfRange(tempIn, 0, i));
				cal(Arrays.copyOfRange(tempIn, i+1, tempIn.length));
				sb.append(tempIn[i]).append(" ");
				return;
			}
		}
	}
}
