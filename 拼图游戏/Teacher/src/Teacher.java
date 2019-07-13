
public class Teacher {
	public static void main(String[] args) {
		Homework homework1=new Homework();
		new Thread(homework1,"第一个老师").start();
		new Thread(homework1,"第二个老师").start();
		new Thread(homework1,"第三个老师").start();
		
	}
}

class Homework implements Runnable {
	private int homework = 80;

	public void run() {
		while (true) {
			distribution();
			if (homework <= 0) {
				break;
			}

		}
	}
	private synchronized void distribution()
	{
		if(homework>0)
		{
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"---发出的笔记"+homework--);
			
		}
	}
}
