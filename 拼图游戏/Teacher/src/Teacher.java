
public class Teacher {
	public static void main(String[] args) {
		Homework homework1=new Homework();
		new Thread(homework1,"��һ����ʦ").start();
		new Thread(homework1,"�ڶ�����ʦ").start();
		new Thread(homework1,"��������ʦ").start();
		
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
			System.out.println(Thread.currentThread().getName()+"---�����ıʼ�"+homework--);
			
		}
	}
}
