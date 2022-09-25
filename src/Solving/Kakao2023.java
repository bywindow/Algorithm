package Solving;

import java.io.*;
import java.util.*;

public class Kakao2023 {

    // public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
    //     long answer = 0;

    //     int[][] map = new int[n][2];
    //     for(int i = 0; i < n; i++){
    //         map[i][0] = deliveries[i];
    //         map[i][1] = pickups[i];

    //     }
    //     while(true){
    //         int distD = 0;
    //         int distP = 0;
    //         int curD = 0;
    //         int curP = 0;
    //         for(int i = n-1; i >= 0; i--){
    //             if (map[i][0] == 0 && map[i][1] == 0) {
    //                 continue;
    //             }
    //             if (curD < cap && map[i][0] > 0){
    //                 distD = Math.max(distD, i+1);
    //                 if (curD + map[i][0] <= cap){
    //                     curD += map[i][0];
    //                     map[i][0] = 0;
    //                 } else {
    //                     map[i][0] += curD - cap;
    //                     curD = cap;
    //                 }
    //             }
    //             if (curP < cap && map[i][1] > 0){
    //                 distP = Math.max(distP, i+1);
    //                 if (curP + map[i][1] <= cap){
    //                     curP += map[i][1];
    //                     map[i][1] = 0;
    //                 } else {
    //                     map[i][1] += curP - cap;
    //                     curP = cap;
    //                 }
    //             }
    //         }
    //         answer += Math.max(distD, distP) * 2;
    //         if (curD == 0 && curP == 0) break;
    //     }
        
    //     return answer;
    // }


    // public static int[] solution(String today, String[] terms, String[] privacies) {
    //     HashMap<Character, Integer> hm = new HashMap<>();
    //     ArrayList<Integer> result = new ArrayList<>();
    //     for(int i = 0; i < terms.length; i++){
    //         String[] temp = terms[i].split(" ");
    //         hm.put(temp[0].charAt(0), Integer.parseInt(temp[1]));
    //     }
    //     String[] tod = today.split("[.]");
    //     int ty = Integer.parseInt(tod[0]);
    //     int tm = Integer.parseInt(tod[1]);
    //     int td = Integer.parseInt(tod[2]);
    //     for(int i = 0; i < privacies.length; i++){
    //         String[] cur = privacies[i].split("[.]");
    //         int y = Integer.parseInt(cur[0]);
    //         int m = Integer.parseInt(cur[1]);
    //         String[] temp = cur[2].split(" ");
    //         int d = Integer.parseInt(temp[0].trim());
    //         char type = temp[1].charAt(0);

    //         int nm = m + hm.get(type) % 12;
    //         int ny = y + hm.get(type) / 12;
    //         int nd = d-1;
    //         if (nm > 12) {
    //             ny += 1;
    //             nm -= 12;
    //         }
    //         if (ty > ny) {
    //             result.add(i+1);
    //         } else if(ty == ny && tm > nm) {
    //             result.add(i+1);
    //         } else if(ty == ny && tm == nm && td > nd) {
    //             result.add(i+1);
    //         }
    //     }
    //     int[] answer = new int[result.size()];
    //     for(int i = 0; i < answer.length; i++){
    //         answer[i] = result.get(i);
    //     }

    //     return answer;
    // }

    static boolean changeable = true;

    static void recur(String arr){
        int len = arr.length();
        if (len <= 2) return;
        if (arr.charAt(len/2) == '0'){
            String left = arr.substring(0, len/2);
            String right = arr.substring(len/2+1, len);
            int leftlen = left.length();
            int rightlen = right.length();
            if (left.charAt(leftlen/2) == '1') {
                changeable = false;
                return;
            }
            if (right.charAt(rightlen/2) == '1') {
                changeable = false;
                return;
            }
        }
        recur(arr.substring(0, len/2));
        recur(arr.substring(len/2, len));
    }


    static String deli(long number){
        String str = "";
        while(number > 0){
            str += String.valueOf(number % 2);
            number = number / 2;
        }
        StringBuffer sb = new StringBuffer(str);
        String rstr = sb.reverse().toString();
        return rstr;
    }


    public static int[] solution(long[] numbers) {
        String input = "";
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String arr = deli(numbers[i]);
            recur(arr);
            if(changeable){
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
            changeable = true;
        }
        return answer;
    }

    // int[][] map;

    // void 

    // public String solution(int n, int m, int x, int y, int r, int c, int k) {
    //     String answer = "";
    //     map = new int[n][m];
    //     map[x][y] = 1;
    //     map[r][c] = 2;
    //     Queue<int[]> q = new LinkedList<>();

    //     return answer;
    // }

    public void main(String[] args) {
        
        long[] a = { 7, 5};
        System.out.println(solution(a));
    }

}