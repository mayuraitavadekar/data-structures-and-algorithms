package Leetcode;

import java.util.*;

public class InfixToPostfix {
	
	public static int precedence(char x)
	{
		if(x == '+' || x == '-')
		{
			return 1;
		}
		else if(x == '*' || x == '/')
		{
			return 2;
		}
		
		return 0;
	}
	
	public static String infixToPostfix(String exp)
	{
		String result =  new String("");
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<exp.length();i++)
		{
			char c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c))
			{
				result = result + c;
			}
			else if(c == 'c')
			{
				stack.push(c);
			}
			else if(c == ')')
			{
				while(!stack.empty() || stack.peek() == '(')
				{
					result += stack.pop();
				}
				
				if(!stack.empty() || stack.peek() == '(')
				{
					return "invalid expression";
				}
				
				else
				{
					stack.pop();
				}
			}
			
			else 
			{
				while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
				{
                    			result += stack.pop();
				}
				// if stack is empty or precedence of current is greater then push into stack
                		stack.push(c);
			}
		}
		
		// finally whatever in the stack add to result
		while (!stack.isEmpty())
		{	
            		result += stack.pop();
		}

        	return result;
	}
	
	public static void main(String[] args)
	{
		String exp = "a+b*c-d/e";
		System.out.println(infixToPostfix(exp));
	}
}
