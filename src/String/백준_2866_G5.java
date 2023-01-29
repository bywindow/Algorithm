package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main2866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] table = new char[r][c];
        for(int i = 0; i < r; i++){
            String cur = br.readLine();
            for(int j = 0; j < c; j++){
                table[i][j] = cur.charAt(j);
            }
        }

        String[] sums = new String[c];
        for(int i = 0; i < c; i++){
            String result = "";
            for(int j = 0; j < r; j++){
                result += table[j][i];
            }
            sums[i] = result;
        }
        int answer = 0;
        while(sums[0].length() > 0){
            boolean isSame = false;
            for(int i = 0; i < sums.length; i++){
                sums[i] = sums[i].substring(1);
            }
            Arrays.sort(sums);
            for(int i = 1; i < sums.length; i++){
                if(sums[i].equals(sums[i-1])){
                    isSame = true;
                    break;
                }
            }
            if (isSame) break;
            answer++;
        }
        System.out.println(answer);
    }
}