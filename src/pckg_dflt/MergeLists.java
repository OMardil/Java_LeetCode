package pckg_dflt;
public class MergeLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        
        while (l1 != null || l2 != null){
            if (l1 != null && l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            } else if (l2 != null){
                p.next = l2;
                l2 = l2.next;
            }       
            p = p.next;
        }
        
        return head.next;
    }
    
    public static void main(String[]args) {
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(4);
    	l1.next.next = new ListNode(8);
    	
    	ListNode l2 = new ListNode(2);
    	l2.next = new ListNode(3);
    	l2.next.next = new ListNode(9);    	
    	
    	ListNode l3 = mergeTwoLists(l1,l2);
    	ListNode iterator = l3;
    	
    	while (iterator != null) {
    		System.out.println(iterator.val);
    		iterator = iterator.next;
    	}
    }
}
