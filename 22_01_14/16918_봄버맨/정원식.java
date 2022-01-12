package BOJ.DontKnow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨 {

    static class Bomb {
        public boolean exist;
        public int time;
    }

    static int R, C, N;
    static Bomb[][] map;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new Bomb[R][C];
        // 초기화
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                if(str.charAt(j) == 'O') {
                    map[i][j] = new Bomb();
                    map[i][j].exist = true;
                    map[i][j].time = 1; // 1초는 뺌
                    break;
                } else if(str.charAt(j) == '.') {
                    map[i][j] = new Bomb();
                    map[i][j].exist = false;
                }
            }
        }
        N -= 2;    // 1초에는 초기화. 2초에는 아무것도 안함.


        boolean isTimeOdd = true;

        while(N > 0) {

            if(isTimeOdd) { // 홀수 초, 설치
                for(int i = 0; i < R; i ++) {
                    for(int j = 0; j < C; j++) {
                        if(map[i][j].exist == true) {
                            map[i][j].time--;
                        } else {
                            map[i][j].exist = true;
                            map[i][j].time = 2;
                        }
                    }
                }
            } else {    // 짝수 초, 폭발
                for(int i = 0; i < R; i ++) {
                    for (int j = 0; j < C; j++) {

                        if(map[i][j].exist == true) {
                            if(map[i][j].time == 0) {
                                // 폭발
                                map[i][j].exist = false;
                                for(int d = 0; d < 4; d++) {
                                    int nr = i + dr[d];
                                    int nc = j + dc[d];
                                    if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                                    map[nr][nc].exist = false;
                                    map[nr][nc].time = 0;
                                }
                            }else {
                                map[i][j].time--;
                            }
                        }

                    }
                }
            }

            isTimeOdd = !isTimeOdd;
            N--;
        }


        for(Bomb[] i : map) {
            for(Bomb j : i) {
                if(j.exist == true) {
                    sb.append("O");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

    }
}
