package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {
    public static int w_cnt = 0;
    public static int b_cnt = 0;
    public static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        array = new int[N][N];

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //분할된 정사각형의 하기 위해서 한변의 사이즈가 필요하다.
        //시작점을 보내주어 사이즈와 계산하여 체크해야한다.
        //첫 호출 = 0,0,N
        mergeSort(0,0,N);

        System.out.println(w_cnt);
        System.out.println(b_cnt);

    }

    public static void mergeSort(int row, int col, int size){
        //시작점은 정사각형의 색상체크의 기준점이 된다.
        int chk_data = array[row][col];
        boolean chk = true;

        //배열체크
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                //다른게 발견되면 로직 break;
                if(chk_data != array[i][j]){
                    chk = false;
                    break;
                }
            }
        }

        if (chk) {
            if(chk_data == 0){
                w_cnt++;
            }else{
                b_cnt++;
            }
            //chk == true 면 조건에 만족하므로 종료
            return;
        }

        //4개의 사변을 각각 체크하는 로직
        //각 사변의 정사각형을 결과의 만족할때 까지 체크
        mergeSort(row,col,size/2);
        mergeSort(row,col+size/2,size/2);
        mergeSort(row+size/2,col,size/2);
        mergeSort(row+size/2,col+size/2,size/2);
    }
}
