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
        ArrayList<Integer> ls = new ArrayList<>();

        if (head == null)
            return;

        ListNode temp = head;
        while (temp != null) {
            ls.add(temp.val);
            temp = temp.next;

        }
        int i = 0;
        int j = ls.size() - 1;
        temp = head;

        while (temp != null) {
            if (i <= j) {
                temp.val = ls.get(i);
                i++;
                temp = temp.next;
            }
            if (temp != null && i <= j) {
                temp.val = ls.get(j);
                j--;
                temp = temp.next;
            }
        }

    }
}