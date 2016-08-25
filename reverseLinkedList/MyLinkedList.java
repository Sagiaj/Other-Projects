package com.company;

/**
 * Created by Sagi on 23/08/2016.
 */
public class MyLinkedList {

    Node head;
    public void add(int num){
        if(head==null){
            head = new Node();
            head.data = num;
        }
        else {
            Node temp = new Node();
            temp.next=head;
            temp.data=num;
            head=temp;
        }
    }
}
