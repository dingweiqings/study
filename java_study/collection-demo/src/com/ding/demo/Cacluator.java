package com.ding.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Cacluator {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner  scanner=new Scanner(new FileInputStream(new File("C:\\my-study\\study\\java_study\\input.txt")));
        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            System.out.println("s:"+s+"="+calculate(s));
        }
    }
    public static int calculate(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return 0;
        if(s.length()==2){
            return Integer.valueOf(s);
        }
        Stack<Integer> nums = new Stack<>();   //数字栈
        Stack<Character> ops = new Stack<>();   //操作符栈
        boolean findNumInCurBracket=true;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                continue;
            }
            if (Character.isDigit(c)) {			//字符串转化数字
                num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);			//数字直接存入栈中
                num = 0;
                if(!ops.isEmpty() && ops.peek()=='('){
                    findNumInCurBracket=true;
                }
            } else if (c == '(') {		//左括号直接存入
                ops.push(c);
                findNumInCurBracket=false;
            } else if (c == ')') {		//遇到右括号
                while (ops.peek() != '('){		//对栈顶两数字进行运算
                       doCalc(ops,nums);
                }
                ops.pop();
                findNumInCurBracket=true;
            } else if (c == '+'  || c == '*' || c == '/') {   //遇到操作符
                while (calcStackFirst(ops,c)){		//对栈顶两数字进行运算
                    doCalc(ops,nums);
                }
                ops.push(c);
            }else  if(c=='-'){
                if( nums.isEmpty() || !findNumInCurBracket ){
                    ops.push('n');
                }else {
                    while (calcStackFirst(ops,c)){		//对栈顶两数字进行运算
                        doCalc(ops,nums);
                    }
                    ops.push('-');
                }

            }

        }
        while (!ops.isEmpty()) {    //取出栈顶的数字进行操作
            doCalc(ops,nums);
        }
        return nums.pop();
    }

    private static boolean calcStackFirst(Stack<Character> ops,char c){
        return !ops.isEmpty() && precedence(c, ops.peek());
    }
    private static void doCalc(Stack<Character> ops,Stack<Integer> nums){
        if(ops.peek()=='n'){
            nums.push(operation(ops.pop(), nums.pop(), 0));
        }else{
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
    }
    private static int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;   //加法
            case '-': return a - b;	  //减法
            case '*': return a * b;   //乘法
            case '/': return a / b;   //除法
            case 'n': return b*-1;
        }
        return 0;
    }
    private static boolean precedence(char op1, char op2) {
        if(op2 =='n'){
            return true;
        }
        if (op2 == '(' || op2 == ')'){
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        }
        return true;
    }
}
