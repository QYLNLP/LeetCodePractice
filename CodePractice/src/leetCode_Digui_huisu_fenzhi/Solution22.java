package leetCode_Digui_huisu_fenzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 
 * @author qyl
 *
 */
public class Solution22
{
	public static List<String> generateParenthesis(int n)
	{
		List<String> out = new ArrayList<String>();
		if (n < 1)
			return out;
		generateParenthesisCore(out,n, 0, 0, new String());
		return out;
	}

	private static void generateParenthesisCore(List<String> out,  int num, int leftnum, int rightnum,
			String str)
	{		
		if (leftnum == rightnum && leftnum== num)
		{
			out.add(new String(str));
			return;
		}

		if(leftnum<num)
		     generateParenthesisCore(out, num, leftnum+1, rightnum, str+"(");
		// 回溯
		if(rightnum<leftnum&&rightnum<num)
		     generateParenthesisCore(out, num, leftnum, rightnum+1, str+")");
	}

	public static void main(String args[])
	{
		List<String> out = generateParenthesis(3);
		System.out.println("共有种子集: " + out.size());
		for (String str : out)
		{
			System.out.println(str);
		}
	}
}
