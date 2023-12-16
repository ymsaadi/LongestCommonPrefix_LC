import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"caba", "baca", "cano", "bbbb"}));
    }

//    caba
//    baca
//    cano

    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        Set<String> possibleCommonsSet = new HashSet<>();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int k = strs[0].length() - 1; k >= i; k--) {
                possibleCommonsSet.add(strs[0].substring(i, k + 1));
            }
        }
//        System.out.println(possibleCommonsSet);
        List<String> possibleCommons = new ArrayList<>(possibleCommonsSet);

        for (int i = 1; i < strs.length; i++) {
            Set<String> word = new HashSet<>();
//            if (Objects.equals(res, "")) { // this should be changed to if possiblecommons is empty
//                return "";
//            }
            for (int j = 0; j < strs[i].length(); j++) {
                for (int k = strs[i].length() - 1; k >= j; k--) {
                    word.add(strs[i].substring(j, k + 1));
                }
            }
            System.out.println(possibleCommons);

            List<String> wordArray = new ArrayList<>(word);
            for (int j = 0; j < possibleCommons.size(); j++) {
                System.out.println(j);//here compare the two arrays
                if (!wordArray.contains(possibleCommons.get(j))) {
                    possibleCommons.remove(j);
                }
            }
        }

        List<String> possibleCommons2 = new ArrayList<>(possibleCommons);
        for (int i = 0; i < possibleCommons2.size(); i++) {
            if (res.length() < possibleCommons.get(i).length()) {
                res = possibleCommons.get(i); // it removes it, j becomes greater than size of list
            }
        }
        System.out.println(possibleCommons2);

        return res;
    }
}
