import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lil_shady on 2018/5/9.
 * 646 给出一个字符串。找到字符串中第一个不重复的字符然后返回它的下标。如果不存在这样的字符，返回 -1。
 */
public class FirstUniqChar {

    /**
     * @param s: a string
     * @return: it's index
     */
    public static int firstUniqChar(String s) {

        if (s == null || s.length() == 0)
            return -1;

        Set<Character> charSet = new HashSet<>();
        Map<Character, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (!charSet.contains(ch)){
                charSet.add(ch);
                indexMap.put(ch, i);
            } else {
                indexMap.remove(ch);
            }
        }

        if (indexMap.isEmpty()) {
            return  -1;
        } else {
            int min = s.length() -1;
            for (Map.Entry<Character,Integer> entry : indexMap.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                }
            }
            return min;
        }
        // write your code here
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("lintcode"));
    }

}
