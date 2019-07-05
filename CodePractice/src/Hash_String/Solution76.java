package Hash_String;

import java.util.ArrayList;

/**
 * 最小覆盖子串
 * @author qyl
 * 
 */
public class Solution76
{
	
    public static String minWindow1(String s, String t) {
    	if(s.length()<t.length()) return "";
    	
    	int[] map = new int[128];
    	for(int i=0;i<t.length();i++) {
    		map[t.charAt(i)]+=1;
    	}
    	
    	int len = Integer.MAX_VALUE;
    	int begin = 0;
    	int count = t.length();
    	for(int l=0,r=0;r<s.length();r++) {
    		char chr = s.charAt(r);
    		map[chr]--;//窗口右移 
    		if(map[chr]>=0) count--;//t中的元素
    		
    		while(count==0) {//窗口左移
    			char chl = s.charAt(l);
    			map[chl]++;
    			if(map[chl]>0) {//t中的元素   				
    				if(len>r-l+1) {
    					begin = l;
    					len = r-l+1;
    				}
    				count++;
    			}
    			l++;
    		}
    	}
    	return len==Integer.MAX_VALUE?"":s.substring(begin,begin+len);
    }
	
	/**
	 * 时间超出
	 * @param s
	 * @param t
	 * @return
	 */
    public static String minWindow(String s, String t) {
    	if(t.length()>s.length()) return "";
         
    	int[] map = new int[58];
    	int[] map1 = new int[58];
    	for(char ch:t.toCharArray()) {
    		map1[ch-'A'] +=1;
    	}
    	System.out.println(map1['a'-'A']);
    	int l = 0;
    	int r = 0;
    	int len = t.length();
    	String result = "";
    	while(r<s.length()) {
    		map[s.charAt(r)-'A'] +=1;
    		int wize = r-l+1;  
    		
    		if(wize==len&&IsContains(map,map1,t)) {
    			return s.substring(l,r+1);
    		}
    		
    		if(wize>len&&IsContains(map,map1,t)) {
    			while(IsContains(map,map1,t)) {
    				map[s.charAt(l)-'A'] -= 1;
    				l++;
    			}
    			if(result==""||result.length()>s.substring(l-1, r+1).length())
    				result = s.substring(l-1, r+1);			
    		}   		
    		r++;
    	}
    	
      return result;   
    }
    private static boolean IsContains(int[] map,int[] map1,String target) {
    	char[] chars = target.toCharArray();
    	for(int i=0;i<chars.length;i++) {
    		System.out.println(map[chars[i]-'A']+"  "+map1[chars[i]-'A']);
    		if(map[chars[i]-'A']<map1[chars[i]-'A'])
    			return false;
    	}
		return true;    	
    }
      
    public static void main(String args[]) {
    	
    	
    	String str1= "cabwefgewcwaefgcf";
    	String str2= "cae";
    	String str3 = minWindow1(str1,str2);
    	System.out.println("str3 "+str3);
    }
}
