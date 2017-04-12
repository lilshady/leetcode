import java.util.Queue;
import java.util.Stack;

/**
 * Created by luyuncheng on 2017/4/12.
 */
//394
//    s = "3[a]2[bc]", return "aaabcbc".
//            s = "3[a2[c]]", return "accaccacc".
//            s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
public class DecodeString {

    public static String decodeString(String s) {


        Stack<Integer> operators = new Stack<Integer>();
        Stack<String> result = new Stack<String>();

        result.push("");

        for (int j = 0; j < s.length(); j++) {

            Character c = s.charAt(j);

            if (Character.isDigit(c)) {

                int start = j;
                while (Character.isDigit(s.charAt(j + 1))) j++;
                operators.push(Integer.parseInt(s.substring(start, j + 1)));

            } else if (c.equals(']')) {

                String temp = result.pop();
                int times = operators.pop();

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < times; i++)
                    sb.append(temp);

                result.push(result.pop() + sb.toString());

            } else if (c.equals('[')) {
                result.push("");
            } else {
                result.push(result.pop() + c.toString());
            }


        }

        return result.pop();

    }

    public static void main(String[] args) {

        //String[] test = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "ef"};

        String[] test = {"3[a2[c]]"};

        for (String t : test) {

            System.out.println(decodeString(t));

        }

    }
}
