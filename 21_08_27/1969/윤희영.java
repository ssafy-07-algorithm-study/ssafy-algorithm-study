

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][]alphabet = new int[M][26];
		StringBuilder sb = new StringBuilder();
		int hammingDistance = 0;
		
		String[] dnas = new String[N];
		
		for(int i = 0; i < N; i++) {
			dnas[i] = br.readLine();
			for(int j = 0; j < M; j++) {
				alphabet[j][dnas[i].charAt(j) - 'A'] += 1;
			}
		}
		
//		for(int i = 0; i < M; i++) {
//			
//			for(int j = 0; j < 26; j++) {
//				System.out.print(alphabet[i][j]);
//			}
//			System.out.println();
//		}
		
		
		for(int i =0; i< M; i++) {
			int max = alphabet[i][0]; //ù��°�� a�� � ���Ӵ���
			char target = 'A';
			for(int j =0; j< 26; j++) {
				if(alphabet[i][j] > max) {// �ٸ� ���ĺ��� ���� ���ڰ� ù��° a�� ���� ���ں��� ũ��
					max = alphabet[i][j];
					target = (char)(j + 'A'); // �� �ٿ��� ���� ���� ���� �ܾ �����ܾ�����
				}
			}
			sb.append(target);
		}
		
		for(int i=0; i < N; i++) {
			for(int j =0; j<M; j++) {
				if(dnas[i].charAt(j) != sb.charAt(j)) hammingDistance++;
			}
		}
		System.out.println(sb);
		System.out.println(hammingDistance);

	}

}
