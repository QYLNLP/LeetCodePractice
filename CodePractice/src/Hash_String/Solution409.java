package Hash_String;
/**
 * 最长回文串
 * @author qyl
 *
 */
public class Solution409
{
    public static int longestPalindrome(String s) {
         if(s.length()<1)
        	 return 0;
         
         int[] fre = new int[80];
         char[] chars =s.toCharArray();
         for(int i=0;i<chars.length;i++) {
        	 fre[chars[i]-65]++;
         }
         
         int len=0;
         boolean oddNum=false;
         for(int j=0;j<fre.length;j++) {
        	 if((fre[j]&1)==0)
        		 len+=fre[j];
        	 else if((fre[j]&1)==1) {
        		 len+=fre[j]-1;
        		 oddNum=true;
        	 }     	 
         }        
    	 return oddNum?len+1:len;
    }

    public static void main(String args[]) {
    	int num =longestPalindrome("abccccddeeeeeeeeeeeee");
    	System.out.println(num);
    }
}
