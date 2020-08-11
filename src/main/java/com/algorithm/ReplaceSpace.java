package com.algorithm;

/**
 * @author admin
 * @title: ReplaceSpace
 * @projectName base_java
 * @description: 替换空格
 * @date 2020/8/1 16:32
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("A C DF");
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(StringBuffer str){
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if(str.charAt(i) == ' '){
                //之所以需要额外增加两个空格，是因为原字符串中有一个空格，
                // 但是替换空格为%20是三个字符，所以还需要额外增加两个字符
                str.append("  ");//两个空格
            }
        }

        int P2 = str.length() - 1;
        while(P1>=0 && P2>P1){
            char c = str.charAt(P1--);
            if(c == ' '){
                str.setCharAt(P2--,'0');
                str.setCharAt(P2--,'2');
                str.setCharAt(P2--,'%');


            }else {
                str.setCharAt(P2--,c);
            }
        }

        return str.toString();
    }
}
