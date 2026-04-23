/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        ListNode previous = slow.next = null;
        while(head2 != null) {
            ListNode temp = head2.next;
            head2.next = previous;
            previous = head2;
            head2 = temp;
        }

        ListNode first = head;
        ListNode second = previous;
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next; 
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
