import java.util.Arrays;

/** 324
 * Given an unsorted array nums,
 * reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 */
public class WiggleSortII {

	public void wiggleSort(int[] nums) {

		Arrays.sort(nums);

		for (int i = 0 ; i < nums.length / 2; ++i) {
			int temp = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = temp;
		}

		int half = nums.length / 2;

		int[] large = Arrays.copyOfRange(nums, 0, half);
		int[] small = Arrays.copyOfRange(nums, half, nums.length);

		for (int i = 0, j = 0, k = 0; i < nums.length; ++i) {
			if (i % 2 == 0) {
				nums[i] = small[j];
				j++;
			} else {
				nums[i] = small[k];
				k++;
			}
		}

	}

}
