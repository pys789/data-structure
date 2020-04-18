package cn.pys.list;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 * @author pengys
 *
 */
public class Num206 {

	/**
	 * 递归方法
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	/**
	 * 非递归方法(使用head和newHead两个节点遍历处理)
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		ListNode newNode = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newNode;
			newNode = head;
			head = tmp;
		}
		return newNode;
	}
}
