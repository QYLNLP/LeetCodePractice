package Hash_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;

/**
 * 重复的DNA序列
 * @author qyl
 * 
 */
public class Solution187
{
    public static List<String> findRepeatedDnaSequences1(String s) {
    	List<String> list = new  ArrayList<String>();
        if(s==null||s.length()<1)
        	return list;

        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        
        for(int i = 10;i<=s.length();i++) {
        	String key = s.substring(i-10, i);
        	if(!set1.add(key)) set2.add(key);
        }
    	return new ArrayList<String>(set2);
    }
	/**
	 * 位运算解法
	 * @param s
	 * @return
	 */
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new  ArrayList<String>();
        if(s==null||s.length()<1)
        	return list;
        int first = 0;
        int end = 10;
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        HashSet<String> set = new HashSet<String>();
        while(end<=s.length()) {
        	String value = s.substring(first, end);
        	Integer key = convertStringToNum(value);
        	if(!map.keySet().contains(key)) {
        		map.put(key, value);
        	}else {
        		set.add(value); 
        	}

        	first++;
        	end++;
        }
        for(String str:set) {
        	list.add(str);
        }
    	return list;
    }
    private static Integer convertStringToNum(String str) {
    	int value = 0;
    	for(int i=0;i<str.length();i++) {
    		char ch= str.charAt(i);
    		int num =-1;
    		switch(ch){
    		case 'A':
    			num = 0;
    			break;
    		case 'C':
    			num = 1;
    			break;
    		case 'G':
    			num = 2;
    			break;
    		case 'T':
    			num = 3;
    			break;
    		}
    		value = (value<<2)+num;  

    	}
    	return value;
    }

    
    public static void main(String args[]) {
    	List<String> list = findRepeatedDnaSequences1("AAAAAAAAAAA");
        for(String str:list) {
        	System.out.println("str "+str);
        }
    }
}
