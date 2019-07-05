package leetCode_Digui_huisu_fenzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合数2
 * @author qyl
 * 
 */
public class Solution40
{
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> out = new ArrayList<>();
    	if(candidates.length<1)
    		return out;  
    	Arrays.sort(candidates);
    	conbinationSum2Core(candidates,out,target,new ArrayList<>(),0,new int[1]);
    	
        return out;
    }
    private static void conbinationSum2Core(int[] candidates,List<List<Integer>> out,int target,List<Integer> temp
    		,int index,int[] sum) {
    	if(sum[0]>=target||candidates.length==index)
    	{
    		if(sum[0]==target)
    			out.add(new ArrayList<>(temp));
    		return;
    	}
    	
        for(int i=index;i<candidates.length;i++) {
        	if(i>index&&candidates[i]==candidates[i-1])
        		continue;
        	temp.add(candidates[i]);
        	sum[0]+=candidates[i];
        	conbinationSum2Core(candidates,out,target,temp,i+1,sum);
        	sum[0]-=candidates[i];
        	temp.remove(temp.size()-1);
        }  	
    }
    
	public static void main(String args[]) {
		int[] nums = {2,5,2,1,2};
		List<List<Integer>> out = combinationSum2(nums,5);
		System.out.println("共有种子集: "+out.size());
		for(List<Integer> list : out) {
			for(Integer s :list) {
				System.out.print(s+", ");
			}
			System.out.println();
		}
		}
}
