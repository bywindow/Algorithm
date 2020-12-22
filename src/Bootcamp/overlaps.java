/*
일정간격의 병합
아무 규칙도 없는 간격의 모음 들이 입력 되면 겹치는 간격을 병합합니다.
 */
package Bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class overlaps {
    public static ArrayList<Integer> findAllSection(int[][] section) {
        ArrayList<Integer> final_section = new ArrayList<Integer>();//답이 저장되는 리스트
        int section_point = 0;//영역 point 지점을 기록
        int cur_pos = 0;
        //section[*][1]의 값을 기준으로 오름차순으로 정렬
        Arrays.sort(section, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        final_section.add(section[0][0]);//[0][0]번째의 값은 무조건 영역의 답이 된다
        for (int i = 0; i < section.length-1; ) {
            for(int j = i+1; j < section.length; j++) {
                //[i][1] < [j][1]인지 계속 탐색
                if (section[i][1] < section[j][1]) {

                    //[i][1] < [j][0]인 경우 ---> 둘 다 차례대로 포인팅
                    if(section[j][0] >= section[i][1]){
                        section_point = section[i][1];//하나의 구간이 끝나는 점
                        final_section.add(section_point);
                        section_point = section[j][0];//하나의 구간이 시작하는 점
                        final_section.add(section_point);

                    }
                    i = j;
                    break;
                }
            }
        }
        final_section.add(section[section.length-1][1]);//마지막 값도 무조건 영역의 답이 된다.
        return final_section;
    }


    public static void main(String[] args) {

        int[][] arr = {{1,9} , {2,5} , {19,20} , {10,11}};

        ArrayList<Integer> answer = findAllSection(arr);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}
