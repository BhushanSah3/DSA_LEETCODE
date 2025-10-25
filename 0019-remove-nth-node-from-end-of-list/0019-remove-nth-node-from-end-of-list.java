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
        int nodecount=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            nodecount++;

        }
        if(nodecount==1){
            return null;
        }  if (n == nodecount) {
            return head.next;
        }

        nodecount=nodecount-n-1;
        ListNode temp1=head;

        while(temp1!=null && nodecount!=0){
            temp1=temp1.next;
            nodecount--;
        }
        
        temp1.next=temp1.next.next;

        return head;
        
    }
}