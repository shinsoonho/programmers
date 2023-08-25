package Lv2.영어끝말잇기;

import java.util.ArrayList;
import java.util.List;

public class FollowUp {

    private static int[] solution(int n, String[] words) {

        int pNum = 0;
        int rNum = 0;

        char first;
        char last = words[0].charAt(0);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            first = words[i].charAt(0);
            if (first == last && !list.contains(words[i])) {
                list.add(words[i]);
                last = words[i].charAt(words[i].length() - 1);

            }  else {
                pNum = (i % n) + 1;
                rNum = (i + n) / n;
                break;
            }
        }
        System.out.println(list);


        return new int[]{pNum, rNum};
    }


    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n1 = 3;
        int n2 = 5;
        int n3 = 2;

        String[] words1 = {"tank", "kick", "know", "wheel",
                           "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either",
                           "recognize", "encourage", "ensure", "establish",
                           "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};


        print(solution(n1, words1));
        print(solution(n2, words2));
        print(solution(n3, words3));

    }

}
