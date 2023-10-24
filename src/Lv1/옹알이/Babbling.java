package Lv1.옹알이;

public class Babbling {

    private static int solution(String[] babbling) {

        int answer = 0;

        String[] babble = {"aya", "ye", "woo", "ma"," "};
        String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"};

        for (int i = 0; i < babbling.length; i++) {
            if (!babbling[i].contains(repeat[0]) &&
                    !babbling[i].contains(repeat[1]) &&
                    !babbling[i].contains(repeat[2]) &&
                    !babbling[i].contains(repeat[3])) {

                babbling[i] = babbling[i].replace(babble[0], " ");
                babbling[i] = babbling[i].replace(babble[1], " ");
                babbling[i] = babbling[i].replace(babble[2], " ");
                babbling[i] = babbling[i].replace(babble[3], " ");
                babbling[i] = babbling[i].replace(babble[4], "");

                if (babbling[i].length() == 0) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] babbling1 = {"aya", "yee", "u", "maa"};
        String[] babbling2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println(solution(babbling1));
        System.out.println(solution(babbling2));

    }

}
