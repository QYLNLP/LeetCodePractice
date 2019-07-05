package leetCode_bianry;

import java.util.ArrayList;
import java.util.List;

/**
 * 逆序数
 * @author qyl
 * 倒序，二叉树
 */
public class Solution315
{
	public static List<Integer> countSmaller(int[] nums){

		ArrayList<Integer> list = new ArrayList<Integer>();
		if(nums==null||nums.length<1) {
			return list;
		}
		
		TreeNode root = new TreeNode(nums[nums.length-1]);
		int[] counts = new int[nums.length];
		for(int i=nums.length-2;i>=0;i--) {
			buildTreeCode(root,nums[i],counts,i);
		}
		for(int k:counts)
			list.add(k);
		return list;
	}
	
	private static void buildTreeCode(TreeNode node,int value,int[] counts,int index) {
		if(value<=node.val) {
			node.count++;
			if(node.left!=null) {
				buildTreeCode(node.left,value,counts,index);
			}else {
				node.left = new TreeNode(value);
			}
		}else {
			counts[index]+=node.count+1;
			if(node.right!=null) {
				buildTreeCode(node.right,value,counts,index);
			}else {
				node.right = new TreeNode(value);
			}
		}
	}
	
	public static void main(String args[]) {
		int[] nums= {66,5,38,7};
		List<Integer> list =countSmaller(nums);
		for(Integer k:list) {
			System.out.print(k+" ");
		}
			
	}
}
