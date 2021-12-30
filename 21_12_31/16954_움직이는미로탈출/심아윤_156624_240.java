package december.fifth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_16954_움직이는미로탈출 {

	static char[][] arr = new char[8][8];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			String str = in.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		boolean result = bfs();
		if (result)
			sb.append(1);
		else
			sb.append(0);
		System.out.println(sb);
	}

	private static boolean bfs() {
		// 제자리에 있을수도 있다. => 방문체크 X 또는 방문처리를 3차원으로도 가능하다.
		int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
				{ -1, -1 } };
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(7, 0));
		while (!q.isEmpty()) {
			int size = q.size(); // 한번의 사이클을 위해!!
			for (int i = 0; i < size; i++) {
				Node now = q.poll();
				int y = now.y;
				int x = now.x;
				if (arr[y][x] == '#') // 체스판 이동 후 벽이 되었으면
					continue;
//				if (y == 0 && x == 7) { // 성공 => 여기에 놓으면 메모리초과 발생!!!!
//					return true;
//				}
				for (int d = 0; d < 9; d++) {
					int my = y + dir[d][0];
					int mx = x + dir[d][1];
					if (my < 0 || mx < 0 || my > 7 || mx > 7 || arr[my][mx] == '#')
						continue;
					if (my == 0 && mx == 7) { // 성공 => 큐에 넣기전에 성공여부 확인
						return true;
					}
					q.offer(new Node(my, mx));
				}
			}
			downBoard();
		}
		return false;
	}

	private static void downBoard() { // 체스판 이동
		for (int i = 6; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				arr[i + 1][j] = arr[i][j];
			}
		}
		for (int i = 0; i < 8; i++) {
			arr[0][i] = '.';
		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
