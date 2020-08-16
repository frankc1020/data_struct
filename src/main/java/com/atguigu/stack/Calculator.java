package com.atguigu.stack;

/**
 * @author admin
 * @title: Calculator
 * @projectName base_thread
 * @description: 中缀表达式简单计算器
 * @date 2020/8/16 15:49
 */
public class Calculator {

    public static void main(String[] args) {
//        String expretion = "70+2*6-5";
        String expretion = "7*2*2-5+1-5+3-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //创建变量
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        int index = 0;//遍历表达式
        char ch = 0;
        String keepNum = "";
        while(true){
            ch = expretion.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){//判断是否是运算符，是
                if(!operStack.isEmpty()){//需要先判断运算符栈是否为空，不为空需要比较字符的优先级
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                         num1 = numStack.pop();
                         num2 = numStack.pop();
                         oper = operStack.pop();
                         res = operStack.cal(num1,num2,oper);
                         //计算完成之后，把计算之后的数值压入数栈中
                         numStack.push(res);
                         //把之前的运算符压入运算符栈中
                         operStack.push(ch);
                    }else{//优先级大于栈顶的运算符的优先级，则直接入栈
                        operStack.push(ch);
                    }
                }else{//为空，则直接把运算符压入栈中
                    operStack.push(ch);
                }
            }else{//不是则直接入数栈
                //这里需要注意，因为这里获取的是cahr字符，所以如需转换为数字，需要减去48 即0字符的ASCll
//                numStack.push(ch - 48);//如果是数字是多为的话将会出错
                keepNum += ch;
                if(index == expretion.length() - 1){//首先判断是不是最后一个字符，是则直接入数栈
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    //判断下一个字符是不是运算符，不是则继续拼接数字，是则入数栈
                    if(operStack.isOper(expretion.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";//然后将keepNum置空
                    }
                }

            }
            //让index + 1，判断是否扫描到最后
            index++;
            //这里之所以在等于的时候就判断最后，是应为index下标是从0开始
            if(index >= expretion.length()){
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while(true){
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字【结果】
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1,num2,oper);
            numStack.push(res);
        }

        System.out.printf("表达式%s=%d\n",expretion,numStack.peek());
        System.out.println(numStack.pop());
    }
}

//定义一个ArrayStack2表示栈，需要扩展
class ArrayStack2{
    private int maxSize;//栈空间
    private int[] stack;//使用数组模拟栈
    private int top = -1;//栈顶，默认初始化为-1，表示栈空

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    //取出栈顶元素
    public int peek(){
        return stack[top];
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 压栈
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈空间已满！！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈中没有任何数据，不能取出数据！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public  void printStack(){
        if(isEmpty()){
            System.out.println("栈中没有数据！");
            return;
        }
        for(int i =top;i>=0;i--){
            if(i % 5 == 0){
                System.out.println();
            }
            System.out.printf("stack[%d]=%d\t",i,stack[i]);
        }
    }

    //返回运算符优先级 目前仅判断 + - * /
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;//* 和 / 表示优先级大
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;//表示没找大该优先级 返回-1
        }
    }

    //判断是否是字符
    public boolean isOper(char oper){
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 /num1;
                break;
            default:
                break;
        }
        return res;
    }

}
