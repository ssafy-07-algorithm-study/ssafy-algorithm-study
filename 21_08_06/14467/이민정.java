
//메모리 14116KB 
//시간 128ms
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14467_소가길을건너간이유1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int see = Integer.parseInt(in.readLine());
		String[] road = new String[10]; // null로 초기화 됨
		int moveCnt = 0;

		for (int i = 0; i < see; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int cowNum = Integer.parseInt(st.nextToken()) - 1;
			String cowLoc = st.nextToken();
			if (road[cowNum] != null) { // null이 아니면 들어올 위치랑 현재 위치랑 비교
				if (!road[cowNum].equals(cowLoc)) // 다르면
					moveCnt++;
			}
			road[cowNum] = cowLoc;
		}
		System.out.println(moveCnt);
	}
}
