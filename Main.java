import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Thread threads[] = new Thread[4];
		for(int i = 0; i < 4; i++) {
			threads[i] = new Thread((new Runnable() {
				//passthough needed vars to function
				int i;
				public void run() {
					thread(i);
				}
			     public Runnable pass(int i) {
			           this.i = i;
			           return this;
			     }
			    
			}).pass(i));
			threads[i].start();
		}
		for(int i = 0; i < 4; i++) {
			threads[i].join();
		}
		System.out.println("Done");
		temp.main(args);
	}
	public static void thread(int i) {
		
	}
	
}
