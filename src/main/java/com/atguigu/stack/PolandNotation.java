package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author admin
 * @title: PolandNotation
 * @projectName base_thread
 * @description: 逆波兰表达式即后缀表达式
 * @date 2020/8/17 09:06
 *
 * 使用逆波兰表达式进行计算
 */
public class PolandNotation {
    public static void main(String[] args) {
        
        String expression = "4*5-8+60+8/2";
        List<String> strList = toInfixExpresseion(expression);
        System.out.println(strList);


        //先定义逆波兰表达式
        //(3+4)*5-6 ====>   3 4 + 5 * 6 - ===>29
        //(30+4)*5-6 ====>   30 4 + 5 * 6 - ===>164
        //4*5-8+60+8/2 ====>   4 5 * 8 - 60 + 8 2 / + ===>76
//        String suffixExpression = "3 4 + 5 * 6 -";
//        String suffixExpression = "30 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //1.先将"3 4 + 5 * 6 -"==>放到ArrayList中
        //2.将ArrayList 传递给一个方法，遍历ArrayList，配合栈，完后计算
        List<String> list = getListString(suffixExpression);
        int res = calculate(list);
        System.out.println("计算结果："+res);

    }
    //将中缀表达式转成对应的List
    public static List<String> toInfixExpresseion(String expression){
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0;
        char ch = 0;
        String s="";
        do{

            if(((ch=expression.charAt(i)) < 48) || ((ch=expression.charAt(i)) > 57)){
                ls.add(String.valueOf(ch));
                i++;
            }else{
                s="";
                while(i<expression.length() && ((ch=expression.charAt(i))) >= 48 && ((ch=expression.charAt(i)) <= 57)){
                    s += ch;
                    i++;
                }
                ls.add(s);
            }
        }while(i<expression.length());
        return ls;
    }

    public static List<String> getListString(String suffixExpression){
        List<String> list = new ArrayList<>();
        String[] split = suffixExpression.split(" ");
        for(String s : split){
            list.add(s);
        }
        return list;
    }
    public static int calculate(List<String> list){
        Stack<String> stack  = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        for(String item : list){
            if(item.matches("\\d+")){//使用正则表达式判断哪多位数
                stack.push(item);
            }else{
                if(item.equals("+")){
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    res  = num1 + num2;
                }else if(item.equals("-")){
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    res  = num2 - num1;
                }else if(item.equals("*")){
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    res  = num1 * num2;
                }else if(item.equals("/")){
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    res  = num2 / num1;
                }else{
                    System.out.println("运算符异常！！！");
                }

                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
