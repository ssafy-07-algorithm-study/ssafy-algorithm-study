

import java.io.*;
import java.util.*;

public class À±Èñ¿µ {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int count = 0;
		StringTokenizer st = new StringTokenizer(n," ");
		count = st.countTokens();
		System.out.println(count);

	}

}
