package com.company;

import java.util.Map;
import java.util.Stack;

/**
 * Created by jason on 16/5/24.
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        // write your code here
        ReverseVowelsOfAString obj = new ReverseVowelsOfAString();
        System.out.println(obj.reverseVowels("leetcode"));
    }
    //this solution has O(n) time complexity, O(n) space. String can't modify.
    public String reverseVowels1(String s) {
        Stack<String> stack = new Stack();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (checkVowel(s.charAt(i))) {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (checkVowel(s.charAt(i))) {
                res = res + stack.pop();
            } else
                res = res + String.valueOf(s.charAt(i));
        }
        return res;
    }

    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int start = 0;
        int end = str.length - 1;
        while (start < end) {
            if (!checkVowel(str[start])) {
                start++;
                continue;
            }
            if (!checkVowel(str[end])) {
                end--;
                continue;
            }
            swap(str, start, end);
            start++;
            end--;
        }
        return String.valueOf(str);
    }

    private void swap(char[] str, int start, int end) {
        char tmp = str[start];
        str[start] = str[end];
        str[end] = tmp;
    }


    private boolean checkVowel(char s) {
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' || s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U') {
            return true;
        }
        return false;
    }

}
