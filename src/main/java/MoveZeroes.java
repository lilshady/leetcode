import java.util.Arrays;

/**
 * Created by luyuncheng on 2017/4/6.
 */
//leetcode-283
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {

        int skip = 0;

        for (int i = 0; i < nums.length; ++i) {

            if (nums[i] == 0)
                skip++;
            else {
                nums[i - skip] = nums[i];

            }
        }

        for (int j = skip; j > 0; --j) {
            nums[nums.length - j] = 0;
        }
    }

    public static void main(String[] args) {

        int[][] nums = {{1, 2, 3, 4, 5, 0}, {0, 1, 2, 3}, {0, 0, 0, 0}, {}, {1, 2, 3, 0, 4, 0}};

        for (int[] a : nums) {

            moveZeroes(a);
            System.out.println(Arrays.toString(a));
        }


    }

}
