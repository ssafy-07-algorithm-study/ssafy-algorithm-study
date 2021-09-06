package s5_20436_zoac3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Character, int[]> alpaMap = new HashMap<Character, int[]>() {{
			put('q', new int[] {0,0}); put('w', new int[] {0,1});
			put('e', new int[] {0,2}); put('r', new int[] {0,3});
			put('t', new int[] {0,4}); put('y', new int[] {0,5});
			put('u', new int[] {0,6}); put('i', new int[] {0,7});
			put('o', new int[] {0,8}); put('p', new int[] {0,9});
			put('a', new int[] {1,0}); put('s', new int[] {1,1});
			put('d', new int[] {1,2}); put('f', new int[] {1,3});
			put('g', new int[] {1,4}); put('h', new int[] {1,5});
			put('j', new int[] {1,6}); put('k', new int[] {1,7});
			put('l', new int[] {1,8}); put('z', new int[] {2,0});
			put('x', new int[] {2,1}); put('c', new int[] {2,2});
			put('v', new int[] {2,3}); put('b', new int[] {2,4});
			put('n', new int[] {2,5}); put('m', new int[] {2,6});
		}};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		char L = st.nextToken().toCharArray()[0];
		char R = st.nextToken().toCharArray()[0];
		
		int answer = 0;
		char[] input = br.readLine().toCharArray();
		
		for (char i : input) {
			char target;
			if (i=='y' || i == 'u' || i == 'i' || i == 'o' || i == 'p' ||
				i=='h' || i == 'j' || i == 'k' || i == 'l' || i == 'b' || 
				i=='n' || i == 'm') {
				target = R;
				R = i;
			}else {
				target = L;
				L = i;
			}
			
			answer += Math.abs(alpaMap.get(target)[0] - alpaMap.get(i)[0])
					+ Math.abs(alpaMap.get(target)[1] - alpaMap.get(i)[1]) + 1 ;
		}
		System.out.println(answer);
		
	}
}
