package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nA = new int[n];
        for(int i=0; i<n; i++){
             nA[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nA);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++){
            int target = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = nA.length-1;
            boolean result = false;
            while (left <= right){
                int mid = (left+right)/2;

                if(target > nA[mid]){
                    left = mid+1;
                }else if(target < nA[mid]) {
                    right = mid-1;
                }else{
                    result = true;
                    break;
                }
            }

            if(result){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
