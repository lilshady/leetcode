import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 将 一个array分成两个，使得两个array的差最小
 */
public class PartitionArraySmooth {

	public static List<List<Integer>> partition(List<Integer> nums) {

		int sum = 0;
		for (Integer ele : nums) {
			sum += ele;
		}

		int limit = sum / 2;

		List<Integer> onePart = choose(nums, limit);
		Set<Integer> onePartSet = new HashSet<>(onePart);

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> partTwo = new ArrayList<>();

		for (int i = 0 ; i < nums.size(); ++i) {

			if (!onePartSet.contains(i)) {
				partTwo.add(nums.get(i));
			}
		}

		result.add(onePart);
		result.add(partTwo);

		return result;
	}

	private static List<Integer> choose(List<Integer> nums, int limit) {

		List<Integer> result = new ArrayList<>();
		int size = nums.size();
		int[] solution = new int[limit + 1];
		int[][] answer = new int[size][limit + 1];

		for (int i = 0; i < limit + 1; ++i) {
			solution[i] = 0;
		}

		for (int i = 0; i < size; ++i) {
			for (int j = limit; j >= nums.get(i); --j) {
				if (solution[j] < solution[j - nums.get(i)] + nums.get(i)) {
					answer[i][j] = 1;
					solution[j] = solution[j - nums.get(i)] + nums.get(i);
				} else {
					answer[i][j] = 0;
				}
			}
		}

		findPath(nums, answer, result, size - 1, solution[limit]);
		return result;
	}

	private static void findPath(List<Integer> nums, int[][] answer, List<Integer> result, int size, int limit) {

		if (size == 0)
			return;

		if (answer[size][limit] == 0) {
			findPath(nums, answer, result, size - 1, limit);
		}

		if (answer[size][limit] == 1) {
			result.add(nums.get(size));
			findPath(nums, answer, result, size - 1, limit - nums.get(size));
		}
	}
	public static void main(String[] args) {

		List<Integer> test = Arrays.asList(1,3,5,9,7,2,11,6);

		List<List<Integer>> result = partition(test);
	}
}
