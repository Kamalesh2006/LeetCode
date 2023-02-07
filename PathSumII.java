/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode() {}
*     TreeNode(int val) { this.val = val; }
*     TreeNode(int val, TreeNode left, TreeNode right) {
*         this.val = val;
*         this.left = left;
*         this.right = right;
*     }
* }
*/
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode (int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class PathSumII {
   public void path(TreeNode root, int targetSum, List<Integer> l, List<List<Integer>> result){
       if(root == null){
           return;
       }
       if(targetSum==root.val && root.left==null && root.right== null){
           l.add(root.val);
           result.add(new ArrayList<Integer>(l));
           l.remove(l.size()-1);
           return;
       }
       l.add(root.val);
       path(root.left,targetSum-root.val,l,result);
       path(root.right,targetSum-root.val,l,result);
       l.remove(l.size()-1);
   }
   public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> result = new ArrayList<>();
       path(root,targetSum,new ArrayList<>(),result);
       return result;
   }

   public static void main(String[] args) {
        PathSumII p = new PathSumII();
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode head = new TreeNode(1,left, right);
        System.out.println(p.pathSum(head, 4));

   }

}
