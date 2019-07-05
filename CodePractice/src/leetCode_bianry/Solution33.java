package leetCode_bianry;
/**
 * 旋转排序数组查找
 * @author qyl
 *
 */
public class Solution33
{
	public static int search(int[] nums,int target) {
        if(nums.length<1) return -1;
        
        int start = 0;
        int end = nums.length-1;
        int index = -1;
        while(start<=end&&index==-1) {
        	int mid = (start+end)/2;
        	
        	if(nums[mid]==target)
        		index = mid;
        	else if(nums[mid]<target) {
        		if(nums[start]<=nums[mid]) {//旋转节点在mid后
        			start = mid+1;
        		}else if(nums[start]>nums[mid]){//旋转节点在mid前
        			if(nums[start]<=target) {
        				end = mid -1;
        			}else {
        				start = mid+1;//nums[0]>target
        			}
        		}else {
        			if(start==end)
        				break;
        			else
        				start = end;
        		}
        	}
        	else if(nums[mid]>target) {
        		if(nums[start]<nums[mid]) {//旋转节点在mid后
        			if(nums[start]<=target) {
            			end = mid-1;       				
        			}else
        				start =mid+1;
        		}
        		else if(nums[start]>nums[mid]) {//旋转节点在mid前
        			end = mid-1;
        		}else {
        			if(start==end)
        				break;
        			else
        				start = end;
        		}
        	}
        }
				
		return index;		
	}
	
    public static void main(String args[]) {
    	//int[] nums = {4,5,6,7,0,1,2};
    	//int[] nums = {3,1};
    	int[] nums = {5,1,2,3,4};
    	int region =Solution33.search(nums, 1);
    	for(int i=0;i<10;i++) {
        	System.out.println("target="+i+"  index="+Solution33.search(nums, i));   		
    	}

    }

}