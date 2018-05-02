import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lil_shady on 2018/5/2.
 */
/*
给定一个有n个对象（包括k种不同的颜色，并按照1到k进行编号）的数组，将对象进行分类使相同颜色的对象相邻，并按照1,2，...k的顺序进行排序。
 */
public class SortColors2 {

    public static void sortColors2(int[] colors, int k) {
        // write your code here
        Map<Integer, Integer> colorMap = new HashMap<>();

        for (Integer color : colors) {
            int count = colorMap.getOrDefault(color, 0);
            colorMap.put(color, count + 1);
        }

        int start = 0;
        for (int i = 1; i <= k; ++i) {
            int count = colorMap.getOrDefault(i, 0);
            if (count == 0){
                continue;
            }
            Arrays.fill(colors, start, start + count , i);
            start = start + count;
        }
    }

    public static void main(String[] args) {
        int[] colors = {1,1,3,3,3,3,3,3,3,3};
        sortColors2(colors, 3);
        System.out.print(Arrays.asList(colors));
    }
}
