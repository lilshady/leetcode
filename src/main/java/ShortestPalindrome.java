/**
 * Created by luyuncheng on 2017/4/6.
 */
/**
 * Created by luyuncheng on 2017/4/6.
 */

//214
import java.util.Collections;
import java.util.LinkedList;

public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
// dcabba
        StringBuilder result = new StringBuilder(s).reverse();

        if (isP(s, result.toString())) return s;

        String reversedString = new StringBuilder(s).reverse().toString();

        int mid = s.length() / 2;

        int index = mid; //猜测的中心点

        if (s.isEmpty())
            return s;

        while (index < s.length() - 1) {

            int prev = index;
            int next = index;

            int decision = makeDecision(reversedString, index);

            if (decision == 0) {
                prev--;
                next++;
            } else if (decision == 1) {
                next = next + 2;
                prev = index - 1;
            } else {
                prev = prev - 2;
                next = index + 1;
            }

            //如果此时已经超出了，则直接把前面的拷贝回来
            if (next == s.length()) {
                for (int i = prev; i >= 0; --i) {

                    result.append(reversedString.charAt(i));
                }

                return result.toString();
            }

            while (prev >= 0 && next < s.length() && reversedString.charAt(prev) == reversedString.charAt(next)) {

                prev--;
                next++;

                if (next == s.length()) {//可以偷巧，既这时候的index是中心点。
                    for (int i = prev; i >= 0; --i) {

                        result.append(reversedString.charAt(i));
                    }

                    return result.toString();
                }

            }

            index++;//换一个位置继续看能不能偷巧


        }
        //不能偷巧，只能把前面的直接复制过来。
        return result.append(s.substring(1, s.length())).toString();


    }

    private static boolean isP(String s, String reversed) {

        return s.equals(reversed);

    }

    //探测应该怎么走能走的步数最多。三种情况，
    //以index为中心，两边开始分别走
    //index指向的和它左边的相同，则跨过左边的邻居，再开始比
    //index指向的和它右边的相同，则跨过右边的邻居，再开始比
    private static int makeDecision(String s, int index) {


        int step1 = 0;
        int step2 = 0;
        int step3 = 0;

        int prev = index - 1;
        int next = index + 1;

        while (prev >= 0 && next < s.length() && s.charAt(prev) == s.charAt(next)) {

            step1++;
            prev--;
            next++;
        }


        if (s.charAt(index + 1) == s.charAt(index)){
            next = index + 2;
            prev = index - 1;
            step2++;
            while (prev >= 0 && next < s.length() && s.charAt(prev) == s.charAt(next)) {

                step2++;
                prev--;
                next++;
            }
        }

        if (s.charAt(index - 1) == s.charAt(index)){
            prev = index - 2;
            next = index + 1;
            step3++;
            while (prev >= 0 && next < s.length() && s.charAt(prev) == s.charAt(next)) {

                step3++;
                prev--;
                next++;
            }
        }

        if (step1 > step2 && step1 > step3) return 0;
        else if (step2 > step1 && step2 > step3) return 1;
        else if (step3 > step2 && step3 > step1) return 2;
        else return 0;
    }

    //aaacecaa
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("babbbabbaba"));

    }

}
