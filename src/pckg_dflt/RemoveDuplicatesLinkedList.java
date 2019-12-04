package pckg_dflt;

public class RemoveDuplicatesLinkedList {

	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);		
		ListNode three = new ListNode(2);	
		
		one.next = two;
		two.next = three;
		
		printList(one);
		ListNode out = deleteDuplicates(one);
		printList(out);
		
	}



	public static void printList(ListNode list) {
		while(list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
		System.out.println();
	}
	

	
	// declare iterator p
	// declare next with head.next;
	// 1. Housekeeping... head should be initialized
	// 2. while (p!= null)
	// 3. if (p == next)
	// 4. p.next = p.next.next;
    public static ListNode deleteDuplicates(ListNode head) {
    	
    	if (head == null) {
    		return null;
    	}

    	ListNode p = head;
    	ListNode dummy = new ListNode(-1);
    	ListNode previous = dummy;
    	

    	while (p != null) {
    		
    		int count = 0;
    		while (p.next != null && p.val == p.next.val) {
    			count++;
    			p = p.next;
    		}
    		
    		if (count == 0) {
    			previous.next = p;
    			previous = previous.next;
    		} else {
    			previous.next = null;
    		}
    		
    		p = p.next;
    		
    	}
    	
    	
    	return dummy.next;
    	        
    }
	
	

}
