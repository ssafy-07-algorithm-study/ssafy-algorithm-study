

import java.io.*;

public class ���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int a2 = Integer.parseInt(a, 2); //10������ ��ȯ
		String a8 = Integer.toOctalString(a2);
		System.out.println(a8);
		
		

	}

}
