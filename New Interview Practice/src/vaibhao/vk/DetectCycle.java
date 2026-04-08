package vaibhao.vk;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class DetectCycle {

	public static boolean hasCycle(ListNode head) {

		// Empty list check
		if (head == null)
			return false;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next; // 1 step
			fast = fast.next.next; // 2 steps

			if (slow == fast) {
				return true; // cycle found
			}
		}

		return false; // no cycle
	}

	public static void main(String[] args) {

		// Create nodes
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		// Create cycle
		head.next.next.next.next = head.next;

		System.out.println(hasCycle(head)); // true
	}
}
