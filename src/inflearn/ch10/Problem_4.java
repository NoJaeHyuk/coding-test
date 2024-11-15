package inflearn.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_4 {
    static public class Main {
        static int[] dp;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            List<Node> list = new ArrayList<>();

            StringTokenizer st;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                list.add(new Node(s,h,w));
            }

            Collections.sort(list);

            System.out.println(solution(n,list));

        }

        static int solution(int n, List<Node> list){
            int answer = 0;

            dp = new int[n];
            dp[0] = list.get(0).h;

            for(int i = 1; i < n; i++){
                int max = 0;
                for(int j = i-1; j >= 0; j--){
                    if(list.get(j).w > list.get(i).w  && dp[j] > max){
                        max = dp[j];
                    }
                }
                dp[i] = max + list.get(i).h;
                answer = Math.max(answer, dp[i]);
            }

            return answer;
        }

        static class Node implements Comparable<Node>{
            private int s;
            private int h;
            private int w;

            Node(int s, int h, int w){
                this.s = s;
                this.h = h;
                this.w = w;
            }

            @Override
            public int compareTo(Node o) {
                return o.s - this.s;
            }
        }
    }
}
