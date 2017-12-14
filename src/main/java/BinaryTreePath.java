import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePath {

	public static List<String> binaryTreePaths(TreeNode root) {

		List<String> result = new ArrayList<>();
		if (root == null) {
			return Collections.emptyList();
		}

		binaryTreePathsHelper(root, result, "");
		return result;
	}

	private static void binaryTreePathsHelper(TreeNode root, List<String> result, String prefix) {

		if (root.right == null && root.left == null) {
			result.add(prefix + root.val);
		}

		if (root.right != null) {
			binaryTreePathsHelper(root.right, result, prefix + root.val +"->");
		}

		if (root.left != null) {
			binaryTreePathsHelper(root.left, result, prefix + root.val +"->");
		}
	}

	public static void main(String[] args) {

		TreeNode five = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode one = new TreeNode(1);

		one.left = two;
		one.right = three;
		three.right = five;

		System.out.println(binaryTreePaths(one));
	}
}

// class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}