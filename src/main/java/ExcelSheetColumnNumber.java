import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyuncheng on 2017/4/17.
 */
//171
public class ExcelSheetColumnNumber {

    public static Map<Character,Integer> mappings = new HashMap<Character, Integer>();


    public static int titleToNumber(String s) {

        int result = 0;

        for (int i = 0 ; i < s.length(); ++i){


            result += s.charAt(i) - 'A' + 1;

            if (i < s.length() - 1) {

                result *= 26;
            }


        }

        return result;

    }
}
