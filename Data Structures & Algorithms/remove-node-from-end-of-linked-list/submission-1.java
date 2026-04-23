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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode head1 = head;
        int count = 0;
        while(head1 != null) {
            count++;
            head1 = head1.next;
        }

        if(n == count) {
            head = head.next;
            return head;
        }
        int x = count - n;

        ListNode head2 = head;
        ListNode prev = null;
        while(head2 != null) {
            if(x == 0) {
                prev.next = head2.next;
                break;
            }
            x--;
            prev = head2;
            head2 = head2.next;
        }

        return head;
    }
}
