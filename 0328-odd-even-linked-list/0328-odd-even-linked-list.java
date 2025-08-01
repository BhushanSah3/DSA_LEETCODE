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
    public ListNode oddEvenList(ListNode head) {
         if (head == null || head.next == null || head.next.next == null) {   // No need to rearrange if less than three nodes
            return head;
        }
    
        ListNode oddhead = head;
        ListNode evenhead = head.next;
        ListNode odd = oddhead;
        ListNode even = evenhead;
    
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
    
        odd.next = evenhead; // Connect odd list with even list
        return head;
    }
}