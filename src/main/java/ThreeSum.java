import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	/*
	 * @param numbers: Give an array numbers of n integer
	 * @return: Find all unique triplets in the array which gives the sum of zero.
	 */
	public static List<List<Integer>> threeSum(int[] numbers) {
		Arrays.sort(numbers);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			if (i > 0 && numbers[i-1] ==numbers[i]) {
				continue;
			}

			List<List<Integer>> tempResult = new ArrayList<>();
			if (find2Sum(numbers, i+1, - numbers[i], tempResult)) {
				for (List<Integer> r : tempResult) {
					r.add(0, numbers[i]);
					result.add(r);
				}
			}
		}

		return result;
	}

	static boolean find2Sum(int[] list, int from, int target, List<List<Integer>> result) {
		if (from == list.length) {
			return false;
		}

		int start  = from;
		int end = list.length - 1;
		while (start < end) {
			if (list[start] + list[end] < target) {
				start ++;
			} else if (list[start] + list[end] > target) {
				end --;
			} else {
				List<Integer> t= new LinkedList<>();
				t.add(list[start]);
				t.add(list[end]);
				result.add(t);
				start ++;
				while (start + 1 < list.length && list[start] == list[start-1]) {
					start++;
				}
				end --;
				while (end -1 > 0 && list[end] == list[end+1]) {
					end--;
				}
			}
		}

		if (result.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[] test = {1,0,-1,-1,-1,-1,0,1,1,1};
		System.out.println(threeSum(test));
	}
}