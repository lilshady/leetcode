/**
 * solution[i][j] is the minimum number of characters that need to be inserted
 * to make x[i][j] into a palindrome
 *
 * solution[i][j] = solution[i+1][j-1] if x[i] == x[j]
 * solution[j][j] = 1 + min(solution[i+1][j], solution[i][j-1]) if x[i]!=x[j]
 * base cases: solution[i][i] == solution[i-1][i] == 0
 */
public class MininumberForPalindrome {

	public static int miniNumberForPalindrome(String original) {

		int length = original.length();
		Integer[][] solution = new Integer[length][length];

		solution[0][0] = 0;
		for (int i = 1; i < length; ++i) {
			solution[i][i] = 0;
			solution[i-1][i] = 0;
		}

		for (int step = 2; step < length; step++) {
			for (int i = 0,j = i + step; i < length && j < length; i++, j++) {
				if (original.charAt(i) == original.charAt(j)) {
					solution[i][j] = solution[i+1][j-1];
				} else {
					solution[i][j] = 1 + Math.min(solution[i+1][j],solution[i][j-1]);
				}
			}
		}

		return solution[0][length-1];
	}

	public static void main(String[] args) {
		System.out.println(miniNumberForPalindrome("abba"));
	}
}
