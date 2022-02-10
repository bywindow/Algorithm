package DataStructure;

import java.util.*;
import java.io.*;

public class Kakao2022_1 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        String[] reported = new String[id_list.length];
        for(int i = 0; i < reported.length; i++){
            reported[i] = "";
        }
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            hm.put(id_list[i], 0);
        }
        for(int i = 0; i < id_list.length; i++){
            String cur = id_list[i];
            for(int j = 0; j < report.length; j++){
                String[] curReport  = report[j].split(" ");
                if(curReport[0].equals(cur)){
                    if(!reported[i].contains(curReport[1])) {
                        reported[i] += (curReport[1] + " ");
                        hm.put(curReport[1], hm.get(curReport[1])+1);
                    }
                }
            }
        }
        for(String s : hm.keySet()){
            if(hm.get(s) >= k){
                for(int i = 0; i < reported.length; i++){
                    if(reported[i].contains(s)) answer[i] += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }

}
