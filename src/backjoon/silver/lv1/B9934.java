package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B9934 {
    static List<ArrayList<Integer>> resultList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] inorder = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();

        resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resultList.add(new ArrayList<>());
        }

        //inOrderTree(0, 0, inorder.length - 1);

        StringBuilder builder = new StringBuilder();

        /*
        StringBuilder 를 통해 값 호출
         */
        for (ArrayList list : resultList) {
            for (int j = 0; j < list.size(); j++) {
                builder.append(list.get(j) + " ");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());

    }

    /*public static void inOrderTree(int n, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            resultList.get(n).add(array[startIdx]);
            return;
        }

        //중위탐색을 직접해보면 중간값이 루트값이라는 결과를 알 수 있다.
        int idx = (startIdx + endIdx) / 2;
        resultList.get(n).add(array[idx]);

        //왼쪽노드 탐색
        //시작인덱스부터 루트이전인덱스까지
        inOrderTree(n + 1, startIdx, idx - 1);

        //오른쪽노드 탐색
        //루트이후인덱스부터 끝인덱스까지
        inOrderTree(n + 1, idx + 1, endIdx);

    }*/

}
