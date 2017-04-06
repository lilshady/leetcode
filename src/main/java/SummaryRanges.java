import java.util.*;

/**
 * Created by luyuncheng on 2017/4/6.
 */
//228

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {

        if (nums.length == 0)
            return new ArrayList<String>();

        Map<Integer, Integer> result = new TreeMap<Integer, Integer>();

        int startNum = nums[0];
        int endNum = nums[0];

        result.put(startNum, endNum);

        for (int i = 1; i < nums.length; ++i) {

            if (nums[i - 1] + 1 == nums[i]) {

                endNum = nums[i];

            } else {

                result.put(startNum, endNum);

                startNum = nums[i];
                endNum = nums[i];

            }

        }
        result.put(startNum, endNum);

        List<String> resultList = new ArrayList<String>();

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {

            if (entry.getValue().equals(entry.getKey()))
                resultList.add(entry.getKey().toString());
            else {

                resultList.add(entry.getKey() + "->" + entry.getValue());

            }

        }

        return resultList;

    }

    public static void main(String[] args) {

        int[][] nums = {{0, 1, 2, 4, 5, 7}, {1, 2, 3}, {1, 1, 1}, {1, 3, 5, 7, 9}, {1, 2, 3, 4, 5, 6}, {-1}};

        for (int[] a : nums) {
            System.out.println(summaryRanges(a));
        }

    }
}
