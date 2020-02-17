package com.general.geeks.queandstack;

import java.util.Stack;

/**
 * 
 * Return the result of evaluating a given boolean expression, represented as a string.

An expression can either be:

"t", evaluating to True;
"f", evaluating to False;
"!(expr)", evaluating to the logical NOT of the inner expression expr;
"&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
"|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...
 

Example 1:

Input: expression = "!(f)"
Output: true
Example 2:

Input: expression = "|(f,t)"
Output: true
Example 3:

Input: expression = "&(t,f)"
Output: false
Example 4:

Input: expression = "|(&(t,f,t),!(t))"
Output: false
 

Constraints:

1 <= expression.length <= 20000
expression[i] consists of characters in {'(', ')', '&', '|', '!', 't', 'f', ','}.
expression is a valid expression representing a boolean, as given in the description.
 * 
 * @author skadavath
 *
 */
public class ParsingABooleanExpression {
	
	public static void main(String[] args) {
		
		System.out.println(new ParsingABooleanExpression().parseBoolExpr("|(&(t,f,t),!(t))"));
		
	}

	public boolean parseBoolExpr(String expression) {
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : expression.toCharArray()) {
			if(c!=',' && c!=')') 
				stack.push(c);
			else if(c==')'){
				
				char and='t',or='f',not=0;
				while(stack.peek()!='(') {
					
					char d = stack.pop();
					if(d=='f')and='f';
					if(d=='t')or='t';
					not = d=='f'?'t':'f';
					
				}
				
				//popout the '(
				stack.pop();
				
				char op = stack.pop();
				
				if(op=='&')
					stack.push(and);
				else if(op=='|')
					stack.push(or);
				else
					stack.push(not);
			}
			
			
		}
		
		return stack.pop()=='t';

	}

}
