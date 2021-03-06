import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luyuncheng on 2017/4/7.
 */
//315
//Every node will maintain a val sum recording the total of number on it's left bottom side, dup counts the duplication. For example, [3, 2, 2, 6, 1], from back to beginning,we would have:

 //               1(0, 1)
   //                     \
 //                       6(3, 1)
   //                     /
     //                   2(0, 2)
     //                   \
      //                  3(0, 1)
       //                 When we try to insert a number, the total number of smaller number would be adding dup and sum of the nodes where we turn right.
       //                 for example, if we insert 5, it should be inserted on the way down to the right of 3, the nodes where we turn right is 1(0,1), 2,(0,2), 3(0,1), so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4
//
           //             if we insert 7, the right-turning nodes are 1(0,1), 6(3,1), so answer should be (0 + 1) + (3 + 1) = 5
public class CountSmallerNumbersAfterSelf {


    class Node {

        Node left, right;
        int val, sum, dup = 1;

        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}
