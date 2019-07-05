package leetCode_Digui_huisu_fenzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * 求子集
 * 
 * @author qyl
 *
 */
public class Solution78
{
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if(nums.length<1) return out;
        List<Integer> list = new ArrayList<Integer>();
        subsetsCore(out,list,nums,0);
		return out;
    }
	
	private static void subsetsCore(List<List<Integer>> out ,List<Integer> list,
			int[] nums,int index) {

		out.add(new ArrayList<Integer>(list));
		if(index==nums.length) {
			return;
		}
		
		for(int i=index;i<nums.length;i++) {
			list.add(nums[i]);
			System.out.println("nums: "+nums[i]);
			subsetsCore(out,list,nums,i+1);
			list.remove(list.size()-1);
		}
	}
    
	
	public static void main(String args[]) {
		int[] nums = {4};
		List<List<Integer>> out = subsets(nums);
		System.out.println("共有种子集: "+out.size());
		for(List<Integer> list : out) {
			System.out.println("-------------");
			for(Integer s :list) {
				System.out.print(s+" ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		}
}
