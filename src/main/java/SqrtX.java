/**
 * TODO: comment here
 */
public class SqrtX {

	public static int mySqrt(int x) {

		if (x == 0)
			return 0;

		long start = 1;
		long end = x;

		while(start < end) {

			long mid = (start + end) / 2;

			if (mid * mid <= x && (mid+1) *(mid+1) > x) {
				return (int) mid;
			}

			if (mid * mid > x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return (int)start;
	}

	public static void main(String[] args) {

		System.out.println(mySqrt(2147395599));
	}
}
