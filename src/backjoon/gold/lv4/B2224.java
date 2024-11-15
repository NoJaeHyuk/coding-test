package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
이론 공부 후 다시 풀어보자.
플로이드 워셜
 */
public class B2224 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[52][52];

        //알파벳 26*2
        for(int i = 0; i < N; i++){
            String cur = br.readLine();
            //0,5 번 위치 알파벳
            arr[atoi(cur.charAt(0))][atoi(cur.charAt(5))] = true;
        }

        //플로이드 워셜 3중 for 문 사용한다.
        for (int k = 0; k < 52; k++) {
            for (int i = 0; i < 52; i++) {
                for (int j = 0; j < 52; j++) {
                    if (i==j || i==k || k==j || arr[i][j]) continue;
                    if (arr[i][k] && arr[k][j]) arr[i][j] = true;
                }
            }
        }


        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if (i == j || !arr[i][j]) continue;
                cnt++;
                sb.append(itoa(i)).append(" => ").append(itoa(j)).append('\n');
            }
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    //문자를 정수로 변환
    private static int atoi(char c) {
        if (c>='a') return c-'a'+26;
        return c-'A';
    }

    //정수를 문자로 변환
    private static char itoa(int idx) {
        if (idx<26) return (char)('A'+idx);
        return (char)('a'+(idx-26));
    }

}
