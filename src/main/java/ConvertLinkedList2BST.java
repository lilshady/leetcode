import java.util.List;

/**
 * 链表的题目一快一慢的解决方式很常见。利用这种差找到中间点。
 */

public class ConvertLinkedList2BST {

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) {
			return null;
		}
		return toBST(head, null);
	}

	public TreeNode toBST(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		if (head == null) {
			return null;
		}
		while(fast != null && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}

		TreeNode treeHead = new TreeNode(slow.val);
		treeHead.left = toBST(head, slow);
		treeHead.right = toBST(slow.next, tail);
		return treeHead;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
