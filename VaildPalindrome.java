package com.company;

/**
 * Created by jason on 16/6/1.
 */
public class VaildPalindrome {
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while(low < high)
        {
            if(!(Character.isLetter(s.charAt(low)) || Character.isDigit(s.charAt(low))))
            {
                low++;
                continue;
            }
            if(!(Character.isLetter(s.charAt(high)) || Character.isDigit(s.charAt(high))))
            {
                high--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public static void main(String[] args) {
        // write your code here
        VaildPalindrome vaildPalindrome = new VaildPalindrome();
        System.out.println(vaildPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
