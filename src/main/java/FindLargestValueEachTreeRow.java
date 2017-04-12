import java.util.*;

/**
 * Created by luyuncheng on 2017/4/12.
 */
//515
public class FindLargestValueEachTreeRow {

    public static List<Integer> largestValues(TreeNode root) {

        if (root == null) return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<Integer>();

        Queue<TreeNode> visitQueue = new LinkedList<TreeNode>();

        visitQueue.add(root);

        while (!visitQueue.isEmpty()){

            List<TreeNode> children = new ArrayList<TreeNode>();
            List<Integer> temp = new ArrayList<Integer>();

            while (!visitQueue.isEmpty()){

                TreeNode n = visitQueue.remove();
                temp.add(n.val);
                if (n.left != null) children.add(n.left);
                if (n.right != null) children.add(n.right);

            }

            result.add(Collections.max(temp));

            for (TreeNode n : children)
                visitQueue.add(n);

        }

        return result;

    }

    public static void main(String[] args){

        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode three2 = new TreeNode(3);
        three2.right = three;
        three2.left = five;
        TreeNode two = new TreeNode(2);
        two.right = nine;
        TreeNode one = new TreeNode(1);
        one.left = three2;
        one.right = two;

        System.out.println(largestValues(one));

    }


}
