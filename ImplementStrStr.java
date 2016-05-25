package com.company;

/**
 * Created by jason on 16/5/25.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        int hayLength = haystack.length();
        int needleLength = needle.length();
        int hayIndex = 0;
        int needleIndex = 0;
        for(;hayIndex <= hayLength - needleLength;hayIndex++)
        {
            needleIndex = 0;
            while(haystack.charAt(hayIndex + needleIndex) == needle.charAt(needleIndex))
            {
                needleIndex ++;
                if(needleIndex == needleLength)
                    return hayIndex;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // write your code here
        ImplementStrStr implementStrStr  = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("abc",""));
    }
}
