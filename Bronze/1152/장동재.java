package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> hmap = new HashMap<>();
		String[] strList = br.readLine().trim().split(" ");

		for (String str : strList) {
			if (hmap.get(str) == null)
				hmap.put(str, 1);
		}

		System.out.println(hmap.get(" ") == null ? hmap.size() : hmap.size() - 1);
	}
}
