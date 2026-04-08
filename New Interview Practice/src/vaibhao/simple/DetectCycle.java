package vaibhao.simple;

class ListNode {
	int data;
	ListNode next;

	ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}

class DetectCycle {
	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = head; // cycle

		ListNode slow = head;
		ListNode fast = head;

		boolean cycle = false;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				cycle = true;
				break;
			}
		}

		System.out.println(cycle); // true
	}
}
