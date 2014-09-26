package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache01 {
	private HashMap<Integer, Integer> cacheMap;
	private ArrayList<Integer> cacheUsedList;
	private int capacity;
	
    public LRUCache01(int capacity) {
        this.cacheMap = new HashMap<Integer, Integer>();
        this.cacheUsedList = new ArrayList<Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int value = -1;
    	if (this.cacheMap.containsKey(key)) {
			value = this.cacheMap.get(key);
			this.cacheUsedList.remove(new Integer(key));
			this.cacheUsedList.add(key);
		}
        return value;
    }
    
    public void set(int key, int value) {
        if (!this.cacheMap.containsKey(key)) {
			if (this.capacity == this.cacheUsedList.size()) {
				this.cacheMap.remove(this.cacheUsedList.get(0));
				this.cacheUsedList.remove(0);
			}
			this.cacheUsedList.add(key);
			this.cacheMap.put(key, value);
		}else {
			this.cacheMap.remove(new Integer(key));
			this.cacheMap.put(key, value);
			this.cacheUsedList.remove(new Integer(key));
			this.cacheUsedList.add(key);
		}
    }
}
