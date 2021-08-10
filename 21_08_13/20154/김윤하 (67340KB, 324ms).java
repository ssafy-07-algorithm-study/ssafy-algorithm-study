package b1_20154_이구역의승자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int[] num = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
		String[] answer = {"You're the winner?", "I'm a winner!"};
		
		
		char[] munzas = br.readLine().toCharArray();
		for (char munza : munzas)
			queue.offer(num[munza-'A']);
		
		while(queue.size() != 1) {
			queue.offer((queue.poll()+queue.poll()%10));
		}
		
		System.out.println(answer[queue.poll()%2]);
		
		
	}
}
