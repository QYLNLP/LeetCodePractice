package leetCode_bianry;
/**
 * 前序遍历和中序遍历从新构建二叉树
 * @author qyl
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder==null||inorder==null||preorder.length<1||inorder.length<1||
    			preorder.length!=inorder.length) {
    		return null;
    	}
    	
		return buildTreeCode(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }
    private TreeNode buildTreeCode(int pre[],int preStart,int preEnd,int[] in,int inStart,int inEnd) {
		TreeNode root = new TreeNode(pre[preStart]);
		root.left = null;
		root.right = null;
		
		for(int i=inStart;i<=inEnd;i++) {
			if(pre[preStart]==in[i]) {
				int len = i-inStart;
				if(len>0)
				    root.left = buildTreeCode(pre,preStart+1,preStart+len,in,inStart,i-1);
				if(inEnd>i)
					root.right = buildTreeCode(pre,preStart+len+1,preEnd,in,i+1,inEnd);
				break;
			}
		}
    	
    	return root;
    	
    }
}
