/**
 * Created by lil_shady on 2017/4/6.
 */
//437
public class PathSumIII {

    public static int pathSum(TreeNode root, int sum) {

        if (root == null)
            return 0;

        return  pathSum(root.left,sum) + pathSum(root.right,sum) +
                pathSumInclude(root,sum);

    }

    public static int pathSumInclude(TreeNode root,int sum){

        if (root == null)
            return 0;

        int temp = root.val == sum? 1 : 0;

        return temp + pathSumInclude(root.left,sum - root.val) + pathSumInclude(root.right,sum-root.val);

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}