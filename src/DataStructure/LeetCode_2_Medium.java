package DataStructure;

class Leet2 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode curR = result;
        int carry = 0;
        while (cur1 != null || cur2 != null || carry > 0) {
            int temp1 = (cur1 == null) ? 0 : cur1.val;
            int temp2 = (cur2 == null) ? 0 : cur2.val;
            int dsum = temp1 + temp2 + carry;
            carry = dsum / 10;
            curR.next = new ListNode(dsum % 10);
            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next;
            curR = curR.next;
        }
        if(carry > 0){
            curR.next = new ListNode(carry);
        }
        return result.next;
    }
}