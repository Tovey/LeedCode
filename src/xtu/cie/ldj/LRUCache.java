package xtu.cie.ldj;

import java.util.HashMap;

public class LRUCache {
	private int capacity;
	private int currentSize;
	
	private ListNode head;		// Recently Used
	private ListNode tail;	
	private HashMap<Integer, ListNode> keyNodeMap;
	
	class ListNode{
		int key;
		int value;
		ListNode pre,next;
		ListNode(int k,int v){
			key = k;	value = v;
			pre = null;	next = null;
		}
	}
	
    public LRUCache(int capacity) {
    	if (capacity > 0) {
	        this.capacity = capacity;
	        this.currentSize = 0;
	        
	        this.keyNodeMap = new HashMap<Integer, ListNode>();
	        this.head = new ListNode(-1, -1);
	        this.tail = new ListNode(-1, -1);
	        this.head.next = this.tail;
	        this.tail.pre  = this.head;
    	}
    }
    
    public int get(int key) {
        int value = -1;
        
        if (this.keyNodeMap.containsKey(key)) {
			ListNode tempNode = this.keyNodeMap.get(key);
			value = tempNode.value;
			
			tempNode.pre.next = tempNode.next;
			tempNode.next.pre = tempNode.pre;
			
			tempNode.next = head.next;
			head.next.pre = tempNode;
			tempNode.pre = head;
			head.next = tempNode;
			
			this.keyNodeMap.put(key, tempNode);
		}
        
        return value;
    }
    
    public void set(int key, int value) {
    	if (this.keyNodeMap.containsKey(key)) {
    		ListNode tempNode = this.keyNodeMap.get(key);
    		tempNode.value = value;
    		
    		tempNode.pre.next = tempNode.next;
			tempNode.next.pre = tempNode.pre;
			
			tempNode.next = this.head.next;
			this.head.next.pre = tempNode;
			tempNode.pre = this.head;
			this.head.next = tempNode;
			
			this.keyNodeMap.put(key, tempNode);
			
    		return;
		}
    	
    	if (this.currentSize == this.capacity) {
			// delete least recently used
    		ListNode delNode = this.tail.pre;
    		delNode.pre.next = delNode.next;
    		delNode.next.pre = delNode.pre;
    		this.keyNodeMap.remove(delNode.key);
    		this.currentSize --;
		}
    	
    	ListNode addNode = new ListNode(key, value);
    	addNode.pre = this.head;
    	addNode.next = this.head.next;
    	this.head.next.pre = addNode;
    	this.head.next = addNode;
    	
    	this.keyNodeMap.put(key, addNode);
    	this.currentSize ++;
    }
    
    // 调试用，打印LRUCache中的元素
    public void printElem(){
    	ListNode tempNode = this.tail.pre;
    	
    	while (tempNode.key != -1) {
			System.out.print(tempNode.key + "  ");
    		
			tempNode = tempNode.pre;
		}
    	
    	System.out.println();
    }
}
