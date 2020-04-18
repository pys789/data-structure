package cn.pys.list;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 
 * @author pengys
 *
 */
public class Num237 {
	
	public void deleteNode(ListNode node) {
		node.val=node.next.val;
		node.next=node.next.next;
	}

}
