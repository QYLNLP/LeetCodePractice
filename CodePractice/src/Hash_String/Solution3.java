package Hash_String;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * @author qyl
 * 
 */
public class Solution3
{
    public static int lengthOfLongestSubstring(String s) {
    	if(s==null||s.length()<1) return 0;
    	
    	int len = s.length();
    	char[] chars = s.toCharArray();
    	int first = 0;
    	int end = 0;
    	int length = 0;
    	HashSet<Character> set = new HashSet<Character>();
    	while(first<len&&end<len) {
    		while(end<len&&!set.contains(chars[end])) {
    			set.add(chars[end]);
    			end++;
    		}
    		
    		int tempLength = (end-1)-first+1;
    		if(length<tempLength) length = tempLength;
    		
    		while(end<len&&set.contains(chars[end])) {
    			set.remove(chars[first]);
    			first++;
    		}
    	}
        return length;
    }
    
    public static void main(String args[]) {
    	int len = lengthOfLongestSubstring("bbbbb");
    	System.out.println(len);
    }

}
