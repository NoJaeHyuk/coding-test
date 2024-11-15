package programmers.l2;

import java.util.HashSet;

public class P_후보키 {
    public static void main(String[] args) {
        P_후보키 p = new P_후보키();
        p.solution(new String[][]{
                {"100","ryan","music","2"},{"200","apeach","math","2"},
                {"300","tube","computer","3"},{"400","con","computer","4"},
                {"500","muzi","music","3"},{"600","apeach","music","2"}
        });
    }

    static HashSet<String> set;

    public int solution(String[][] relation) {
        set = new HashSet<>();

        for(int i = 0; i < relation.length; i++){
            for(int j = 0; j < relation[0].length; j++){
                if(relation[i][j] == relation[i][j+1]){

                }
            }
        }

        return set.size();
    }
}
