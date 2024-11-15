package inflearn.ch07;

public class Problem_5 {
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

        DFS(root);
    }


    public static void DFS(Node root){
        //말단노트까지 왔다는 의미
        if(root == null){
            return;
        }
        //System.out.print(root.data + " ");
        DFS(root.lt);
        //System.out.print(root.data + " ");
        DFS(root.rt);
        //System.out.print(root.data + " ");
    }
}
