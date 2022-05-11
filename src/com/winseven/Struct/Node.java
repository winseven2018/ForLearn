package com.winseven.Struct;

public class Node<T> {
    //数据域
    public T data;      //用于存储数据的区域
    //结点域
    public Node<T> next;    //指向下一块数据区域的指针
    public Node(T data, Node<T> next){      //构造方法，用于初始化数据区域以及指针
        this.data = data;
        this.next = next;
    }
}
