import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 491
 * Given an integer array,
 * your task is to find all the different possible increasing subsequences of the given array,
 * and the length of an increasing subsequence should be at least 2 .
 */
public class IncreasingSubsequences {
	public static List<List<Integer>> findSubsequences(int[] nums) {

		//Arrays.sort(nums);

		List<List<Integer>> result =   findSubsequencesHelper(nums, 0, nums.length).stream()
				.filter(l -> l.size() >=2).collect(Collectors.toList());

		return result;
	}

	public List<List<Integer>> findSubsequences2(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		helper(new LinkedList<Integer>(), 0, nums, res);
		return res;
	}
	private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
		if(list.size()>1) res.add(new LinkedList<Integer>(list));
		Set<Integer> used = new HashSet<>();
		for(int i = index; i<nums.length; i++){
			if(used.contains(nums[i])) continue;
			if(list.size()==0 || nums[i]>=list.peekLast()){
				used.add(nums[i]);
				list.add(nums[i]);
				helper(list, i+1, nums, res);
				list.remove(list.size()-1);
			}
		}
	}

	private static List<List<Integer>> findSubsequencesHelper(int[] nums, int begin, int end) {

		List<List<Integer>> result = new LinkedList<>();

		if (begin + 1== end) {
			List<Integer> num = new LinkedList<>();
			num.add(nums[begin]);
			List<List<Integer>> r = new LinkedList<>();
			r.add(num);
			return r;
		}

		List<List<Integer>> recursiveResult = findSubsequencesHelper(nums, begin+1, end);

		for (List<Integer> t : recursiveResult) {

			result.add(t);
			List<Integer> copied = new LinkedList<>(t);
			if (copied.size() > 0 && copied.get(0) >= nums[begin]) {
				copied.add(0, nums[begin]);
				result.add(copied);
			}
		}

		boolean contained = false;
		for (List<Integer> t : result) {
			if ((t.size() == 1) && (t.get(0) == nums[begin]))
				contained = true;
		}
		if (!contained) {
			List<Integer> temp = new LinkedList<>();
			temp.add(nums[begin]);
			result.add(temp);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] test = {100,90,80,70,60,50,60,70,80,90,100};
		System.out.println(findSubsequences(test));
	}
}
