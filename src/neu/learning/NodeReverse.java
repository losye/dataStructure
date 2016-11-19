package neu.learning;

public class NodeReverse {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		printNode(node);
		printNode(reverseNode(node));
	}
	
	
	public static ListNode reverseNode(ListNode head){
		 	if(head==null){
		 		return null;
		 	}
		 	ListNode ReverseHead = null;
		 	ListNode node = head;
		 	ListNode pre = null;
		 	while(node!=null){
		 		ListNode next = node.next;
		 		if(next==null){
		 			ReverseHead = node;
		 		}
		 		node.next = pre;
		 		pre = node;
		 		node = next;
		 	}
		 	return ReverseHead;
	}
	public static void printNode(ListNode node){
		while(node!=null){
			System.out.print(node.val+ " ");
			node = node.next;
		}
		System.out.println();
	}
}

class ListNode{
	ListNode(int val){
		this.val = val;
	}
	int val;
	ListNode next;
	public int getVal(){
		return val;
	}
}
