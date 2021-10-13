import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, count;
	public static HashMap<Integer, ArrayList<Integer>> map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new HashMap<>();
		int a, b;
		count = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(!map.containsKey(a)) map.put(a, new ArrayList<>());
			if(!map.containsKey(b)) map.put(b, new ArrayList<>());
			map.get(a).add(b);
			map.get(b).add(a);
		}
		bfs();
		System.out.println(count);
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean []visited = new boolean[N+1];
		queue.add(1);
		visited[1] = true;
		int now = 0;
		while(!queue.isEmpty()) {
			now = queue.poll();
			if(!map.containsKey(now)) continue;
			for(int i : map.get(now)) {
				if(visited[i]) continue;
				queue.add(i);
				visited[i]=true;
				count++;
			}
		}
	}
}
