package inflearn.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Meet> list = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Meet(s,e));
        }

        Collections.sort(list);

        solution(n,list);

    }

    public static void solution(int n, List<Meet> list){
        int cnt = 0;
        int temp = 0;

        for(Meet m : list){
            if(m.start >= temp){
                temp = m.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static class Meet implements Comparable<Meet>{
        private int start;
        private int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet o) {
            if(this.end == o.end){
                return this.start - this.end;
            }
            return this.end - o.end;
        }
    }

}
