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

        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)*4)-5 => 转成 1 2 3 + 4 * + 5 -
        //2. 因为直接对str进行操作，不方便，因此先将 "1+((2+3)*4)-5" => 中缀的表达式对应的List
        //即"1+((2+3)*4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
        // 即 ArrayList[1,+,(,(,2,+,3,),*,4,),-,5] => ArrayList [1,2,3,+,4,*,+,5,-]

        String expression1 = "1+((2+3)*4)-5";
        String expression2 = "11+((22+33)*44)-55";
        List<String> strList1 = toInfixExpresseion(expression2);
        System.out.println(strList1);
        List<String> list = parseSuffixExpressionList(strList1);
        System.out.println("中缀表达式转换后缀表达式："+list);//[1, 2, 3, +, 4, *, +, 5, -]

        System.out.println("expression2:"+ calculate(list));

       /* String expression = "4*5-8+60+8/2";
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
        System.out.println("计算结果："+res);*/

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

    public static List<String> parseSuffixExpressionList(List<String> list){
        Stack<String> s1 = new Stack<>();

        List<String> s2 = new ArrayList<>();

        for(String item : list){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号"）"，则依次弹出s1栈顶的运算符，并压入s2，直到压入s2，直到遇到右括号为止
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将"（"弹出s1栈移除左括号
            }else{
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转到（4.1）与s1中新的栈顶运算符相比较
                while(s1.size() > 0 &&  Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //将item压入栈
                s1.push(item);
            }
        }

        while (s1.size() > 0){
            s2.add(s1.pop());
        }

        return s2;
    }

}

class  Operation{
    private static  final int ADD = 1;
    private static  final int SUB = 1;
    private static  final int MUL = 2;
    private static  final int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("没有对应的运算符");
                break;
        }
        return result;
    }
}
