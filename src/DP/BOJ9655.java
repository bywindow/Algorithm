package Baekjoon;
/**
 * @Date:2021-04-17
 * @Algorithm:DP
 * @Title:돌게임
 * @Desc: 두 명이 n개의 돌을 번갈아가면서 1 또는 3개씩 가져가는데 마지막 돌을 가져가는 사람이 이기는 게임
 */

import java.util.*;
import java.io.*;

public class BOJ9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        if(n % 2 == 1) System.out.println("SK");
        else System.out.println("CY");

    }
}
