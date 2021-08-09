import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리 : 52084KB, 시간 : 612ms
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		int n = Integer.parseInt(bufferedReader.readLine());
		int findNum = Integer.parseInt(bufferedReader.readLine());
		int middle = n/2;
		int [][] snail= new int[n][n]; 
		
		int inputNumber = 1;
		int recur = 1;
		int switchNum = 1;
		int x = middle;
		int y = middle;
		snail[x][y] = inputNumber;
		
		while (true) {
			for(int i=0;i<recur;i++) {
				inputNumber++;
				x-= switchNum;
				snail[x][y]=inputNumber;
				if(inputNumber >= n*n) {
					break;
				}
			}
			if(inputNumber >= n*n) {
				break;
			}
			for(int i=0;i<recur;i++) {
				inputNumber++;
				y += switchNum;
				snail[x][y]=inputNumber;
			}
			switchNum *=-1;
			recur +=1;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				stringBuilder.append(snail[i][j]).append(" ");
				if(snail[i][j] == findNum) {
					x=i+1;
					y=j+1;
				}
			}
			stringBuilder.append("\n");
		}
		stringBuilder.append(x).append(" ").append(y);
		
		System.out.println(stringBuilder);
	}
}
