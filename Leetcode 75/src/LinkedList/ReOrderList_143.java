package LinkedList;

import java.util.List;

public class ReOrderList_143 {
    public void reorderList(ListNode head) {
        ListNode mid=findMid(head);
        ListNode midNext=mid.next;
        mid.next=null;
        ListNode end=reverse(midNext);
        ListNode curr1=head, curr2=end;
        while(curr1 != null && curr2 != null){
            ListNode next1=curr1.next;
            ListNode next2 = curr2.next;
            curr1.next=curr2;
            curr2.next=next1;
            curr1=next1;
            curr2=next2;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode curr=head, prev=null;

        while(curr != null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }

    private ListNode findMid(ListNode head) {
        ListNode slow=head, fast= head;

        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    private  class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
