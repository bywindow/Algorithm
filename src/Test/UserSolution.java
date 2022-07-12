package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserSolution {
    private Map<Integer, Integer> idToGrade;
    private Map<Integer, char[]> idToGender;
    private Map<Integer, Integer> idToScore;
    public void init() {
        idToGrade = new HashMap<>();
        idToGender = new HashMap<>();
        idToScore = new HashMap<>();
        return;
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        int resScore = mScore;
        int resId = mId;
        if(idToGrade.containsValue(mGrade)){
            for(Map.Entry<Integer, Integer> entry : idToGrade.entrySet()) {
                if(Objects.equals(entry.getValue(), mGrade)){
                    int curId = entry.getKey();
                    //성별 확인
                    if(idToGender.get(curId)[0] != mGender[0]) continue;
                    //점수 비교
                    if(resScore < idToScore.get(curId)) {
                        resId = curId;
                        resScore = idToScore.get(curId);
                    }
                    else if(resScore == idToScore.get(curId)) resId = Math.max(resId, curId);
                }
            }
        }
        idToGrade.put(mId, mGrade);
        idToGender.put(mId, mGender);
        idToScore.put(mId, mScore);
        return resId;
    }

    public int remove(int mId) {
        //backup
        int resId = 0;
        if(idToScore.containsKey(mId)) {
            int grade = idToGrade.get(mId);
            char gender = idToGender.get(mId)[0];
            int score = Integer.MAX_VALUE;
            //remove
            idToGrade.remove(mId);
            idToGender.remove(mId);
            idToScore.remove(mId);
            if (idToGrade.containsValue(grade)) {
                for (Map.Entry<Integer, Integer> entry : idToGrade.entrySet()) {
                    if (entry.getValue() == grade) {
                        int curId = entry.getKey();
                        if (idToGender.get(curId)[0] != gender) continue;
                        if (score > idToScore.get(curId)) {
                            resId = curId;
                            score = idToScore.get(curId);
                        } else if (score == idToScore.get(curId)) resId = Math.min(resId, curId);
                    }
                }
            }
        }
        return resId;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        int resId = Integer.MAX_VALUE;
        int score = Integer.MAX_VALUE;
        for(int i = 0; i < mGradeCnt; i++){
            if(idToGrade.containsValue(mGrade[i])){
                for(Map.Entry<Integer, Integer> entry : idToGrade.entrySet()){
                    if(entry.getValue() == mGrade[i]){
                        int curId = entry.getKey();
                        for(int j = 0; j < mGenderCnt; j++){
                            if(idToGender.get(curId)[0] != mGender[j][0]) continue;
                            if(mScore <= idToScore.get(curId) && idToScore.get(curId) < score){
                                resId = curId;
                                score = idToScore.get(curId);
                            }
                            else if(score == idToScore.get(curId)) resId = Math.min(resId, curId);
                        }
                    }
                }
            }
        }
        return resId == Integer.MAX_VALUE ? 0 : resId;
    }
}
