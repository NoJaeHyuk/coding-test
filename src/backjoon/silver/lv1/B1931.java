package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] timeList = new int[N][2];

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            timeList[i][0] = Integer.parseInt(st.nextToken()); // 시작
            timeList[i][1] = Integer.parseInt(st.nextToken()); // 종료
        }

        //그리디 알고리즘이 최적해가 항상 나오지 않는다고 하니
        //그리디 알고리즘을 써도 최적해가 나오는 상황을 만들어주기 위해 정렬을 먼저 진행한다.
        //선택할 수 있는 시간이 많아지려면 서로 겹치지 않는 시간에 종료시간이 빠르면 된다.

        //종료시간에 대한 정렬을 먼저 진행한다.
        //만약 같은 종료시간이면 시간시간이 빠른게 앞으로 온다.
        //java8 이상 이차원배열 정렬 방식 (람다)
        Arrays.sort(timeList, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }

            return o1[1]-o2[1];
        });

        int endTime = 0;
        int count = 0;

        for(int i=0; i<N; i++){
            if(endTime <= timeList[i][0]){
                endTime = timeList[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
