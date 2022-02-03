package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
    for(int i = 0; i < n; i++){
      int input = Integer.parseInt(br.readLine());
      if(input == 0) System.out.println(pq.isEmpty() ? 0 : pq.poll());
      else pq.add(input);
    }
  }
}
