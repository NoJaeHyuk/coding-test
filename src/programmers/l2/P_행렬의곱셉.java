package programmers.l2;

public class P_행렬의곱셉 {
    public static void main(String[] args) {
        P_행렬의곱셉 p = new P_행렬의곱셉();
        p.solution(new int[][]{{1,4},{3,2},{4,1}}, new int[][]{{3,3},{3,3}});
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for(int i = 0; i < arr1.length; i++){
            int sum = 0;
            for(int j = 0; j < arr1[0].length; j++){
                for(int k = j; k < arr2.length; k++){
                    sum += arr1[i][j] * arr2[k][j];
                    break;
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
