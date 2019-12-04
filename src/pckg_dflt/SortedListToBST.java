package pckg_dflt;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {

	public static void main(String[] args) {
		
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);	
		list.next.next.next.next.next = new ListNode(6);	
		list.next.next.next.next.next.next = new ListNode(7);		
		list.next.next.next.next.next.next.next = new ListNode(8);	
		
		TreeNode tn = new SortedListToBST().sortedListToBST(list);
		printTree(tn);

	}

	public TreeNode sortedListToBST(ListNode head) {
	
		List<Integer> list = new ArrayList<>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		
		return rebuildTree(list, 0,list.size()-1);
	
	}
	
	public TreeNode rebuildTree(List<Integer> list, int begin, int end) {
		
		if (begin > end) {
			return null;
		}
		
		int mid = (begin + end) /2;
		TreeNode head = new TreeNode(list.get(mid));
		
		head.left  = rebuildTree(list, begin, mid-1);
		head.right = rebuildTree(list, mid+1, end);		
		
		return head;
	}
	
	public static void printTree(TreeNode t1) {
		if(t1 == null)
			return;
		
		System.out.print(t1.val + " ");
		
		
		printTree(t1.left);
		printTree(t1.right);		
		
	}
}	


