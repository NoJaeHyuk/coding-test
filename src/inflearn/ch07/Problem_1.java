package inflearn.ch07;

/*
재귀함수
 */
public class Problem_1 {
    public static void main(String[] args) {
        DFS(3);
    }

    public static void DFS(int n){
        if(n == 0){
            return;
        }
        DFS(n-1);
        System.out.print(n + " ");
    }
}
