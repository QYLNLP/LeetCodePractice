package leetCode_Digui_huisu_fenzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 求子集2，含有重复元素的子集
 * @author qyl
 *
 */
public class Solution90
{
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> out = new ArrayList<List<Integer>>();
        if(nums.length<1)
        	return out;
        
        Arrays.sort(nums);       
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	HashSet<List<Integer>> set =new HashSet<List<Integer>>();
   
    	subsetsWithDupCore(set,list,nums,0);
    	
    	for(List<Integer> list1: set) {
    		out.add(list1);
    	}
 		return out;         
    }
    private static void subsetsWithDupCore(HashSet<List<Integer>> set,
    		ArrayList<Integer> list,int[] nums, int index) {
    	set.add(new ArrayList<Integer>(list));
    	if(index==nums.length) {
    		return;
    	}
    	
    	for(int i=index;i<nums.length;i++) {
    		list.add(nums[i]);
    		subsetsWithDupCore(set,list,nums,i+1);
    		list.remove(list.size()-1);
    	}
    }
	public static void main(String args[]) {
		int[] nums = {4,4,4,1,4};
		List<List<Integer>> out = subsetsWithDup(nums);
		System.out.println("共有种子集: "+out.size());
		for(List<Integer> list : out) {
			for(Integer s :list) {
				System.out.print(s+", ");
			}
			System.out.println();
		}
		}
	
	//第二种方法更简单
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    public static void subsets(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
    	result.add(new ArrayList<>(temp));
    	if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            //与78题不同 之处就是添加一个判重
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            //result.add(new ArrayList<>(temp));
            subsets(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
