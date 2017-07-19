import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 398 Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 */
public class RadomPick {

	private int[] nums;

	private Random rnd = new Random(System.currentTimeMillis());

	public RadomPick(int[] nums) {

		this.nums = nums;
	}

	public int pick(int target) {

		List<Integer> index = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; ++i) {

			int num = nums[i];

			if (num == target) {

				index.add(i);

			}
		}

		return index.get(rnd.nextInt(index.size()));

	}


}
