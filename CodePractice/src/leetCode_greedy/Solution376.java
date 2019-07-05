package leetCode_greedy;
/**
 * 摇摆序列
 * @author qyl
 * [1,7,4,9,2,5]
 */
public class Solution376
{
    public int wiggleMaxLength(int[] nums) {
    	int[] len= {0,1};
    	if(nums.length<2) return len[nums.length];
    	
    	int state=0;
    	int num = 1;
    	for(int i=0;i<nums.length-1;i++) {
    		switch(state) {
			case 0:
				if(nums[i+1]>nums[i]) {
					num++;
					state=1;
				}else if(nums[i+1]<nums[i]){
					num++;
					state=2;
				}
				break;
			case 1:
				if(nums[i+1]<nums[i]){
					num++;
					state=2;
			    }
				break;
			case 2:
				if(nums[i+1]>nums[i]) 
				{
				    num++;
				    state=1;
				}
				break;
    		}

    	}
		return num;        
    }
}
