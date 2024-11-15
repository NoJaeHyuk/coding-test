package inflearn.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Meet> list = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            list.add(new Meet(s, 's'));
            int e = Integer.parseInt(st.nextToken());
            list.add(new Meet(e, 'e'));
        }

        Collections.sort(list);

        solution(n, list);
    }

    public static void solution(int n, List<Meet> list){
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for(Meet meet : list){
            if(meet.status == 's'){
                cnt++;
            }else {
                cnt--;
            }
            max = Math.max(max,cnt);
        }

        System.out.println(max);
    }

    static class Meet implements Comparable<Meet>{
        private int time;
        private char status;

        public Meet(int time, char status) {
            this.time = time;
            this.status = status;
        }

        @Override
        public int compareTo(Meet o) {
            if(this.time == o.time){
                return this.status - o.status;
            }
            return this.time - o.time;
        }
    }

}
