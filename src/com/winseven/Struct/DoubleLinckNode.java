package com.winseven.Struct;

public class DoubleLinckNode<T> {
    // 数据域
    public T data; // 用于存储数据的区域
    // 结点域
    public DoubleLinckNode<T> next; // 指向下一块数据区域的指针
    public DoubleLinckNode<T> pre; // 指向上一块数据区域的指针

    public DoubleLinckNode(T data, DoubleLinckNode<T> next, DoubleLinckNode<T> pre) { // 构造方法，用于初始化数据区域以及指针
        this.data = data;
        this.next = next;
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "DoubleLinckNode [data=" + data + ", next=" + next + ", pre=" + pre + "]";
    }

}
