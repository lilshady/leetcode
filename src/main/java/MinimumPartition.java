/**
 * lintcode 724 数组最小划分
 */
public class MinimumPartition {

	public static int findMin(int[] arr) {

		int sum = 0;

		for (Integer i : arr) {
			sum += i;
		}

		int half = sum / 2;
		int[] solution = new int[half + 1];

		for (int i = 0; i < half+1; i++) {
			solution[i] = 0;
		}

		for (int i = 0; i < arr.length; ++i) {
			for (int j = half; j >= arr[i]; --j) {
				if ((solution[j - arr[i]] + arr[i]) > solution[j]) {
					solution[j] = solution[j - arr[i]] + arr[i];
				}
			}
		}

		return Math.abs( 2 * solution[half] - sum);
	}

	public static void main(String[] args) {
		int[] test = new int[]{911,72,268,540,441,328,822,618,132,553,673,189,280,365,157,769,467};
		System.out.println(findMin(test));
	}
}
