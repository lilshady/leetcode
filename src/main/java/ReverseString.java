/**
 * Created by luyuncheng on 2017/4/6.
 */
//344
public class ReverseString {
    public static String reverseString(String s) {

        int start = 0;
        int end = s.length() - 1;

        char[] array = s.toCharArray();

        while (start < end) {

            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;

            start++;
            end--;
        }


        return new String(array);

    }

    public static void main(String[] args) {

        System.out.println("123");
        System.out.println(reverseString("abcd"));
    }
}
