/**
 * Created by luyuncheng on 2017/4/7.
 */
//494
public class TargetSum {

    public static int findTargetSumWays(int[] nums, int S) {

        return findTargetSumWaysByIndex(nums,S,0,nums.length - 1);
    }

    public static int findTargetSumWaysByIndex(int[] nums, int S,int start,int end){

        if (nums == null || nums.length == 0 || start > end) return 0;

        if (start == end && Math.abs(S) == 0 && nums[start] == 0) return 2;
        if (start == end && Math.abs(S) == nums[start]) return 1;

        return findTargetSumWaysByIndex(nums,S - nums[start],start + 1, end) +
                findTargetSumWaysByIndex(nums,S+nums[start],start+1,end);

    }

    public static void main(String[] args){


        int [] t = {1,1,1,1,1};
        int [] t2 = {0,0};

        System.out.println(findTargetSumWays(t2,0));

    }

}
