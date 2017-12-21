/**
 * TODO: comment here
 */
public class FastPower {

	/*
	* @param a: A 32bit integer
	* @param b: A 32bit integer
	* @param n: A 32bit integer
	* @return: An integer
	*/
	public static int fastPower(int a, int b, int n) {
		// write your code here
		return fastHelper(a, b, n);
	}


	public static int fastHelper(int a, int b, int n) {

		int power = n;

		if (power == 1) {
			return a % b;
		}


		if (power == 0) {
			return 1 % b;
		}

		if (n % 2 != 0) {
			power--;
		}

		return Math.min(fastHelper(a, b, power/2), fastHelper(a,b,power/2));
	}

	public static void main(String[] args) {
		System.out.println(fastPower(100,1000,1000));
	}
}
