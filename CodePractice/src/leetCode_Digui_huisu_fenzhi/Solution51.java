package leetCode_Digui_huisu_fenzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后
 * 
 * @author qyl
 *
 */
public class Solution51
{
	public static List<List<String>> solveNQueens(int n)
	{
		List<List<String>> out = new ArrayList<>();
		if (n < 1)
			return out;
		// 用二维数组标记
		int[][] location = new int[n][n];
		// 方向数组
		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
		solveNQueensCore(n, out, location, 0, dx, dy);
		return out;
	}

	private static void solveNQueensCore(int n, List<List<String>> out, int[][] location, int row, int[] dx, int[] dy)
	{
		if (row == n)
		{
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < n; i++)
			{
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++)
				{
					if (location[i][j] == 2)
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
			if (location[row][i] == 0)
			{
				int[][] location0 = new int[n][n];			
				for (int m = 0; m < n; m++)
				{
				  location0[m] = Arrays.copyOf(location[m], n);
				}
				pushQueen(location, row, i, dx, dy);
				solveNQueensCore(n, out, location, row + 1, dx, dy);

				// 回溯
				location = location0;
			}

		}
	}

	private static void pushQueen(int[][] location, int row, int line, int[] dx, int[] dy)
	{
		location[row][line] = 2;
		int rowlen = location.length;
		int linelen = location.length;
		for (int i = 0; i < location.length; i++)
		{
			for (int j = 0; j < 8; j++)
			{// 8个方向
				int x = dx[j] * i + row;
				int y = dy[j] * i + line;
				if (x < rowlen && y < linelen && x >= 0 && y >= 0 && location[x][y] == 0)
				{
					location[x][y] = 1;
				}
			}
		}
	}

	public static void main(String args[])
	{
		long startTime = System.currentTimeMillis();    //获取开始时间
		List<List<String>> out = solveNQueens(16);
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
