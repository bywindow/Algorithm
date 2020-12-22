/*
벽의 높이를 나타내는 배열을 입력받고, 비가 내렸을 때 모아지는 빗물의 총양을 계산하는 프로그램
 */
package Bootcamp;

public class storedWater {
    public static int CalWater(int[] wall) {
        int final_water = 0;
        for (int i = 0; i < wall.length-1;i++) {
            int water = 0;
            int j = i + 1;
            for (; j < wall.length;j++ ) {
                if (wall[i] > wall[j]) {
                    water += (wall[i] - wall[j]);
                } else {
                    i=j-1;
                    final_water+=water;
                    break;
                }
            }
        }
        return final_water;
    }
    public static void main(String[] args) {
        int[] wall = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(CalWater(wall));
    }
}

