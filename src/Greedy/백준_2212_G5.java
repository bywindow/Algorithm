package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] sensors = new int[n];
        for(int i = 0; i < n; i++){
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);
        int[] diff = new int[n-1];
        for(int i = 0; i < n-1; i++){
            diff[i] = sensors[i+1] - sensors[i];
        }
        Arrays.sort(diff);
        int answer = 0;
        for(int i = 0; i < n-k; i++){
            answer += diff[i];
        }
        System.out.println(answer);
    }
}