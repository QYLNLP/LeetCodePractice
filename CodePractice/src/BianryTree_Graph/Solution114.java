package BianryTree_Graph;
/**
 * 二叉树转链表
 * @author qyl
 *
 */
public class Solution114
{
    public void flatten(TreeNode root) {
        if(root==null)
        	return;
        flattenCore(root);
    }
    /**
     * 返回最右侧的节点
     * @param node
     * @return
     */
    public TreeNode flattenCore(TreeNode node) {
    	if(node==null)
    		return null;
    	TreeNode left = node.left;
    	TreeNode right= node.right;
    	node.left = null;
		node.right=left;
		
    	TreeNode last = node;
    	if(left!=null) {
    		last =flattenCore(left);
    	}  	
    	if(right!=null) {
    		System.out.println("last.val "+last.val);
    		last.right=right;
    		last = flattenCore(right);
    	}
		return last; 	
    }

}
