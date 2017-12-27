/**
 * 45. 最大子数组差
 *思路：先从左到右找到以每个数结尾的最大值，再从右向左找到每个数结尾的最大值。
 *     再从左到右找到每个数结尾的最小值，再从右向左找到每个数结尾的最小值。
 *     则从左到右遍历，以i结尾的左边的最大数 减去 以i+1结尾的右边的最小数，或者是以i结尾的右边
 *     的最大数减去以i结尾的左边的最小数。
 */
public class MaxDiffSubArrays {

	/*
	* @param nums: A list of integers
	* @return: An integer indicate the value of maximum difference between two substrings
	*/
	public static int maxDiffSubArrays(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return 0;
		}

		int[] maxLeft = new int[nums.length];
		maxLeft[0] = nums[0];
		int sum = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			maxLeft[i] = sum;
		}

		int[] maxRight = new int[nums.length];
		maxRight[nums.length - 1] = nums[nums.length - 1];
		sum = nums[nums.length - 1];

		for (int i = nums.length - 2; i >= 0; i--) {

			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			maxRight[i] = sum;
		}


		int[] minLeft = new int[nums.length];
		minLeft[0] = nums[0];
		int min = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (min < 0) {
				min += nums[i];
			} else {
				min = nums[i];
			}
			minLeft[i] = min;
		}

		int[] minRight = new int[nums.length];
		minRight[nums.length - 1] = nums[nums.length - 1];
		min = nums[nums.length - 1];

		for (int i = nums.length - 2; i >= 0; i--) {

			if (min > 0) {
				min = nums[i];
			} else {
				min += nums[i];
			}
			minRight[i] = min;
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length - 1; i++) {

			int result = Math.abs(maxLeft[i] - minRight[i+1]);

			int result2 = Math.abs(maxRight[i + 1] - minLeft[i]);

			if (Math.max(result, result2) > max) {
				max = Math.max(result,result2);
			}
		}

		return max;
	}


	public static void main(String[] args) {

		int[] test = new int[]{1,2,-3,1};

		System.out.println(maxDiffSubArrays(test));

	}
}
