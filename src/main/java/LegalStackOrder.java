import java.util.List;
import java.util.Stack;

/**
 * TODO: comment here
 */
public class LegalStackOrder {

	private static boolean isLegalStackOrder(List<Integer> input, List<Integer> output) {

		int inputIndex = 0;
		int outputIndex = 0;

		Stack<Integer> tempStack = new Stack<Integer>();

		boolean legal = true;
		while(outputIndex < output.size()) {
			if (inputIndex < input.size() && output.get(outputIndex).equals(input.get(inputIndex))) {
				outputIndex++;
				inputIndex++;
			} else if (!tempStack.isEmpty() && tempStack.peek().equals(output.get(outputIndex))) {
				tempStack.pop();
				outputIndex++;
			} else if (inputIndex < input.size()) {
				tempStack.push(input.get(inputIndex));
				inputIndex++;
			} else {
				legal = false;
			}
		}

		return legal;
	}
}
