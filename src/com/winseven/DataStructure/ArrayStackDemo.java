package com.winseven.DataStructure;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args){
        //测试类
        //先创建一个ArrayStack对象，表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:添加数据到栈");
            System.out.println("pop:取出栈数据");
            System.out.println("输入选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}
class ArrayStack{
    private int maxSize;    //栈的大小
    private int[] stack;    //数组，利用数组模拟栈
    private int top = -1;   //top表示栈顶

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int [this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈-push
    public void push(int value){
        //先判断栈是否满了
        if(isFull()){
            System.out.println("栈满了");
        }
        top++;
        stack[top]=value;
    }

    //出栈-pop 返回栈顶数据
    public int pop(){
        //先判断栈是否空
        if(isEmpty()){
            throw new RuntimeException("栈空了");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，遍历时需要从栈顶开始显示
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        //从栈顶开始走
        for (int i = top;i>=0;i--){
            System.out.printf("stack[%d]=[%d]\n",i,stack[i]);
        }
    }
}
