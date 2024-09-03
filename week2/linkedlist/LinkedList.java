package solutions.week2.linkedlist;

public class LinkedList {

    ListNode head, tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addLast(int val) {
        if (tail != null) {
            tail.next = new ListNode(val);
            tail = tail.next;
        } else head = tail = new ListNode(val);
    }

}
