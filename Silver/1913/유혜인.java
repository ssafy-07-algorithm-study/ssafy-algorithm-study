//133408kb 4848ms

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][n];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};   // 위 아래 왼 오

        int center = n/2;
        arr[center][center] = 1;
        int nx = center;
        int ny = center;

        int num = 1;
        for(int i=1;i<center+1;i++){
            // 위 한번
            nx = nx + dx[0];
            ny = ny + dy[0];
            arr[nx][ny] = ++num;

            // 오른  i*2 + 1
            for(int j=0;j<i*2-1;j++){
                nx = nx + dx[3];
                ny = ny + dy[3];
                arr[nx][ny] = ++num;
            }

            for(int j=0;j<i*2;j++){
                nx = nx + dx[1];
                ny = ny + dy[1];
//                System.out.println(nx+" "+ny);
                arr[nx][ny] = ++num;
            }

            for(int j=0;j<i*2;j++){
                nx = nx + dx[2];
                ny = ny + dy[2];
                arr[nx][ny] = ++num;
            }

            for(int j=0;j<i*2;j++){
                nx = nx + dx[0];
                ny = ny + dy[0];
                arr[nx][ny] = ++num;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }

            System.out.println("");
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == k){
                    int row = i+1;
                    int col = j+1;
                    System.out.println(row+" "+col);
                }
            }
        }

    }
}
