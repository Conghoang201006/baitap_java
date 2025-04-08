class Resource {
	void method() {
		System.out.print(Thread.currentThread().getName() + " dang chay ");
	}
}
public class DeadlockExample {
	public static void main(String[] agrs) {
		Resource r1 = new Resource();
		Resource r2 = new Resource();
		Thread t1 = new Thread(() -> 
		{
			synchronized (r1) {
				try {
					Thread.sleep(100); 
				} catch (InterruptedException e){}
				synchronized (r2) {
					r2.method();
				}
			}
		});
			Thread t2 = new Thread(() -> {
				synchronized (r2) {
					try {Thread.sleep(100); } catch(InterruptedException e) {} 
					synchronized (r1)  {r1.method();}
				}
			});
			t1.start();
			t2.start();
			}
}
