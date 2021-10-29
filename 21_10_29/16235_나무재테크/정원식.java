import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {

	static class Namu implements Comparable<Namu> {
		int x;
		int y;
		int age;

		@Override
		public int compareTo(Namu o) {
			return this.age - o.age;
		}
	}

	static int[] dr = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][N];
		// int[][] mapNamu = new int[N][N];
		ArrayList<Namu> namuList = new ArrayList<Namu>();
		int[][] mapYang = new int[N][N];
		Queue<Namu> queue = new LinkedList<Namu>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				mapYang[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Namu namu = new Namu();
			namu.x = Integer.parseInt(st.nextToken()) - 1;
			namu.y = Integer.parseInt(st.nextToken()) - 1;
			namu.age = Integer.parseInt(st.nextToken());
			namuList.add(namu);
		}

		for (int k = 0; k < K; k++) {

/*			// spring
			int size = namuList.size();

			for (int i = 0; i < size; i++) {

				Namu namu = namuList.get(i);

				if (mapYang[namu.x][namu.y] >= namu.age) {
					mapYang[namu.x][namu.y] -= namu.age;
					namu.age += 1;
				} else {
					queue.offer(namu);
					namuList.remove(namu);
					i = -1;
					size -= 1;
				}

			}*/
			
			// spring
			Iterator<Namu> iterator = namuList.iterator();
			while(iterator.hasNext()) {
				Namu namu = iterator.next();
				int r = namu.x;
                int c = namu.y;
                int age = namu.age;
                if (mapYang[r][c] - age < 0) {
                    queue.offer(namu);
                    iterator.remove();
                } else {
                	mapYang[r][c] -= age;
                    namu.age += 1;
                }
			}

			// summer
			while (!queue.isEmpty()) {
				Namu namu = queue.poll();
				mapYang[namu.x][namu.y] += namu.age / 2;
			}

			// fall
			int size = namuList.size();

			for (int i = 0; i < size; i++) {

				Namu namu = namuList.get(i);

				if(namu.age % 5 == 0) {
					for(int d = 0; d < 8; d++) {
						
						int nr = namu.x + dr[d];
						int nc = namu.y + dc[d];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N)
							continue;
						
						Namu babyNamu = new Namu();
						babyNamu.x = nr;
						babyNamu.y = nc;
						babyNamu.age = 1;
						
						namuList.add(babyNamu);
					}
				}

			}
			
			// winter
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					mapYang[i][j] += A[i][j];
				}
			}
			
		}
		
		System.out.println(namuList.size());
		
	}
}
