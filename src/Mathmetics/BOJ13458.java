package Mathmetics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // # of room
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] rooms = new int[n]; // # of each room's people
    for(int i = 0; i < n; i++){
      rooms[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int main = Integer.parseInt(st.nextToken()); // 총감독 한명이 맡을 수 있는 수험생
    int sub = Integer.parseInt(st.nextToken()); // 부감독 한명이 맡을 수 있는 수험생

    long answer = n; // 기본적으로 총감독이 한 방에 한명씩
    // n의 최댓값이 1000000이고 각 방의 수험생 수의 최대값도 1000000이므로 long 타입으로 해야함!!!!!

    for(int i = 0; i < n; i++){
      rooms[i] -= main;
      if(rooms[i] <= 0) continue;
      if(rooms[i] % sub == 0) answer += (rooms[i] / sub);
      else answer += (rooms[i] / sub + 1);
    }
    System.out.println(answer);
  }
}
