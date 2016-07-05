package com.company;

import com.company.DataStructure.*;

/**
 * Created by jason on 16/7/4.
 * to determine if it is a BST, we can user recursion set low and high limitation to verify if it is satisfied.
 * We can see the high limitation of left subtree is current node's value, which is also the low limitation of right subtree.
 * Check the requirement recursively, the runtime is O(n), space is O(n)
 *
 */

public class ValidateBinarySearchTree {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return isMonotonic(root);
//        return vaild(root, null, null);
//        return vaild1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    /*
     * pay attention to the corner case of valid1: if the root's val == MAX_VALUE, it does not work. We can fix this by using null.
     */
    public boolean vaild1(TreeNode root, int low, int high)
    {
        if(root == null)
            return true;
        if((root.val <= low) || (root.val >= high))
            return false;
        return vaild1(root.left, low, root.val)
                && vaild1(root.right, root.val, high);
    }
    /*
     * using Integer instead of int can give initial value null, can solve the MAX_VALUE problem.
     */
    public boolean vaild(TreeNode root, Integer low, Integer high)
    {
        if(root == null)
            return true;
        if((low!= null && root.val <= low) || (high!= null && root.val >= high))
            return false;
        return vaild(root.left, low, root.val)
                && vaild(root.right, root.val, high);
    }
    /*
     * in-order traversal of BTS is monotonic increasing, so we use prev to save the last node's value to verify monotonicity.
     */
    public boolean isMonotonic(TreeNode root)
    {
        if(root == null)
            return true;
        boolean res = true;
        res = res && isMonotonic(root.left);
        if(prev != null && prev.val > root.val)
            return false;
        prev = root;
        return res && isMonotonic(root.right);
    }
    public static void main(String[] args) {
        // write your code here
        TreeOperation operation = new TreeOperation();
        operation.init(new int[]{2,1,3,4});
        TreeNode root = operation.createTree();
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        System.out.println(solution.isValidBST(root));
    }
}
