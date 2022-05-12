package com.winseven.Algorithm;

import java.util.Scanner;

/**
 * 一个是数列求和 条件是 第一个数是n 后面的项是前一项的平方根 求前m项数和
 * 测试数据是:81(n) 4(m) 输出:94.73
 *                2(n) 2(m)   输出:3.41
 * 输出保留两位小数
 *
 * 题解思路：
 * 使用递归求解即可
 */
public class GetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入第一个数n");
        double n = scanner.nextDouble();
        System.out.println("输入第二个数m");
        double m = scanner.nextDouble();
        System.out.printf("结果为:"+"%.2f",new GetSum().getSum(n,m));
    }
    public double getSum(double n,double m){
        if(m==1){
            return n;
        }
        return n + getSum(Math.sqrt(n),--m);
    }
}
