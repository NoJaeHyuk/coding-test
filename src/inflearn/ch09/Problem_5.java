package inflearn.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_5 {
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node>[] nodes = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[s].add(new Node(e, w));
        }

        solution(n, m, nodes);

        for (int i = 2; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dist[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }

    public static void solution(int n, int m, List<Node>[] nodes) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(1, 0));
        dist[1] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int c_index = cur.index;
            int c_cost = cur.cost;

            if (c_cost > dist[c_index]) {
                continue;
            }

            for (Node node : nodes[c_index]) {
                if (dist[node.index] > c_cost + node.cost) {
                    dist[node.index] = c_cost + node.cost;
                    queue.add(new Node(node.index, c_cost + node.cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        private int index;
        private int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
