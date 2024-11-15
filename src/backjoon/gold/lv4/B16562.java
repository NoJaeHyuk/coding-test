package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16562 {
    static int[] parent;
    static int[] moneyArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        //대표노드저장 배열을 자기 자신으로 초기화한다.
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        moneyArray = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            moneyArray[i] = Integer.parseInt(st.nextToken());
        }

        //질의를 받는 부분
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //union 처리
            union(a, b);
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) {
                sum += moneyArray[i];
            }
        }

        if(K-sum < 0){
            System.out.println("Oh no");
        }else{
            System.out.println(sum);
        }

    }

    private static void union(int a, int b) {
        //대표노드를 찾아 연결하기
        int idx1 = find(a);
        int idx2 = find(b);

        if (idx1 != idx2) {
            if (moneyArray[idx1] > moneyArray[idx2]) {
                parent[idx1] = idx2; // 작은값이 대표값
            } else {
                parent[idx2] = idx1;
            }
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            //대표노드가 아니면 지정된 노드로 찾아감
            return parent[a] = find(parent[a]); //빠져나오면 대표노드로 값을 갱신
        }
    }
}
