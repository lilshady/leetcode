/**
 * 209 Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {

		int left = 0;
		int right = 0;
		int tempResult = nums.length + 1;
		int sum = 0;

		while (right < nums.length) {

			while (sum < s && right < nums.length) {
				sum += nums[right];
				right++;
			}

			while (sum >= s) {

				int diff = right - left;
				tempResult = Math.min(diff,tempResult);
				sum -= nums[left];
				left++;
			}

		}

		return tempResult == nums.length + 1 ? 0 : tempResult;
	}

}
