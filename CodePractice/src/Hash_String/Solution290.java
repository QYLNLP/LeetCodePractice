package Hash_String;
import java.util.HashMap;
import java.util.Map;

/**
 * 单词规律
 * @author qyl
 *
 */
public class Solution290
{

	public  static boolean wordPattern(String pattern,String str) {
		String[] words = str.split(" ");
		if(words.length!=pattern.length()) {
			return false;			
		}
		Map<Integer, String> map = new HashMap<>();
		
		int i=0;
		while (i<words.length)
		{
			Integer ch = pattern.charAt(i)-'a';
			String word = words[i];
			if (map.keySet().contains(ch))
			{
				if (!map.get(ch).equals(word))
					return false;
			}
			else
			{
				if (map.containsValue(word))
					return false;
				map.put(ch, words[i]);
			}
			i++;
		}
		return true;
	}
	
	public static void main(String args[]) {

		String pattern ="abba";
		String str = "dog cat cat dog";
		System.out.println(wordPattern(pattern,str));
	}

}
