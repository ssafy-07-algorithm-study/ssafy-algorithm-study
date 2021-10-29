package october.fourweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 시간초과가 포인트
// 향상된 for문을 사용할 것!!! 일반 for문보다 빠르다.
// 향상된 for문은 iter를 내부적으로 사용한다.
public class B_16235_나무재테크 {

	static List<Tree> T = new LinkedList<>();
	static int[][] map, vita;
	static int N, M, K;
	static List<Tree> dieT;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int[] m : map) { // 처음 시작의 양분은 모두 5
			Arrays.fill(m, 5);
		}
		vita = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				vita[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			T.add(new Tree(x, y, z));
		} // 입력 끝

		// K년도 만큼
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			autumn();
			winter();
		}

		int result = T.size();
		System.out.println(sb.append(result));
	}

	// 양분 추가
	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += vita[i][j];
			}
		}
	}

	// 번식
	private static void autumn() {
		int[][] dir = { { -1, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		List<Tree> babyT = new LinkedList<>();
		for (Tree t : T) { // 향상된 for문 사용
			int age = t.age;
			if (age % 5 != 0) // 5의 배수가 아니면
				continue;
			int r = t.r;
			int c = t.c;
			for (int d = 0; d < 8; d++) {
				int mr = r + dir[d][0];
				int mc = c + dir[d][1];
				if (mr < 0 || mc < 0 || mr >= N || mc >= N)
					continue;
				babyT.add(new Tree(mr, mc, 1));
			}
		}
		T.addAll(0, babyT); // 어린 나무를 앞에 배열 붙임
	}

	// 나무 거름 양분 추가
	private static void summer() {
		for (Tree dt : dieT) { // 향상된 for문 사용
			int r = dt.r;
			int c = dt.c;
			int age = dt.age;
			map[r][c] += age / 2;
		}
	}

	// 양분 먹고 나이 증가 or 나무 죽음
	private static void spring() {
		dieT = new ArrayList<>(); // 년도마다 죽은 나무 초기화
		Iterator<Tree> iter = T.iterator(); // iterator 사용
		while (iter.hasNext()) { // while의 hasNext
			Tree t = iter.next(); // next
			int r = t.r;
			int c = t.c;
			int age = t.age;
			if (map[r][c] < age) { // 나무는 죽게됨.
				dieT.add(new Tree(r, c, age));
				iter.remove(); // remove
			} else { // 양분을 먹고 나이 1 증가
				map[r][c] -= age;
				t.age = age + 1;
			}
		}

	}

	static class Tree {

		int r, c, age;

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}
	}
}
