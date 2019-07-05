package leetCode_greedy;

import java.util.Stack;

/**
 * 移除k个数字
 * @author qyl
 *
 */
public class Solution402
{
	public String removeKdigits(String num,int k) {
		if(num.length()<=k) return new String("0");
		if(k<1) return num;
		
		Stack<Character> stack = new Stack<Character>();
		int j = 0;
        while(j<num.length()&&k>0) {
        	char key = num.charAt(j);
        	while(!stack.empty()&&key<stack.peek()&&k>0) {
        		k--;
        		stack.pop();
        	}
        	//前导零去掉
        	if(!(stack.isEmpty()&&key==48)) {
        		stack.push(key);
        	}
        	j++;
        }
        //删除后数据长度仍然>num.length-k
        while(stack.size()>num.length()-k) stack.pop();
        
        char[] temp=new char[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()) {
        	temp[index--]=stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(temp);
        if(j<num.length()&&temp.length<num.length()-k) {
        	sb.append(num.substring(j, num.length()));
        }else if(temp.length==0)
        	sb.append("0");
        
		return sb.toString();	
	}

}
