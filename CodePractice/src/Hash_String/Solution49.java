package Hash_String;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 字母异位词分组
 * @author qyl
 *
 */
public class Solution49
{
    public static List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> list = new ArrayList<>();   	
    	if(strs==null||strs.length<1) return null;
    	
    	HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    	for(String str:strs) {
    		char[] chars = str.toCharArray();
    	    Arrays.sort(chars);	    
    	    String key = new String(chars);
    	    
    		ArrayList<String> value = map.getOrDefault(key, new ArrayList<String>());
    		value.add(str);
    		map.put(key, value);
    		
    	}
    	for(ArrayList<String> alist:map.values())
    		list.add(alist);   		

        return list;
    }
}
