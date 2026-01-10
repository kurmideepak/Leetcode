public class _865_Smallest_Subtree_with_All_The_Depest_Node {

    // Copy and Paste it in Solution Class in Leetcode
    TreeNode ans;
    int maxdepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans = null;
        maxdepth = -1;
        helper(root, 0);
        return ans;
    }
    int helper(TreeNode root, int level){
        if(root == null) return 0;
        int left = helper(root.left, level+1);
        int right = helper(root.right, level+1);

        if(left == right && (left + level) >= maxdepth){
            ans = root;
            maxdepth = left + level;
        }
        return 1 + Math.max(left, right);
    }
}
