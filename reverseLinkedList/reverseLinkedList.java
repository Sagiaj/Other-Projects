package com.company;

public class reverseLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        Node node = list.head;

        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }

        reverseLinked(list);
        node = list.head;

        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }

    public static void reverseLinked(MyLinkedList list){
        Node cur = new Node();
        Node saved = new Node();
        Node last = new Node();
        saved=null;
        cur=last=list.head;

        while(cur!=null){
            last=cur;
            cur=cur.next;
            last.next=saved;
            saved=last;

        }
        list.head = last;
    }
}
