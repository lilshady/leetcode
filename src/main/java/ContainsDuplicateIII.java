import java.util.TreeSet;

/**
 * 220
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateIII {

	public static  boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		if (nums == null || nums.length <= 0 || k <= 0 ) {
			return false;
		}

		TreeSet<Long> comparedWindow = new TreeSet<Long>();

		for (int index = 0 ; index < nums.length; index++) {

			long upper = (long)nums[index] + t;
			long lower = (long)nums[index] - t;

			Long foundLower = comparedWindow.floor(upper);

			Long foundUpper = comparedWindow.ceiling(lower);

			if ((foundLower != null && foundLower >= nums[index])
					|| (foundUpper != null && foundUpper <= nums[index])){
				return true;
			}

			comparedWindow.add((long)nums[index]);
			if (index >= k) {
				comparedWindow.remove((long)nums[index - k]);
			}
		}

		return false;

	}

	public static void main(String[] args) {

      int[] test = {-2147483648,-2147483647};

      System.out.println(containsNearbyAlmostDuplicate(test,3,3));

	}


}
