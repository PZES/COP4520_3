import java.util.concurrent.Semaphore;
public class LL {
	Node head;
	
	//make ll not empty to make it easier to code
	LL(){
		head = new Node(0);
		head.next = new Node(500001);
	}
	public static LL insert(LL l, int value) throws InterruptedException {
		Node newn = new Node(value);
		Node prev = l.head;
		prev.sem.acquire();
		Node next = prev.next;
		next.sem.acquire();
		while(next.value<value) {
			prev.sem.release();
			prev = next;
			next = next.next;
			next.sem.acquire();
		}
		prev.next = newn;
		newn.next = next;
		prev.sem.release();
		next.sem.release();
		return l;
	}
	
}
