import java.util.ArrayDeque;
import java.util.Random;

public class CarQueue {

	ArrayDeque<Integer> que;
	
	CarQueue(){
		
		que = new ArrayDeque<Integer>();
		
		for (int i = 0; i < 5; i++) {
			que.add(new Random().nextInt(4));
		}
	}
	
	
	public void addToQueue() {
		class QueueRunnable implements Runnable
		{
			@Override
			public void run() 
			{
				for(int i=0; i<10000; i++) {
					que.add(new Random().nextInt(4));
					try {
						Thread.sleep(500);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();}
				}

			}

		}

		Runnable r = new QueueRunnable();
		Thread t = new Thread(r);
		t.start();
	}
		
	
	
	public int deleteQueue() {
		return que.remove();
	}



}