/**
 * 392
 */
public class HouseRobber {

	public static long houseRobber(int[] A) {

		long[] solution = new long[A.length];
		solution[0] = A[0];
		solution[1] = A[1] > A[0] ? A[1]:A[0];

		for (int i = 2; i < A.length; ++i) {

			if (solution[i-2] + A[i] > solution[i-1]) {
				solution[i] = solution[i-2] + A[i];
			} else {
				solution[i] = solution[i-1];
			}
		}

		return solution[A.length - 1];
	}

	public static void main(String[] args) {
		int[] test = new int[]{1,8,10,6,7,12,11,123,121};
		System.out.println(houseRobber(test));
	}
}
