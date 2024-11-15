package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B9934 {
    static int[] array;
    static List<ArrayList<Integer>> resultList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //2^k-1
        array = new int[(int)(Math.pow(2,n)-1)];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<array.length; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resultList.add(new ArrayList<>());
        }

        inOrderTree(0, 0, array.length-1);

        StringBuilder builder = new StringBuilder();

        /*
        StringBuilder 를 통해 값 호출
         */
        for(ArrayList list : resultList){
            for(int j=0; j<list.size(); j++){
                builder.append(list.get(j)+" ");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());

    }

    /**
     * 높이별 항목 구하기
     * @param n           높이 ( 여기선 최상단 높이를 0 )
     * @param startIdx    시작인덱스
     * @param endIdx      끝인덱스
     */
    public static void inOrderTree(int n, int startIdx, int endIdx){
        if(startIdx == endIdx){
            resultList.get(n).add(array[startIdx]);
            return;
        }

        //중위탐색을 직접해보면 중간값이 루트값이라는 결과를 알 수 있다.
        int idx = (startIdx+endIdx)/2;
        resultList.get(n).add(array[idx]);

        //왼쪽노드 탐색
        //시작인덱스부터 루트이전인덱스까지
        inOrderTree(n+1, startIdx, idx-1);

        //오른쪽노드 탐색
        //루트이후인덱스부터 끝인덱스까지
        inOrderTree(n+1, idx+1, endIdx);

    }

}
