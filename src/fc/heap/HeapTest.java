package fc.heap;

public class HeapTest {
    public static void main(String[] args) {
        //int[] heapArray = new int[6];

        MaxHeap heapArray = new MaxHeap(7);

        heapArray.insert(9);
        heapArray.insert(4);
        heapArray.insert(7);
        heapArray.insert(1);
        heapArray.insert(6);
        heapArray.insert(2);
        heapArray.insert(8);

        /*      삽입
                9
             6     8
           1  4   2  7
       */

        heapArray.pop();
        /*      삽입
                8
             6     7
           1  4   2
       */


        System.out.println(heapArray);
    }
}
