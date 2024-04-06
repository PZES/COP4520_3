import java.util.concurrent.Semaphore;


public class Node {
	int value;
	Node next;
	Semaphore sem;
	Node(int val){
		value = val;
		next = null;
		sem = new Semaphore(1);
	}
}