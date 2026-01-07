public class _1339_Maximum_product_of_Splitted_Binary_Tree {

    // Copy and Paste it in Solution Class in Leetcode

    long totalSum = 0, maxProduct = 0;
    static final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        getSubtreeSum(root);
        return (int)(maxProduct % MOD);
    }
    private long getTotalSum(TreeNode node){
        if(node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }
    private long getSubtreeSum(TreeNode node){
        if(node == null) return 0;
        long left = getSubtreeSum(node.left);
        long right = getSubtreeSum(node.right);
        long subTreeSum = left + right + node.val;
        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subTreeSum;
    }
}
