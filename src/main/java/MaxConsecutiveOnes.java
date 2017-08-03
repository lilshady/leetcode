/**
 * Created by lil_shady on 2017/8/3.
 */
//485 Given a binary array, find the maximum number of consecutive 1s in this array.
public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int sum = 0;
        int max = 0;

        for (int i : nums) {

            if (i == 0) {
                sum = 0;
            }

            else {

                sum++;

                if (sum > max) {
                    max = sum;
                }
            }

        }

        return max;

    }


    public static void main(String[] args) {

        int[] test = {1,0,1,1,0,1};

        System.out.println(findMaxConsecutiveOnes(test));

    }
}
