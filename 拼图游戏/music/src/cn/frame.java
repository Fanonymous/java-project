package cn;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JProgressBar;


public class frame extends JFrame implements ActionListener,Runnable{

	
	JButton begin;
	JProgressBar jpb;
	Thread t;
	int time;
	final Example myPanel;
	
	//��ʼ��������
		private void initJProgressBar(){
			//jpb=new JProgressBar(JProgressBar.VERTICAL);
			//���ý���������
			jpb=new JProgressBar();
			jpb.setStringPainted(true);//��ʾ��ǰ����ֵ��Ϣ
			jpb.setIndeterminate(false);//ȷ��������ִ����ɺ����ع���
			jpb.setBorderPainted(false);//���ý������߿���ʾ
			jpb.setBackground(Color.green);//���ý������ı���ɫ
		}
		
	public frame(String s){
		super(s);
		begin=new JButton("��ʼ");
		myPanel=new Example();
		add(myPanel);
		
		add(begin,BorderLayout.SOUTH);
		this.setSize(308,368);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initJProgressBar();
		this.add(jpb,BorderLayout.NORTH);
		jpb.setSize(30,330);
		
		begin.addActionListener(this);
	
		
	}
	public static void main(String[] args) {
		
		new frame("ƴͼ");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(time=1;time<=500;time++){
			jpb.setValue(time);
			if(myPanel.isFinish())
			{
			break;}
				Thread.sleep(100000);}
				if(time>500) {
				int i=JOptionPane.showConfirmDialog(null, 
						"���ź���ʱ�䵽���Ƿ������Ϸ��", "�Ƿ����¿�ʼ", JOptionPane.YES_NO_OPTION);
				if(i==0){
					myPanel.start();
					t=new Thread(this);
					time=0;
					t.start();
					
				}else {
					
					t.stop();
					System.exit(0);
				}}else{
					int i=JOptionPane.showConfirmDialog(null, 
							"�Ƿ������Ϸ��", "�Ƿ����¿�ʼ", JOptionPane.YES_NO_OPTION);
					if(i==0){
						myPanel.start();
						t=new Thread(this);
						time=0;
						t.start();
						
					}else {
						
							//if(i==1||i==-1){
						t.stop();
						System.exit(0);
					}
				}
					
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		myPanel.start();
		t=new Thread(this);
		t.start();
		
	}

	

}
