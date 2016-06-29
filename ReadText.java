package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by jason on 16/6/16.
 */
public class ReadText {
    public static void readTxtFile(String filePath1,String filePath2){
        try {
            int index = 0;
            String str1 = "";
            String str2 = "";
            String encoding="GBK";
            File file=new File(filePath1);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] result = lineTxt.split(" ");
                    if(result[2].charAt(0) == 'h')
                    {
                        str1 = str1 + "1";
                    }
                    else
                        str1 = str1 + "0";
                }
//                System.out.println(str1);

                file=new File(filePath2);
                read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                bufferedReader = new BufferedReader(read);
                lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] result = lineTxt.split(",");
                    if(result[1].charAt(0) == 'h')
                    {
                        str2 = str2 + "1";
                    }
                    else
                        str2 = str2 + "0";
                }
                read.close();
                for(int i = 0; i < str1.length();i++)
                {
                    if(str1.charAt(i) != str2.charAt(i))
                    {
                        System.out.println(i);
                    }
                }
                System.out.println("finish");

            }else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    public static void main(String argv[]){
//        String filePath1 = "/Users/jason/Downloads/csimref.txt";
//        String filePath2 =  "/Users/jason/Downloads/csim.txt";
////      "res/";
//        readTxtFile(filePath1,filePath2);
        int x = Integer.MAX_VALUE;

    }
}
