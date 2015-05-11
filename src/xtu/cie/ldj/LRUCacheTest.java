package xtu.cie.ldj;

public class LRUCacheTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruCache = new LRUCache(2);
		lruCache.set(2, 1);
		lruCache.set(2, 2);
//		lruCache.get(2);
		lruCache.set(1, 1);
//		lruCache.set(4, 1);
//		lruCache.get(2);
		lruCache.printElem();
	}

}
