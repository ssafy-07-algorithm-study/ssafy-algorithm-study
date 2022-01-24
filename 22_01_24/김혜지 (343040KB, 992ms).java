import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        Queue<Long> numbers = new PriorityQueue<Long>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1 > o2 ? -1 : 1;
            }
        });

        for (int i = 0; i < N; i++) {
            String[] numbersInARow = in.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                numbers.add(Long.parseLong(numbersInARow[j]));
            }
        }

        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer = numbers.poll();
        }

        System.out.println(answer);
    }
}
