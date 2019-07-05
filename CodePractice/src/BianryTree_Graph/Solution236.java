package BianryTree_Graph;

import java.util.ArrayList;
import java.util.Stack;
/**
 * 二叉树的最近公共祖先 medium
 * @author qyl
 *
 */
public class Solution236
{
	public TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q) {
		if(root==null)
			return null;
		
		if(root.val==p.val||root.val==q.val) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor1(root.left,p,q);
		TreeNode right = lowestCommonAncestor1(root.right,p,q);
		
		if(left!=null&&right!=null) return root;
		if(left!=null) return left;
		if(right!=null) return right;
		
		return null;
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    	if(root==null||p==null||q==null)
	    		return null;
	    	
	    	ArrayList<TreeNode> listp = new ArrayList<TreeNode>();
	    	ArrayList<TreeNode> listq = new ArrayList<TreeNode>();
	    	lcaCore(root,p,listp,new Stack<TreeNode>());
	    	lcaCore(root,q,listq,new Stack<TreeNode>());
	    	
	    	int i=0;
	    	for(;i<listp.size()&&i<listq.size();i++) {
	    		if(listp.get(i)!=listq.get(i))
	    			break;
	    	}
			return listq.get(i-1);    
	    }
	    public void lcaCore(TreeNode node,TreeNode target,ArrayList<TreeNode> list,Stack<TreeNode> stack) {
	    	if(node==null)
	    		return;
	    	
	    	stack.add(node);
	    	if(node==target) {
	    		list.addAll(stack);
	    		return;   		
	    	}
	    	
	    	lcaCore(node.left,target,list,stack);
	    	lcaCore(node.right,target,list,stack);
	    	stack.pop();
	    }

}
