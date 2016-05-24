package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 16/5/24.
 */
public class StringSolution {
    private char[][] dic = {{'a','b','c'},{'d','e','f'},{ 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }};
    public List<String> letterCombinations(String digits) {
        ArrayList<String> resList = new ArrayList<String>();
        search(resList,digits,0,"");
        return resList;
    }
    public void search(List resList, String digits, int index, String str)
    {
        if(index == digits.length())
        {
            resList.add(str);
            return;
        }
        int num = digits.charAt(index) - '2';
        for(int i = 0; i < dic[num].length;i++)
        {
            search(resList,digits,index+1,str+""+dic[num][i]);
        }
    }
    public static void main(String[] args) {
        // write your code here
        StringSolution solution = new StringSolution();
        System.out.println(solution.letterCombinations("23"));
    }
}





