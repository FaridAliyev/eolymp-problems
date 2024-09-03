package solutions.week2.linkedlist;

import java.util.Scanner;

public class LinkedListProblems {
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        LinkedList p = new LinkedList();
        int n = con.nextInt();
        for (int i = 0; i < n; i++) {
            int x = con.nextInt();
            p.addLast(x);
        }
        System.out.println(middleElement(p.head).val);
    }

    public static void printReverse(ListNode head) {
        if (head == null) return;
        printReverse(head.next);
        System.out.print(head.val + " ");
    }

    public static int hasCycle(ListNode head) {
        if (head == null) return 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return 1;
            }
        }
        return 0;
    }

    public static ListNode middleElement(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode intersection(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        int distance1 = 0;
        int distance2 = 0;
        while (node1.next != null) {
            node1 = node1.next;
            distance1++;
        }
        while (node2.next != null) {
            node2 = node2.next;
            distance2++;
        }
        if (distance1 > distance2) {
            int diff = distance1 - distance2;
            for (int i = 0; i < diff; i++) {
                l1 = l1.next;
            }
        } else {
            int diff = distance2 - distance1;
            for (int i = 0; i < diff; i++) {
                l2 = l2.next;
            }
        }
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        while (l1 != null) {
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }

        return res.next;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode q = head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (q != slow) {
                    q = q.next;
                    slow = slow.next;
                }
                return q;
            }
        }
        return null;
    }

    public static ListNode removeCycle(ListNode head) {
        if (head == null) return head;
        ListNode q = head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (q.next != slow.next) {
                    q = q.next;
                    slow = slow.next;
                }
                slow.next = null;
                break;
            }
        }
        return head;
    }

    public static int CycleLength(ListNode head) {
        if (head == null) return -1;
        ListNode q = head;
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (q != slow) {
                    q = q.next;
                    slow = slow.next;
                }
                while (slow.next != q) {
                    count++;
                    slow = slow.next;
                }
                return count;
            }
        }
        return -1;
    }
}
