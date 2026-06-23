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
    public int pairSum(ListNode head) {
       ArrayList<Integer> list = new ArrayList<>();
       ListNode curr = head;
      while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        int maxSum = 0;

        while (left < right) {
            maxSum = Math.max(maxSum, list.get(left) + list.get(right));
            left++;
            right--;
        }

        return maxSum;
    }
}