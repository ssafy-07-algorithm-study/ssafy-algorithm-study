package week14;

import java.io.*;
import java.util.*;

public class BOJ23301 {
	public static class Time {
		int start, end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		List<Time> times = new ArrayList<>();
		
		int min = 1001, max = -1;
		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int curStart = Integer.parseInt(st.nextToken()), curEnd = Integer.parseInt(st.nextToken());
				times.add(new Time(curStart, curEnd));
				
				if (min > curStart) min = curStart;
				if (max < curEnd) max = curEnd;
			}
		}
		
		int size = times.size();
		
		int result = 0;
		int start = -1, end = 1001;
		for (int curStart = min; curStart <= max - K; curStart++) {
			int curEnd = curStart + K;
			int tempResult = 0;
			for (int j = 0; j < size; j++) {
				Time curTime = times.get(j);
				
				if (curStart >= curTime.end || curEnd <= curTime.start) continue;	// 아예 범위 밖인 경우에는 스킵 
				tempResult += Math.min(curTime.end, curEnd) - Math.max(curTime.start, curStart);	// 아니면 겹치는 값으로 체크
			}
			if (result < tempResult) {
				result = tempResult;
				start = curStart;
				end = curEnd;
			}
		}
		
		System.out.println(start + " " + end);
	}
}
