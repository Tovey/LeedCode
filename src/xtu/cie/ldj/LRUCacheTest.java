package xtu.cie.ldj;

public class LRUCacheTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruCache = new LRUCache(5);
		lruCache.set(1, 10);
		lruCache.set(2, 10);
		lruCache.set(3, 10);
		lruCache.set(4, 10);
		lruCache.set(5, 10);
		lruCache.set(1, 10);
		//lruCache.get(3);
		lruCache.printElem();
	}

}
