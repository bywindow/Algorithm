package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj7662 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    // initialize treemap<value, count>
    TreeMap<Integer, Integer> tm = new TreeMap<>(); // 작은 값이 앞에, 큰 값에 뒤에 저장됨
    // test-case
    int t = Integer.parseInt(br.readLine());
    for(int i = 0; i < t; i++){
      int k = Integer.parseInt(br.readLine());
      tm.clear();
      for(int j = 0; j < k; j++){
        st = new StringTokenizer(br.readLine());
        char func = st.nextToken().charAt(0);
        int num = Integer.parseInt(st.nextToken());
        // function
        // insert
        if(func == 'I'){
          // 같은 값이 삽입될 경우, count+1
          tm.put(num, tm.getOrDefault(num, 0)+1);
        }
        // delete
        else{
          // pass if map size == 0
          if(tm.isEmpty()) continue;
          int value, cnt;
          // delete max
          if(num == 1){
            value = tm.lastKey();
          }
          //delete min
          else{
            value = tm.firstKey();
          }
          cnt = tm.get(value);
          // delete if count == 1
          tm.remove(value);
          if(cnt > 1) tm.put(value, cnt-1);
        }
      }
      // print empty
      if(tm.isEmpty()) sb.append("EMPTY\n");
      // print max, min
      else{
        sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
      }
    }
    System.out.println(sb.toString());
  }
}
