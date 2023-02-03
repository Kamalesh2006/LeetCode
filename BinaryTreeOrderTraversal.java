import java.util.*;
public class BinaryTreeOrderTraversal {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        q.add(root);
        while(q.size()>0){
            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> l = new ArrayList<>();
            while(q.size()>0 ){
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left!=null)
                    temp.add(node.left);
                if(node.right!=null)
                    temp.add(node.right);
            }
            result.add(l);
            q = temp; 
        }
        return result;
    }
}
