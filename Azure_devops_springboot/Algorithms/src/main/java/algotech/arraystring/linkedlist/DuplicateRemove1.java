package algotech.arraystring.linkedlist;

import java.util.LinkedList;
import java.util.List;

class ListNode{
    int value;
    ListNode next;
    ListNode(int value){
        this.value=value;
    }
    ListNode(int value, ListNode next){
        this.value=value;
        this.next=next;
    }

}
public class DuplicateRemove1 {
    public static void main(String[] args) {
       ListNode listNode=new ListNode(20);
        ListNode listNode2=new ListNode(30,listNode);
        ListNode listNode3=new ListNode(40,listNode2);
        ListNode listNode4=new ListNode(30,listNode3);
        ListNode listNode5=new ListNode(60,listNode4);
        ListNode listNode6=new ListNode(40,listNode5);
       ListNode head=listNode;
       while (head!=null){
           System.out.println(head.value);
           head=head.next;
       }
    }
}
