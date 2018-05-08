/**
 * Created by lil_shady on 2018/5/8.
 * 469 检查两棵二叉树是否等价。等价的意思是说，首先两棵二叉树必须拥有相同的结构，并且每个对应位置上的节点上的数都相等。
 */
public class SameTree {

    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;


        return  a.val == b.val && isIdentical(a.right, b.right) && isIdentical(a.left, b.left);

    }
}
