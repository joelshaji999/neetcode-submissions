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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode prev = new ListNode(0);
        ListNode head = prev;

        int carryover = 0;
        int sum = 0;

        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carryover;
            
            
                int digit = sum % 10;
                ListNode node = new ListNode(digit, null);
                prev.next = node;
                prev = node;

                carryover = sum / 10;
            

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            sum = l1.val + carryover;

            if(sum != 0) {
                int digit = sum % 10;
                ListNode node = new ListNode(digit, null);
                prev.next = node;
                prev = node;

                carryover = sum / 10;
            }

            l1 = l1.next;
        }

        while(l2 != null) {
            sum = l2.val + carryover;

            if(sum != 0) {
                int digit = sum % 10;
                ListNode node = new ListNode(digit, null);
                prev.next = node;
                prev = node;

                carryover = sum / 10;
            }

            l2 = l2.next;
        }

        if(carryover > 0) {
            ListNode node = new ListNode(carryover, null);
            prev.next = node;
                prev = node;
        }

        return head.next;
    }
}
