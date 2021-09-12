/**
 * 
 * 124. Binary Tree Maximum Path Sum
 * 
 * Given the root of a binary tree, return the maximum path sum of any path.
 * 
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
public class MaxPathSum {
    
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; this.left=this.right=null; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int result;

    /**
     * 
     * Divide the issue into subtree problems
     * Get subtree result and return the best result to parent node
     * 
     * @param root
     * @return
     */
    private int pathSum(MaxPathSum.TreeNode root) {
        result = Integer.MIN_VALUE;
        search(root);
        return result;
    }

    private int search(TreeNode currentNode) {
        if(currentNode == null){
            return 0;
        }

        int lv = search(currentNode.left);
        int rv = search(currentNode.right);

        result = Math.max(result, lv + rv + currentNode.val);

        return Math.max(Math.max(lv + currentNode.val, rv + currentNode.val),0);

    }

    public static void main(String[] args) {
        TreeNode leftSubTree = new TreeNode(9);
        TreeNode rightSubTree = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(-10, leftSubTree, rightSubTree);
        System.out.println(new MaxPathSum().pathSum(root));
    }

}
