import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class temp {
	private int[]  min= {0,0,0,0,0};
	private int[] max = {0,0,0,0,0};
	public static void main(String[] args) throws InterruptedException {
		
		Thread threads[] = new Thread[8];
		AtomicInteger num = new AtomicInteger(0);
		AtomicInteger time = new AtomicInteger(0);
		int[] l = {0,0,0,0,0,0,0,0};
		for(int i = 0; i < 8; i++) {
			threads[i] = new Thread((new Runnable() {
				//passthough needed vars to function
				int i;
				AtomicInteger num;
				AtomicInteger time;
				int[] l;
				public void run() {
					thread(i, num,time,l);
				}
			     public Runnable pass(int i, AtomicInteger num,AtomicInteger time, int[] l) {
			           this.i = i;
			           this.num = num;
			           this.time = time;
			           this.l = l;
			           return this;
			     }
			    
			}).pass(i,num,time,l));
			threads[i].start();
		}
		for(int i = 0; i < 8; i++) {
			threads[i].join();
		}
		
	}
	public static void thread(int i, AtomicInteger num,AtomicInteger time,int[] l) {
		int run = 0;
		Random rand = new Random();
		while(time.get()<60) {
			//only run when time is incremented
			int test = time.get();
			if(run != test || run ==0) {
				
				l[i] = rand.nextInt(170) - 100;
				
				int b = num.getAndIncrement();
				System.out.println(i + " " + l[i] + " "+ b);
			}
			run = test;
			while(num.get() < 480 && i ==1) {
				System.out.println("eee"+ i + " "+num.get());
				int qweqw =1;
			}
			if(i == 1) {
			
				int t=time.getAndIncrement();

				int min= l[0];
				int max= l[0];
				for(int j =1; j>8; j++) {
					if(l[j]<min) {
						min = l[j];
					}
					if(l[j]>max) {
						max = l[j];
					}
				}
				
				if(t >=10) {
					
				}
			}
		}
	


	}
}
