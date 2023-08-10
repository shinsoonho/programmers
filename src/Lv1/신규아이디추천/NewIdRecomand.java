package Lv1.신규아이디추천;

public class NewIdRecomand {

    private static String solution(String id) {

        id = id.toLowerCase();
        id = id.replaceAll("[^a-z0-9\\-_.]","");
        id = id.replaceAll("\\.{2,}",".");
        id = id.replaceAll("^[\\.]|[\\.]$","");

        id = id.length() == 0 ? "a" : id;


        if (id.length() > 15) {
            id = id.substring(0, 15);
            if (id.charAt(id.length()-1) == '.') {
                id = id.replaceAll("\\.$","");
            }
        }

        while (id.length() < 3) {
            id += id.charAt(id.length()-1);
        }


        return id;
    }

    public static void main(String[] args) {

        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";

        System.out.println(solution(new_id1));
        System.out.println(solution(new_id2));
        System.out.println(solution(new_id3));
        System.out.println(solution(new_id4));
        System.out.println(solution(new_id5));

    }

}
