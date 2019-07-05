package leetCode_greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 贪心，分糖果
 * 
 * @author qyl
 *
 */
public class Solution455
{
	public int findContentChildren(int[] g, int[] s)
	{
		ArrayList<Integer> glist = new ArrayList<Integer>();
		ArrayList<Integer> slist = new ArrayList<Integer>();
		for(int i=0;i<g.length;i++)
			glist.add(g[i]);
		for(int j=0;j<s.length;j++)
			slist.add(s[j]);
		Collections.sort(glist);
		Collections.sort(slist);
		int a = 0;
		int b = 0;
		while(a<g.length&&b<s.length)
		{
			if(glist.get(a)<=slist.get(b)) {
			    a++;
			    b++;
			}
			else
				b++;
		}
		return a;

	}
}
