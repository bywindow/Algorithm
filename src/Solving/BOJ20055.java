package Solving;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ20055 {

  static int n, k;
  static int[] a;
  static int cnt = 0;
  static ArrayList<Integer> robot; // 벨트에 올라간 순서대로 삽입. 현재 위치를 나타냄

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    a = new int[n * 2];
    robot = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < a.length; i++){
      a[i] = Integer.parseInt(st.nextToken());
    }
    int curK = 0;
    while(curK < k){
      cnt++;
      // 1. 벨트와 로봇이 함께 한 칸 이동
      moveBelt(a);
      moveRobot(robot);
      // 2. 로봇만 한 칸 이동
      // 가장 먼저 올라간 로봇부터..? -> arrayList
      for(int i = 0; i < robot.size(); i++){
        // 한칸 앞의 내구도가 1이상인지?
        int next = robot.get(i)+1 == n*2 ? 0 : robot.get(i)+1;
        if(a[next] < 1) continue;
        // 이동하려는 칸에 로봇이 있는지 없는지?
        boolean canMove = true;
        for(int j = 0; j < robot.size(); j++){
          if(next == robot.get(j)){
            canMove = false;
            break;
          }
        }
        // 내구도가 1이상이고, 앞에 로봇이 없다
        if(canMove){
          // 해당 칸의 내구도 1 감소
          a[next]--;
          // n번째 칸이라면 바로 로봇을 내린다
          if(next == n-1) robot.remove(i);
          else robot.set(i, next);
        }
      }
      // 로봇 올리기
      if(a[0] >= 1){
        robot.add(0);
        a[0]--;
      }
      // 내구도가 0인 칸의 개수
      curK = 0;
      for(int i : a){
        if(i == 0) curK++;
      }
    }
    System.out.println(cnt);
  }
  // 벨트 이동하는 함수
  static void moveBelt(int[] a){
    int temp = a[a.length-1];
    for(int i = 0; i < a.length-1; i++){
      a[i+1] = a[i];
    }
    a[0] = temp;
    return;
  }
  // 로봇 이동
  static void moveRobot(ArrayList<Integer> robot){
    for(int i = 0; i < robot.size(); i++){
      int cur = robot.get(i);
      if(cur + 1 == n*2){
        robot.set(i, 0);
      } else if (cur + 1 == n-1) {
        robot.remove(i);
      }else {
        robot.set(i, cur+1);
      }
    }
  }
}
