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
        if (head == null || head.next == null) return;
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }

        int mid = (size + 1) / 2;
        int i = 0;
        ListNode prevToMid = null;
        cur = head;
        while(i < mid) {
            i++;
            prevToMid = cur;
            cur = cur.next;
        }
        
        if (prevToMid != null) prevToMid.next = null;

        ListNode head2 = reverseLinkedList(cur);
        
        mergeLinkedList(head, head2);
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode mergeLinkedList(ListNode head1, ListNode head2) {
        ListNode newList = head1;
        while(head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            if (temp1 == null) break;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }

        return newList;
    }
}