package leetCode_greedy;
/**
 * 跳跃游戏
 * @author qyl
 * 贪心算法
 */
public class Solution55
{
    public boolean canJump(int[] nums) {
    	int len = nums.length;
    	if(len<2) return true;
    	int[] index = new int[len];
    	for(int i =0;i<len;i++) {
    		index[i] = nums[i]+i;
    	}
    	
    	int current =0;
    	int max_index = 0;
    	while(current<len&&current<index[max_index]) {
    		if(current<index[max_index]) {
    			current++;
    		}
    		if(current<len&&index[current]>index[max_index]) {
    			max_index = current;
    		}
    	}
    	if(current<len-1) return false;
		return true;      
    }
}
