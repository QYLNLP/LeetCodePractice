package leetCode_bianry;
/**
 * 搜索插入位置
 * @author qyl
 *
 */
public class Solution35
{
	public int searchInsert(int[] nums,int target) {
		if(nums.length<1) return -1;
		
		int start =0;
		int end = nums.length-1;
		int index = -1;
		while(index == -1) {
			int mid = (start+end)/2;
			if(nums[mid]==target)
				index = mid;
			else if(nums[mid]<target) {
				if(mid==end||nums[mid+1]>target) {
					index = mid+1;
				}else
					start = mid+1;
			}else if(nums[mid]>target) {
				if(mid==start||nums[mid-1]<target) {
					index = mid;
				}else
					end = mid-1;
			}
				
		}
		return index;
	}

}
