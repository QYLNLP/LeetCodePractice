package BianryTree_Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 侧面观察二叉树
 * @author qyl
 * 宽度优先遍历中，每一层的最后一个即是侧面观察需要的节点
 * 使用队列,从右往左遍历计算更简单
 * 更快，使用递归，把层数当多参数来传递,从右往左遍历计算更简单
 */
public class Solution199
{
	public List<Integer> rightSideView1(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root==null) return list;		
		
    	rightSideViewCore(root,list,1);
		return list;
	}
	
	public void rightSideViewCore(TreeNode node,List<Integer> list,int depth) {
		if(node==null)
			return;
		
		if(depth>list.size())
			list.add(node.val);
		
		rightSideViewCore(node.right,list,depth+1);
		rightSideViewCore(node.left,list,depth+1);		
	}
	
	/**
	 * 栈
	 * @param root
	 * @return
	 */
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root==null) return list;
    	
    	Deque<Pair> deque = new LinkedList<Pair>();
    	deque.add(new Pair(root,1));
    	int proLayer=0;
    	while(!deque.isEmpty()) {
    		Pair current = deque.peek();
    		int curLayer = current.num;
    		TreeNode  node = current.node;
    		
    		if(curLayer!=proLayer)
    			list.add(node.val);
 
    		if(node.right!=null)
   		         deque.add(new Pair(node.right,curLayer+1));
    		if(node.left!=null)
    		     deque.add(new Pair(node.left,curLayer+1));
    		
    		deque.pop();
    		proLayer = curLayer;
    	}
        return list;
    }
    class Pair {
    	TreeNode node;
    	int num;
    	public Pair(TreeNode node,int num) {
    		this.node = node;
    		this.num = num;
    	}
    }

}
