/**
 * Created by lil_shady on 2018/5/14.
 */
public class DeleteDuplicateLinkList {

    public ListNode deleteDuplicates(ListNode head) {
        // write your code here

        if (head == null) {
            return null;
        }

        ListNode current  = head;
        ListNode next = current.next;

        while (next != null) {
            if (next.val == current.val) {
                current.next = next.next;
                next.next = null;
                next = current.next;
            } else {
                current = next;
                next = next.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
