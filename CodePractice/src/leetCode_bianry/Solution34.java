package leetCode_bianry;
/**
 * 在排序数组中查找第一个和最后一个元素的位置
 * @author qyl
 *
 */
public class Solution34
{
    public static int[] searchRange(int[] nums, int target) {
    	int[] region = {-1,-1};
    	if(nums.length<1) return region;

    	int start = 0;
    	int end = nums.length-1;
    	while(region[0]==-1&&start<=end) {
    		int mid = (start+end)/2;
    		//[3,3,3] 3
    		if(nums[mid]==target) {
    			if(mid==0||nums[mid-1]<target) {//起始位置
    				region[0] =mid;
    			}else
    				end = mid-1;   		    
    		}
    		else if(nums[mid]<target)
    			start = mid+1;
    		else if(nums[mid]>target)
    			end = mid-1;
    	}
    	
    	start = 0;
    	end = nums.length-1;
    	while(region[1]==-1&&start<=end) {
    		int mid = (start+end)/2;
    		
    		if(nums[mid]==target) {
    		    if(mid==nums.length-1||nums[mid+1]>target) {//结束位置
    				region[1] = mid;
    			}else
    				start = mid+1;  		    
    		}
    		else if(nums[mid]<target)
    			start = mid+1;
    		else if(nums[mid]>target)
    			end = mid-1;
    	}

		return region;      
    }
    
    public static void main(String args[]) {
    	int[] nums = {3,3,3};
    	int[] region =Solution34.searchRange(nums, 3);
    	System.out.println(region[0]+" "+region[1]);
    }
}
