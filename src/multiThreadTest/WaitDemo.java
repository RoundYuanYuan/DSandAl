package multiThreadTest;

public class WaitDemo extends Thread{
	@Override
	synchronized public void run() {
		for(int i=0;i<100;i++)
		{
			System.out.println(getName()+i);
			if(i==20)
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public static void main(String[] args) {
		WaitDemo waitDemo = new WaitDemo();
		waitDemo.start();
		synchronized (waitDemo) {
			for(int i=0;i<100000;i++)
			{
				System.out.println(i);
				if(i==2)
					waitDemo.notify();
			}
		}

	
	}
}
