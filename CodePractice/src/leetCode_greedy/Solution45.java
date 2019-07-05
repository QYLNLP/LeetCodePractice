package leetCode_greedy;
/**
 * 跳跃游戏2
 * @author qyl
 * 贪心算法
 */
public class Solution45
{
	public int jump(int[] nums) {
		int len = nums.length;
		if(len<2) return 0;
		
		int count =1;
		int current_max = nums[0];
		int pre_max_max = nums[0];
		for(int j =0;j<len;j++) {
			if(j>current_max) {
				count++;
				current_max = pre_max_max;
			}
			if(nums[j]+j>pre_max_max)
				pre_max_max = nums[j]+j;
		}
		return count;
	}

}
