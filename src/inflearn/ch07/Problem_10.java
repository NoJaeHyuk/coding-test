package inflearn.ch07;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_10 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(5);
        root.lt.rt = new Node(6);

        BFS(root);
    }

    public static void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int L = 0;
        while (!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                Node cur = q.poll();
                if(cur.lt == null && cur.rt == null){
                    System.out.println(L);
                    return;
                }
                if(cur.lt != null){
                    q.offer(cur.lt);
                }
                if(cur.rt != null){
                    q.offer(cur.rt);
                }
            }
            L++;
        }

    }

    static class Node {
        int data;
        Node lt, rt;
        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }
    }
}
