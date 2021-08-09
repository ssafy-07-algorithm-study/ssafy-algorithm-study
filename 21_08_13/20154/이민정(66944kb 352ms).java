import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_20154_이구역의승자는누구야 {
	public static void main(String[] args) throws IOException {
		// Map을 쓰면 더 좋겠지만 아직 잘 쓸줄 모룸 ㅜ
		// char A = int 65 //char Z = int 90

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // 알파벳 대문자로만 이루어진 문자열
		int[] num = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 }; // 순서대로 알파벳별 획수 배열

		Queue<Integer> gameQ = new LinkedList<Integer>(); // 알파벳 하나씩 담을 큐

		// 문자열을 한글자씩 int형으로 변환하여 queue에 담음
		for (int i = 0; i < str.length(); i++) {
			// -65를 하여서 획수 배열의 index와 맞춰주고
			// num배열에서 그 index값을 가져와서 gameQ에 넣음
			gameQ.offer(num[(int) (str.charAt(i)) - 65]);
		}

		while (gameQ.size() > 1) {
			// 큐에 한개 남을때까지 계속 반복
			int plus = gameQ.poll() + gameQ.poll();// 2개씩 더함
			if (plus >= 10) // 더한값이 10보다 크면
				plus %= 10; // 10으로 나눈 나머지로 바꿔줌
			gameQ.offer(plus); // 맨뒤에 더하기
		}

		if (gameQ.peek() % 2 == 1) {
			System.out.println("I'm a winner!");
		} else {
			System.out.println("You're the winner?");
		}
	}
}
