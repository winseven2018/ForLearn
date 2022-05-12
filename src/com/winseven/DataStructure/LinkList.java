package com.winseven.DataStructure;

import com.winseven.DataStructure.Struct.Node;

//单向链表
public class LinkList<T> {
        private int size;   //链表长度
        private final int MAX_SIZE = 20;    //链表最大长度
        private Node<T> head;   //链表的头结点
        private Node<T> last;   //链表的尾部节点

        public boolean add(T e){    //重载方法，向链表中添加新元素e，返回true则表示添加成功，失败则返回false
            if(size >= MAX_SIZE) return false;
            Node<T> newNode = new Node<T>(e,null);    //实例化新结点
            if(size == 0){  //如果是头结点，首末结点等于新增结点
                head = newNode;
                last = newNode;
            }else{
                //结点添加到尾部
                last.next = newNode;
                last = newNode;
            }
            size++;
            return true;
        }

        public boolean add (int index,T e){ //在指定的节点index序列前插入新的元素e。返回值为true表明添加成功，失败为false。注意，该方法无法添加在尾节点之后，但可以添加在头节点之前
            if(index>=size || index < 0 || size>MAX_SIZE-1) return false;
            Node<T> newNode = new Node<T>(e,null);
            //如果检索的是头部结点
            if(index == 0){
                newNode.next = head;
                head = newNode;
                size++;
                return true;
            }
            Node<T> node = head;    //索引处的结点
            Node<T> prenode = null; //索引处的上一个结点
            //检索指定索引位置
            for(int i = 0;i<index;i++){     //因为是链表只能从头部往后索引
                prenode = node;     //将检索过的结点放到上一个
                node = node.next;   //读取下一个结点信息
            }

            //链表更新
            prenode.next = newNode;
            newNode.next = node;
            size++;
            return true;
        }

        public boolean contains(Object e){  //查询链表中是否有当前对象，对象是否相等取决于equlas方法也是我们判断链表中是否含有目标元素e的重要判断条件。返回值为true表明有该对象，没有找到则为false。
            Node<T> start = head;       //从链表头部结点开始
            while (start != null){
                if(start.data.equals(e)) return true;   //equals方法找到指定对象时返回true
                start = start.next;             //没找到就将当前检索结点后移
            }
            return false;
        }

        public T get(int index){    //返回指定索引处信息
            if(index<0 || index>=size) return null;
            Node<T> node = head;        //从头部结点开始索引
            for(int i = 0;i<index;i++){ //一直循环直到指定的索引位置
                node = head.next;
            }
            return node.data;       //返回指定结点的数据
        }

        public T getHead(){     //返回头部结点
            return head == null?null:head.data;
        }

        public T getLast(){     //返回尾部结点
            return last == null?null:last.data;
        }

        public boolean remove(int index){   //删除指定结点
            if(index>=size || index<0) return false;
            Node<T> removeNode = head;//被删除的结点，初始化为头结点
            Node<T> preNode = null; //被删除结点的上一个结点
            //如果是头结点，将头结点后移
            if(index == 0){
                this.head = head.next;
                removeNode = null;
                size--;
                return true;
            }
            //移动到指定结点位置
            for(int i=0;i<index;i++){
                preNode = removeNode;
                removeNode = removeNode.next;
            }

            //如果删除的是尾部结点，就把尾部结点前移
            if (removeNode.next == null){
                last = preNode;
                preNode.next = null;
                removeNode = null;
            }else {     //如果删除的既不是头部也不是尾部
                preNode.next = removeNode.next;
                removeNode = null;
            }
            size--;
            return true;
        }
        public int getSize(){
            return this.size;
        }

        @Override
        public String  toString() {
            StringBuilder strs = new StringBuilder();
            Node<T> start = head;
            while (start!=null){
                strs.append(start.data).append(",");
                start = start.next;
            }
            return strs.toString();
        }
}
