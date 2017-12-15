/**
 * TODO: comment here
 */
public class Base7 {

	public static String convertToBase7(int num) {

		StringBuilder sb = new StringBuilder();
		boolean isNegative = false;
		if (num == 0) {
			return "0";
		}
		if (num < 0 ) {
			num = -num;
			isNegative = true;
		}

		while (num >= 7) {
			sb.append(num % 7);
			num = num / 7;
		}

		if (num != 0) {
			sb.append(num);
		}

		if (isNegative) {
			sb.append("-");
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(convertToBase7(-7));
	}
}
