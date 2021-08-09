

import java.io.*;

public class À±Èñ¿µ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int a2 = Integer.parseInt(a, 2); //10Áø¼ö·Î º¯È¯
		String a8 = Integer.toOctalString(a2);
		System.out.println(a8);
		
		

	}

}
