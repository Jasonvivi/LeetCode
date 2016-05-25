package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jason on 16/5/25.
 */
public class BasicCalculatorII {
    Map<Character,Integer> symMap;
    public int calculate(String s) {
        if(s.length() == 0)
            return 0;
        initSymMap();
        char[] expression = s.toCharArray();
        Stack<String> opStack = new Stack<String>();
        Stack<Character> symStack = new Stack<Character>();
        for(int i = 0; i < expression.length; i++)
        {
            if(expression[i] == ' ')
                continue;
            else if(symMap.containsKey(expression[i]))
            {
                if(symStack.empty())
                    symStack.push(expression[i]);
                else
                {
                    if (symMap.get(symStack.peek()) < symMap.get(expression[i]))
                    {
                        symStack.push(expression[i]);
                    }
                    else
                    {
                        while(!symStack.empty() && symMap.get(symStack.peek()) >= symMap.get(expression[i]))
                        {
                            int op2 = Integer.parseInt(opStack.pop());
                            int op1 = Integer.parseInt(opStack.pop());
                            char sym = symStack.pop();
                            int result = calculate(op1, op2, sym);
                            opStack.push(String.valueOf(result));
                        }
                        symStack.push(expression[i]);
                    }
                }
            }
            else
            {
                int operator = 0;
                int index = i;
                while(index < expression.length && !symMap.containsKey(expression[index]) && expression[index] != ' ')
                {
                    operator = 10 * operator + Integer.parseInt(String.valueOf(expression[index]));
                    index ++;
                }
                opStack.push(String.valueOf(operator));
                if(index != expression.length -1)
                    i = index -1;
                else
                    break;
            }
        }
        while(!symStack.empty())
        {
            int op2 = Integer.parseInt(String.valueOf(opStack.pop()));
            int op1 = Integer.parseInt(String.valueOf(opStack.pop()));
            char sym = symStack.pop();
            int result = calculate(op1, op2, sym);
            opStack.push(String.valueOf(result));
        }
        return Integer.parseInt(String.valueOf(opStack.pop()));
    }
    private void initSymMap()
    {
        symMap = new HashMap<Character,Integer>();
        symMap.put('+',0);
        symMap.put('-',0);
        symMap.put('*',1);
        symMap.put('/',1);
    }
    private int calculate(int op1, int op2, char sym)
    {
        switch (sym) {
            case '+': return op1 + op2;
            case '-': return op1 - op2;
            case '*': return op1 * op2;
            case '/': return op1 / op2;
        }
        return 0;
    }
    public static void main(String[] args) {
        // write your code here
        BasicCalculatorII basicCalculatorII  = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate("1337"));
    }
}
