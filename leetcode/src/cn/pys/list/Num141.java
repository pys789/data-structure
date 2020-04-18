package cn.pys.list;

/**
 * 通过快慢指针查找链表是否有环
 * @author pengys
 *
 */
public class Num141 {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

}
