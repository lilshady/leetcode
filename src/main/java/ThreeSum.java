import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO: comment here
 */
public class ThreeSum {
	public static List<List<Integer>> threeSum(List<Integer> list, int target) {

		Collections.sort(list);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i-1).equals(list.get(i))) {
				continue;
			}

			List<List<Integer>> tempResult = new ArrayList<>();
			if (find2Sum(list, i+1, target - list.get(i), tempResult)) {
				for (List<Integer> r : tempResult) {
					r.add(list.get(i));
					result.add(r);
				}
			}
		}

		return result;
	}

	static boolean find2Sum(List<Integer> list, int from, int target, List<List<Integer>> result) {
		if (from == list.size()) {
			return false;
		}

		int start  = from;
		int end = list.size() - 1;
		while (start < end) {
			if (list.get(start) + list.get(end) < target) {
				start ++;
			} else if (list.get(start) + list.get(end) > target) {
				end --;
			} else {
				List<Integer> t= new ArrayList<>();
				t.add(list.get(start));
				t.add(list.get(end));
				result.add(t);
				start++;
				end--;
			}
		}

		if (result.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		List test = Arrays.asList(1,2,-3,4,-3,6,8,-5);
		System.out.println(threeSum(test, 0));
	}
}
