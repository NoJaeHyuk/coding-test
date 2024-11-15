package programmers.l2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_3차파일명정렬 {
    public static void main(String[] args) {
        P_3차파일명정렬 p = new P_3차파일명정렬();
        p.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<Sort_File> list = new ArrayList<>();

        for (String file : files) {
            StringBuilder head = new StringBuilder();
            StringBuilder num = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            boolean num_flag = false;

            for (int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);
                if (c >= '0' && c <= '9') {
                    num.append(c);
                    num_flag = true;
                } else {
                    if(!num_flag){
                        head.append(c);
                    }else{
                        tail.append(file.substring(i));
                        break;
                    }
                }
            }

            list.add(new Sort_File(head.toString(),num.toString(),tail.toString()));
        }

        Collections.sort(list);

        for (int i = 0; i < answer.length; i++) {
            Sort_File file = list.get(i);
            answer[i] = file.head + file.num + file.tail;
        }

        return answer;
    }

    static class Sort_File implements Comparable<Sort_File>{
        private String head;
        private String num;
        private String tail;

        public Sort_File(String head, String num, String tail) {
            this.head = head;
            this.num = num;
            this.tail = tail;
        }

        @Override
        public int compareTo(Sort_File o) {
            //head가 같은경우
            if(this.head.toLowerCase().equals(o.head.toLowerCase())){
                if(Integer.parseInt(this.num) != Integer.parseInt(o.num)){
                    //num 비교
                    return Integer.parseInt(this.num) - Integer.parseInt(o.num);
                }else{
                    (this.head + this.num + this.tail).compareTo(o.head + o.num + o.tail);
                }
            }

            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }
}
