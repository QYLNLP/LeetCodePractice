package leetCode_bianry;

import java.util.Stack;

/**
 * 简单的计算器 hard,只有+，—
 * @author qyl
 * 有限状态机,224
 */
public class Solution224
{
	public static int calculate(String s) {
		if(s==null||s.length()<1)
			return -1;
		
		char[] chars = s.toCharArray();

		int compute_flag = 0;
		int state =0;
		int number = Integer.MIN_VALUE;
		Stack<Integer> num_stack = new Stack<Integer>();
		Stack<Character> operator_stack = new Stack<Character>();
		for(int i=0;i<chars.length;i++) {
			if(chars[i]==' ')//如果为空格，则跳过
				continue;
			switch(state) {
			case 0:
				if(chars[i]>='0'&&chars[i]<='9') {
					state = 1;
				}else if(chars[i]=='(') {
					state = 2;
				}
				i--;//退格
				break;
			case 1:
				if(chars[i]>='0'&&chars[i]<='9') {
					number =number*10+chars[i]-'0';
				}else 
				{
					num_stack.add(number);
					if(compute_flag==1) {
						compute(num_stack,operator_stack);
					}

					number = Integer.MIN_VALUE;
					i--;//退格
					state = 2;
				}
				break;
			case 2:
				if(chars[i]=='+'||chars[i]=='-') {
					operator_stack.push(chars[i]);
					compute_flag=1;
				}
				else if(chars[i]=='(') {
					state =1;
					compute_flag=0;
				}else if(chars[i]==')'&&operator_stack.size()!=0) {
					compute(num_stack,operator_stack);
				}else if(chars[i]>='0'&&chars[i]<='9') {
					state =1;
					i--;
				}
                break;							
			}
		}
		if(number!=Integer.MIN_VALUE) {//处理类似1+1,1			
			num_stack.push(number);
			if(operator_stack.size()!=0)
			    compute(num_stack,operator_stack);
		}
		
		return num_stack.pop();			
	}
	
	private static void compute(Stack<Integer> num_stack,Stack<Character> operator_stack) {
		char ch = operator_stack.pop();
		int num2 = num_stack.pop();
		int num1 = num_stack.pop();
		if(ch=='+')
			num1 = num1+num2;
		else
			num1 = num1-num2;
		
		num_stack.push(num1);
	}
	
	public static void main(String args[]) {
		//String s ="(1+(4+5+2)-3)+(6+8)";
		//String s =" 1+1";
		String s ="0";
		int result = calculate(s);
		System.out.println("结果"+result);
	}

}
