/*
나중에 풀어보자...
 */
package BinarySearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2143 {

    static int cnt = 0;
    static Queue<Integer> que_a = new LinkedList<>();
    static Queue<Integer> que_b = new LinkedList<>();

    static void recur(int t, int[] a, int idx_a, int[] b, int idx_b, int sum){

        if(sum == t) {
            cnt++;
            return;
        }

        else if(sum > t) return;

        else{

            recur(t, a, idx_a, b, idx_b+1,sum+a[idx_a]+b[idx_b]);
            recur(t, a, idx_a+1, b, idx_b,sum+a[idx_a]+b[idx_b]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        ArrayList<Integer> list_a = new ArrayList<>();
        ArrayList<Integer> list_b = new ArrayList<>();
        list_a.add(a[0]);
        while(!list_a.isEmpty()){


        }


        recur(T,a,0,b,0,0);
        System.out.println(cnt);

    }
}
