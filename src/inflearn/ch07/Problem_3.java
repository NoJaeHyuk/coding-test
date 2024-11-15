package inflearn.ch07;

public class Problem_3 {
    public static void main(String[] args) {
        System.out.println(DFS(5));
    }

    public static int DFS(int n){
        if(n == 1){
            return 1;
        }
        return n*DFS(n-1);

    }
}
