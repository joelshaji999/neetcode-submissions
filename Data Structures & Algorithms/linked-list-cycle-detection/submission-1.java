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
    public boolean hasCycle(ListNode head) {
        ListNode head1 = head;
        ListNode head2 = head;

        while(head1 != null && head1.next != null) {
            head1 = head1.next.next;
            head2 = head2.next;
            if(head1 == head2) {
                return true;
            }
        }

        return false;
    }
}
