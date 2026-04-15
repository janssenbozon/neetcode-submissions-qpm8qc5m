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
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }

        int indexToRemove = size - n;
        int i = 0;
        cur = head;
        ListNode prev = null;
        while(i < indexToRemove) {
            i++;
            prev = cur;
            cur = cur.next;
        }

        // edge: only element
        if(cur.next == null && prev == null) {
            return null;
        }

        // edge: start of list 
        if(prev == null && cur != null) {
            return cur.next;
        }

        // middle of list
        if(prev != null){
            prev.next = cur.next;
        }

        return head;
    }
}
