package BianryTree_Graph;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * 路径之和2 medium
 * 
 * @author qyl
 * 
 * 使用栈来临时存储
 */
public class Solution113
{
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> out = new ArrayList<>();
       if(root==null||sum<1) {
    	   return out;
       }
       int[] tempSum = new int[1];
       pathSumCore(root,out,new Stack<Integer>(),sum,tempSum);
       return out;
    }
    public static void pathSumCore(TreeNode node,List<List<Integer>> out,Stack<Integer> stack,
    		int target ,int[] tempSum) {
    	if(node==null)
    		return;   	
    	if(node.left==null&&node.right==null&&target==tempSum[0]) {
    		System.out.println("找到了");
    		out.add(new ArrayList<Integer>(stack));
    		return;
    	}
    	
    	stack.add(node.val);
    	tempSum[0]+=node.val;
    	pathSumCore(node.left,out,stack,target,tempSum);
    	pathSumCore(node.right,out,stack,target,tempSum);
    	stack.pop();
    	tempSum[0]-=node.val;
    	
    }
	// Definition for a binary tree node.
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

}
