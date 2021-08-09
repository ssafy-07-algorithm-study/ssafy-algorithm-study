import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', 3); map.put('B', 2); map.put('C', 1); map.put('D', 2); map.put('E', 3); map.put('F', 3); map.put('G', 3);
		map.put('H', 3); map.put('I', 1); map.put('J', 1); map.put('K', 3); map.put('L', 1); map.put('M', 3); map.put('N', 3);
		map.put('O', 1); map.put('P', 2); map.put('Q', 2); map.put('R', 2); map.put('S', 1); map.put('T', 2); map.put('U', 1);
		map.put('V', 1); map.put('W', 2); map.put('X', 2); map.put('Y', 2); map.put('Z', 1);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String game = bufferedReader.readLine();
		int length = game.length();
		int []number = new int[length];
		
		for(int i=0;i<length;i++) {
			number[i]= map.get(game.charAt(i)); 
		}
		
		while (true) {
			if(length == 1) {
				break;
			}
			for(int i=0;i<length;i=i+2) {
				if(i == length-1) {
					number[i/2]= number[i];
					break;
				}
				number[i/2]= (number[i]+number[i+1])%10; 
			}
			length = length/2 + length%2;
		}
		
		if(number[0] %2 ==1) {
			System.out.println("I'm a winner!");
		}
		else {
			System.out.println("You're the winner?");
		}
	}
}