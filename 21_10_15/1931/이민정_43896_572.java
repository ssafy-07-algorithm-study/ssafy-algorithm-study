import java.io.*;
import java.util.*;

//	43896	572

public class BOJ_1931_회의실배정 {

	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end) // 종료시간이 같으면 시작시간이 빠른 순으로
				return this.start - o.start;
			return this.end - o.end; // 종료시간 순으로 오름차순 정렬
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 회의 개수

		List<Meeting> meetings = new ArrayList<Meeting>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings.add(new Meeting(start, end));
		}

		Collections.sort(meetings);

		int meet = 1;
		int curS = meetings.get(0).start;
		int curE = meetings.get(0).end;

		for (int i = 1; i < N; i++) {
			int nextS = meetings.get(i).start;
			int nextE = meetings.get(i).end;

			if (nextS >= curE) {
				curS = nextS;
				curE = nextE;
				meet++;
			}
		}

		System.out.println(meet);
	}
}
