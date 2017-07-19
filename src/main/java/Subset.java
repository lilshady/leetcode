import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. Subsets Given a set of distinct integers, nums, return all possible subsets.
 */
public class Subset {

	public List<List<Integer>> subsets(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<List<Integer>>();


		for (int i = 0; i < nums.length; i++) {

			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

			for (List<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}

			for (ArrayList<Integer> a : temp) {
				a.add(nums[i]);
			}

			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(nums[i]);

			temp.add(single);

			result.addAll(temp);
		}

		result.add(new ArrayList<Integer>());

		return result;

	}
}
