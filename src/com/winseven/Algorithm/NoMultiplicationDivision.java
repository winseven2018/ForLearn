package com.winseven.Algorithm;

import java.util.Scanner;
/**
 * 题目：给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'。
 *
 * 示例 1：
 *
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xoh6Oh
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：
 * 因为除法中，除数与被除数的关系是在乘法的基础上实现的，比如4/2之所以等于2是因为2*2=4
 * 而乘法的结果则为n个a相加获得的数
 * 由此便得知只需要获知被除数需要除数相加多少次就能够得到一个等于或大于被除数的数。
*/

public class NoMultiplicationDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入被除数：");
        int a = scanner.nextInt();
        System.out.println("输入除数：");
        int b = scanner.nextInt();
        NoMultiplicationDivision n = new NoMultiplicationDivision();
        System.out.println("结果为："+n.divide(a,b));
    }
    public int divide(int a, int b) {
        boolean res = false;            //正负符号标识符
        int result = 0;             //初始化结果数值
        if(a==Integer.MIN_VALUE && b==-1){      //因为使用的是int类型的数值，当输入的数为int类型的最小值时直接返回最大值即可
            return Integer.MAX_VALUE;
        }
        res = (a ^ b) < 0;              //正负数相除结果为负数
        long c = Math.abs((long) a);    //将除数与被除数转化为正数
        long d = Math.abs((long) b);
        long temp = d;          //储存原始数值
        if(b == 0 && a != 0){return 0;}
        if(a == 0) {return 0;}
        while (d<=c){
            d+=temp;            //不断与自身相加
            result++;           //结果++
        }
        if(res){            //如果res为为true则表示结果为负数
            return -result;
        }
        return result;
    }
}
