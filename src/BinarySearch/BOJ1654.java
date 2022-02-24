package BinarySearch;

import java.util.*;
import java.io.*;

public class BOJ1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lan = new long[k];
        long max = 0;
        long min = 1;
        for(int i = 0; i < k; i++){
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(lan[i], max);
        }
        //최소 길이와 최대 길이를 시작으로 이분탐색한다
        int answer = 0;
        while(min <= max){
            long mid = (max + min) / 2;
            int result = 0;
            for(long i : lan) {
                result += (i / mid);
            }
            if(result < n){
                max = mid - 1;
            } else {
                min = mid + 1;
                answer = Math.max(answer, (int)mid);
            }
        }
        System.out.println(answer);
    }
}
