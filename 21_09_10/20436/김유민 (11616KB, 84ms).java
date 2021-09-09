import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class position{
	private int x;
	private int y;
	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}	
}
public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		HashMap<Character, position> map= new HashMap<>();
		map.put('q', new position(0, 0));	map.put('w', new position(0, 1));	map.put('e', new position(0, 2));	map.put('r', new position(0, 3));	map.put('t', new position(0, 4));
		map.put('y', new position(0, 5));	map.put('u', new position(0, 6));	map.put('i', new position(0, 7));	map.put('o', new position(0, 8));	map.put('p', new position(0, 9));
		map.put('a', new position(1, 0));	map.put('s', new position(1, 1));	map.put('d', new position(1, 2));	map.put('f', new position(1, 3));	map.put('g', new position(1, 4));
		map.put('h', new position(1, 5));	map.put('j', new position(1, 6));	map.put('k', new position(1, 7));	map.put('l', new position(1, 8));	map.put('z', new position(2, 0));
		map.put('x', new position(2, 1));	map.put('c', new position(2, 2));	map.put('v', new position(2, 3));	map.put('b', new position(2, 4));	map.put('n', new position(2, 5));
		map.put('m', new position(2, 6));
		
		char left = st.nextToken().charAt(0);
		int lx = map.get(left).getX();
		int ly = map.get(left).getY();

		char right = st.nextToken().charAt(0);
		int rx = map.get(right).getX();
		int ry = map.get(right).getY();
		
		String s = "qwertasdfgzxcv";
		String zoac = br.readLine();
		answer += zoac.length();
		int tmpx, tmpy;
		
		for(int ss=0;ss<zoac.length();ss++) {
			tmpx = map.get(zoac.charAt(ss)).getX();
			tmpy = map.get(zoac.charAt(ss)).getY();
			
			if(s.contains(zoac.charAt(ss)+"")){
				answer += Math.abs(lx-tmpx) + Math.abs(ly-tmpy);
				lx = tmpx;
				ly = tmpy;
			}else {
				answer += Math.abs(rx-tmpx) + Math.abs(ry-tmpy);
				rx = tmpx;
				ry = tmpy;
			}
		}
		System.out.println(answer);
	}
} 
