package Baekjoon;

/**
 * 정수의 범위 : -2^31 ~ 2^31 -> int
 * 탐색 알고리즘
 */

import java.util.*;
import java.io.*;

public class BOJ1920 {

    static int n;
    static int[] arr;

    static void binary(int start, int end, int target) {
        if (arr[start] == target || arr[end] == target || arr[(start + end) / 2] == target) {
            System.out.println(1);
        } else if (start + 2 < end) {
            if (target < arr[(start + end) / 2]) binary(start, (start + end) / 2 - 1, target);
            else binary((start + end) / 2 + 1, end, target);
        } else System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            binary(0, n - 1, Integer.parseInt(st.nextToken()));
        }
    }
}
