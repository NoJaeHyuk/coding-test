package inflearn.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(n,m,array);
    }

    public static void solution(int n, int m, int[] array){
        Queue<Node> queue = new LinkedList<>();
        int count = 0;

        //초기값을 큐에 삽입
        for(int i = 0; i < n; i++){
            queue.add(new Node(i,array[i]));
        }

        //큐가 빌때까지 실행
        while (!queue.isEmpty()){
            Node node = queue.poll();

            //남은 큐중에 본인보다 큰게 있는지 확인
            for(Node n1 : queue){
                if (n1.getData() > node.getData()) {
                    queue.add(node);
                    node = null; // 이 과정이 필수로 들어가야한다.
                    break;
                }
            }

            //큰 수가 없으면 진행
            if(node != null){
                count++;
                if(node.idx == m){
                    System.out.println(count);
                    return;
                }
            }
        }

    }

    static class Node{
        private int idx;
        private int data;

        public Node(int idx, int data) {
            this.idx = idx;
            this.data = data;
        }

        public int getIdx() {
            return idx;
        }

        public int getData() {
            return data;
        }
    }
}
