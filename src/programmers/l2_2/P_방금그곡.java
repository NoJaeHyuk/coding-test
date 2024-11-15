package programmers.l2_2;



public class P_방금그곡 {

    public static void main(String[] args){
        P_방금그곡 p = new P_방금그곡();

        p.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"});
    }

    static String[] sharpBefore = {"A#", "C#", "D#", "F#", "G#"};
    static String[] sharpAfter = {"a", "c", "d", "f", "g"};

    public String solution(String m, String[] musicinfos){
        String answer = "(None)";
        int max = Integer.MIN_VALUE;

        m = removeSharp(m);

        for(int i = 0; i < musicinfos.length; i ++){
            String[] strings = musicinfos[i].split(",");
            int time = getTime(strings[0], strings[1]);
            //ABC -> ABC#은 다르다.
            //#을 변환해줘야한다.
            //주어진 #은 C#,D#,F#,G#,A#이다.
            String music = removeSharp(strings[3]);

            // 재생시간만큼 music 반복
            while (music.length() < time) {
                music += music;
            }

            music = music.substring(0,time);

            if(music.contains(m)){
                if(max < time){
                    max = time;
                    answer = strings[2];
                }
            }
        }

        System.out.println(answer);

        return answer;
    }

    // # 대체
    private String removeSharp(String strings) {
        String music = strings;

        for(int j = 0; j < sharpBefore.length; j++){
            music = music.replaceAll(sharpBefore[j],sharpAfter[j]);
        }

        return music;
    }

    /* 재생시간 구하기 */
    private int getTime(String str1, String str2){
        String[] time1 = str1.split(":");
        String[] time2 = str2.split(":");

        int h1 = Integer.parseInt(time1[0])*60; // 분으로 변환
        int h2 = Integer.parseInt(time2[0])*60; // 분으로 변환

        int m1 = Integer.parseInt(time1[1]);
        int m2 = Integer.parseInt(time2[1]);

        // 큰 분에서 작은 분을 빼 두 사이 분차이 구한다.
        return (h2+m2)-(h1+m1);
    }



}
