package com.company;

/**
 * Created by jason on 16/5/26.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length;i++)
            for(int j = 0; j < board[0].length; j++)
            {
                if(helper(board, word, i, j, 0))
                    return true;
            }
        return false;
    }
    private boolean helper(char[][] board, String word, int x, int y, int step)
    {
        if(step == word.length())
            return true;
        if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1)
            return false;
        if((board[x][y]-word.charAt(step))!=0)
            return false;
        char tmp = board[x][y];
        board[x][y] = '#';
        boolean res = helper(board,word,x + 1,y,step+1) || helper(board,word,x - 1,y,step+1) || helper(board,word,x,y + 1,step+1) || helper(board,word,x,y - 1,step+1);
        board[x][y] = tmp;
        return res;
    }
    public static void main(String[] args) {
        // write your code here
        char board[][]={{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
       WordSearch wordsearch = new WordSearch();
        System.out.println(wordsearch.exist(board,"bbabab"));
    }
}
