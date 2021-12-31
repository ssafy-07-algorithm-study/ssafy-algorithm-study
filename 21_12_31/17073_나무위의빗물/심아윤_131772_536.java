package december.fifth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_17073_나무위의빗물 {

	static int count; // 마지막에 물이 남아있는 정점들 => 잎노드!!!!

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] check = new int[N]; // 방문여부(-1)와 리스트에서 제외될 수(양의정수)의 개수
		List<Integer>[] list = new ArrayList[N]; // 노드 연결 여부
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int U = Integer.parseInt(st.nextToken()) - 1;
			int V = Integer.parseInt(st.nextToken()) - 1;
			list[U].add(V);
			list[V].add(U);
		}
		solve(0, list, check);
		String result = String.format("%.10f", W / (count * 1.0));
		System.out.println(result);
	}

	private static void solve(int node, List<Integer>[] list, int[] check) {
		int size = list[node].size(); // 현재 연결된 노드
		int childNum = size - check[node]; // 자식 노드 개수 = 연결된 노드 - 이미 방문한 노드
		check[node] = -1; // 방문 체크
		if (childNum == 0) { // 자식 노드가 없으면 고인 물이 됨.
			count++;
		}
		for (int i = 0; i < size; i++) {
			int idx = list[node].get(i);
			if (check[idx] == -1) // 이미 방문한 노드
				continue;
			check[idx]++; // 이미 리스트에서 방문한 노드가 있음을 알려주기 위함.
			solve(idx, list, check); // 자식 노드 계산 이어가기
		}
	}
}

--------
  
package december.fifth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17073_나무위의빗물2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[N]; // 간선의 개수
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int U = Integer.parseInt(st.nextToken()) - 1;
			int V = Integer.parseInt(st.nextToken()) - 1;
			arr[U]++;
			arr[V]++;
		}
		int count = 0; // 잎노드의 수
		for (int i = 1; i < N; i++) { // 주의!!! 루트 노드는 1일수도 있으므로 제외!!
			if (arr[i] == 1)
				count++;
		}
		String result = String.format("%.10f", W / (count * 1.0));
		System.out.println(result);
	}

}
