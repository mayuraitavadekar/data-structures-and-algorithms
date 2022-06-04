package Leetcode;

import java.util.*;

public class PostfixEvaluation {
	
	
	public static int calculate(int a, int b, char c)
	{
		int result = 0;
		switch(c)
		{
		case '+':
			result = a+b;
			break;
		case '-':
			result = a-b;
			break;
		case '/':
			result = a/b;
			break;
		case '*':
			result = a*b;
			break;
		case '^': 
			result = a^b;
			break;
			
		}
		
		return result;
	}
	
	public static int eval(String exp)
	{
		
		Stack<Integer> stack = new Stack<>();
		
		int x1, x2, result=0;
		
		for(int i=0;i<exp.length();i++)
		{
			char c = exp.charAt(i);
			
			if(Character.isDigit(c))
			{
				stack.push(c-'0');
			}
			
			else
			{
				// the following storage order in x1 and x2 is important
				x2 = stack.pop();
				x1 = stack.pop();
				
				// calculate result
				result = calculate(x1, x2, c);
				
				// again push result into stack
				stack.push(result);
			}
		}
		
		
		return stack.pop();
	}
	
	public static void main(String[] args)
	{
		String exp = "63*5-";
		System.out.println(eval(exp));
	}
	
}
