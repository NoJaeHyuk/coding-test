package inflearn.ch07;

public class Problem_9 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(5);
        root.lt.rt = new Node(6);

        //레벨과 node
        DFS(0, root);

        System.out.println(answer);
    }

    public static void DFS(int L, Node root){
        //말단노드의 조건
        if(root.lt == null && root.rt == null){
            answer = Math.min(L,answer);
        }else{
            if(root.lt != null) DFS(L+1,root.lt);
            if(root.rt != null) DFS(L+1,root.rt);
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
