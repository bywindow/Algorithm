package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main16926{

    static int[][] arr;
    static int n;
    static int m;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //rotate
        int rect = Math.min(n, m) / 2;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < rect; j++){
                int temp = arr[j][j];
                //top
                for(int k = j; k < m - j - 1; k++){
                    arr[j][k] = arr[j][k+1];
                }
                //right
                for(int k = j; k < n - j - 1; k++){
                    arr[k][m-j-1] = arr[k+1][m-j-1];
                }
                //bottom
                for(int k = m - j - 1; k > j; k--){
                    arr[n-j-1][k] = arr[n-j-1][k-1];
                }
                //left
                for(int k = n - j - 1; k > j; k--){
                    arr[k][j] = arr[k-1][j];
                }
                arr[j+1][j] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] a: arr){
            for(int b: a){
                sb.append(b).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}