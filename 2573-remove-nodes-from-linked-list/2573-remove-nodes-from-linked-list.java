/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        curr = prev.next;
        prev.next=null;
        while (curr != null) {
            ListNode newtemp = curr.next;
            if (curr.val >= prev.val) {
                curr.next = prev;
                prev=curr;
            }
            curr = newtemp;

        }
        return prev;
    }
}