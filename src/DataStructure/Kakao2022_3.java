package DataStructure;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Kakao2022_3 {

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < records.length; i++){
            hm.put(Integer.parseInt(records[i].split(" ")[1]), 0);
        }
        List<Integer> kl = new ArrayList<>(hm.keySet());
        kl.sort((s1, s2) -> s1.compareTo(s2));
        for(int i : kl){
            boolean isIn = false;
            Date inTime = f.parse("00:00");
            for(int j = 0; j < records.length; j++){
                String[] curRec = records[j].split(" ");
                if(Integer.parseInt(curRec[1]) != i) continue;
                if(curRec[2].equals("IN")){
                    inTime = f.parse(curRec[0]);
                    isIn = true;
                } else {
                    isIn = false;
                    long diff = f.parse(curRec[0]).getTime() - inTime.getTime();
                    hm.put(i, hm.get(i) + (int)diff/1000/60);
                }
            }
            if(isIn){
                long diff = f.parse("23:59").getTime() - inTime.getTime();
                hm.put(i, hm.get(i) + (int)diff/1000/60);
            }
        }
        int[] answer = new int[hm.size()];
        int cnt = 0;
        for(int i : kl){
            if(hm.get(i) <= fees[0]) answer[cnt] = fees[1];
            else{
                int hour = (hm.get(i) - fees[0]) % fees[2] == 0 ? (hm.get(i) - fees[0])/fees[2] : (hm.get(i) - fees[0])/fees[2]+1;
                answer[cnt] = fees[1] + hour * fees[3];
            }
            cnt++;
        }
        return answer;
    }


    public static void main(String[] args) throws ParseException {
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
