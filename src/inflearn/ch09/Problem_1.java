package inflearn.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Body> list = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Body(height, weight));
        }

        Collections.sort(list);

        solution(n, list);
    }

    public static void solution(int n, List<Body> list) {
        /*int cnt = 1;

        for(int i = 1; i < n; i++){
            cnt++;
            for(int j = 0; j < i; j++){
                Body cur = list.get(i);
                Body com = list.get(j);

                if(cur.weight < com.weight){
                    cnt--;
                    break;
                }
            }
        }*/

        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for(Body o : list){
            if(o.weight > max){
                max = o.weight;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static class Body implements Comparable<Body> {

        private int height;
        private int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) {
            return o.height-this.height;
        }
    }

}
