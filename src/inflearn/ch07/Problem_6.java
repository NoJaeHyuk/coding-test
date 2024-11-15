package inflearn.ch07;

public class Problem_6 {
    static int n;
    static int[] ch;
    public static void main(String[] args) {
        n = 3;
        ch = new int[n+1]; // 인덱스 1부터 시작이므로
        DFS(1);
    }

    public static void DFS(int L){
        if(L == n+1){
            for(int i = 1; i <= n; i++){
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.print("\n");
            return;
        }
        ch[L] = 1;
        DFS(L+1); //사용한다.
        ch[L] = 0;
        DFS(L+1); //사용하지 않는다.
    }
}
