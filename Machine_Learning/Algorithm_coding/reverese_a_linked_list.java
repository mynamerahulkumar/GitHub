import java.util.*;

class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
    // Write your code here.
		/*
		1.Check if it has only one node
		2.Reverse first two node and make one pointer to third node
		3.In the end last node points to second last 
		4.First node point to null and head become last node.
		*/
		LinkedList t1=head;
		LinkedList t2=head.next;
		LinkedList t3=null;
		if (t1.next==null){
		return t1;
		}
		while(t2.next!=null){
			t3=t2.next;
			t2.next=t1;
			t1=t2;
			t2=t3;
		}
		t2.next=t1;
		head.next=null;
		head=t2;
    return head;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
