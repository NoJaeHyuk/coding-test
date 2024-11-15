package inflearn.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_4 {

    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            max = Math.max(max,day);

            list.add(new Node(money, day));
        }

        Collections.sort(list);

        solution(n, list);
    }

    public static void solution(int n, List<Node> list){
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        int sum = 0;
        int j = 0;
        for(int i = max; i >= 1; i--){
            for( ; j < n; j++){
                if(list.get(j).day >= i){
                    queue.add(list.get(j).money);
                }else{
                    break;
                }
            }
            if(!queue.isEmpty()) sum += queue.poll();
        }

        System.out.println(sum);
    }

    static class Node implements Comparable<Node>{
        private int money;
        private int day;

        public Node(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Node o) {
            return o.day - this.day;
        }
    }

}
