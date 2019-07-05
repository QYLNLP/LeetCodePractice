package leetCode_greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 射击气球
 * 
 * @author qyl 贪婪算法
 */
public class Solution452
{
	public int findMinArrowShots(int[][] points)
	{
		if(points.length<2) return points.length;
		
		Arrays.sort(points,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2)
			{
				return o1[0]-o2[0];
			}		
		});
		int count = 1;
		int[] region = {points[1][0],points[1][1]};
		for(int i=1;i<points.length;i++) {
			if(region[1]<points[i][0])
			{
				count++;
				region[0] = points[i][0];
				region[1] = points[i][1];
				continue;
			}
			//区间更新
			if(region[1]>points[i][1])
				region[1] = points[i][1];
			if(region[0]<points[i][0])
				region[0] = points[i][0];
		}
		return count;
	}

}
