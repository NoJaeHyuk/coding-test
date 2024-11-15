package inflearn.ch07;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_7 {
    static Node root;
    static class Node{
        int data;
        Node lt,rt;
        public Node(int val){
            data = val;
            lt=rt=null;
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt=new Node(5);
        root.rt.lt=new Node(6);
        root.rt.rt=new Node(7);

        BFS(root);
    }


    public static void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int L = 0; // 레벨

        while (!q.isEmpty()){
            int len = q.size();

            System.out.print(L + ":");
            //큐의 현 사이즈 만큼 반복
            for(int i = 0; i < len; i++){
                Node cur = q.poll();
                if (cur.lt != null) {
                    q.offer(cur.lt);
                }

                if(cur.rt != null){
                    q.offer(cur.rt);
                }
                System.out.print(cur.data);
                L++;
            }
            System.out.print("\n");
        }
    }
}
