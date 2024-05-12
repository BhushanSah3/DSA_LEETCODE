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
      ListNode temp=head;
      ListNode prev=head;
      int tnode=0;
      while(temp!=null){
        temp=temp.next;
        tnode++;
      }
      if (n == tnode) {
            head = head.next;
            return head;
        }
      int i=1;
      while(i!=(tnode-n)){
        prev=prev.next;
        i++;
    }
    prev.next=prev.next.next;
    return head;
    }
}