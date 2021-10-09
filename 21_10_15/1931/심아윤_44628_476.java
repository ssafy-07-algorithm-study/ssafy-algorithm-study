package october.twoweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_1931_회의실배정 { // 최대한의 회의
// 1. 처음 시작 시간으로 정렬
// 2. 시작 시간이 같으면 끝나는 시간이 빠른 순으로 정렬 -> 회의시간이 짧은 순
// 3. 시작 시간이 늦어도 끝나는 시간이 빠르면 갱신.
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		List<Time> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Time(s, e));
		}
		// 정렬
		Collections.sort(list);
		Time now = list.get(0);
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			Time next = list.get(i);
			if (now.e <= next.s) { // 다음 회의 가능
				cnt++;
				now = list.get(i);
			} else if (now.s == next.s) // 시작시간이 같다면 패스 - 이미 짧은 회의시간이 우위 정렬
				continue;
			else if (now.e > next.e) { // 끝나는 시간이 더 빠르다면 cnt의 개수갱신 없이 now만 갱신
				now = list.get(i);
			}
		}

		System.out.println(sb.append(cnt));
	}

	static class Time implements Comparable<Time> {
		int s, e; // 시작시간, 끝나는시간

		public Time(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Time o) {
			if (this.s == o.s) { // 2번 조건
				return Integer.compare(this.e, o.e);
			}
			return Integer.compare(this.s, o.s); // 1번 조건
		}

	}
}
