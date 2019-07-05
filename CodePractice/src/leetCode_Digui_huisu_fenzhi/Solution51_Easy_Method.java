package leetCode_Digui_huisu_fenzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * 
 * @author qyl
 *
 */
public class Solution51_Easy_Method
{
	public static List<List<String>> solveNQueens(int n)
	{
		List<List<String>> out = new ArrayList<>();
		if (n < 1)
			return out;
		// 用一维数组标记
		int[] rowValue = new int[n];
		solveNQueensCore(n,out, rowValue, 0);
		return out;
	}

	private static void solveNQueensCore(int n,List<List<String>> out, int[] rowValue, int row)
	{
		if (row == n)
		{
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < n; i++)
			{
				int key =rowValue[i];
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++)
				{
					if (key==j)
						sb.append("Q");
					else
					{
						sb.append(".");
					}
				}
				list.add(sb.toString());
			}
			out.add(list);
			return;
		}

		// 遍历列
		for (int i = 0; i < n; i++)
		{
			rowValue[row] = i;
			if(isValid(row,rowValue))
                    solveNQueensCore(n,out,rowValue,row+1);
            //rowValue中只改变一个值，在下一个循环中改变相当于一次回溯
		}
	}

    private static boolean isValid(int row,int[] rowValue) {
    	for(int i=0;i<row;i++) {
    		if(rowValue[i]==rowValue[row]||Math.abs(rowValue[i]-rowValue[row])==row-i) {
    			return false;
    		}
    	}
    	return true;
    }

	public static void main(String args[])
	{
		long startTime = System.currentTimeMillis();    //获取开始时间
		List<List<String>> out = solveNQueens(8);
		System.out.println("共有种子集: " + out.size());
		for (List<String> list : out)
		{
			for (String s : list)
			{
				System.out.print(s + ", ");
			}
			System.out.println();
		}
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("共执行时间： "+(endTime-startTime));
	}
}
