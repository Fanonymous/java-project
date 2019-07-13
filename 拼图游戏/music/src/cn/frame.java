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
	
	//初始化进度条
		private void initJProgressBar(){
			//jpb=new JProgressBar(JProgressBar.VERTICAL);
			//设置进度条属性
			jpb=new JProgressBar();
			jpb.setStringPainted(true);//显示当前进度值信息
			jpb.setIndeterminate(false);//确定进度条执行完成后不来回滚动
			jpb.setBorderPainted(false);//设置进度条边框不显示
			jpb.setBackground(Color.green);//设置进度条的背景色
		}
		
	public frame(String s){
		super(s);
		begin=new JButton("开始");
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
		
		new frame("拼图");
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
						"很遗憾，时间到，是否继续游戏？", "是否重新开始", JOptionPane.YES_NO_OPTION);
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
							"是否继续游戏？", "是否重新开始", JOptionPane.YES_NO_OPTION);
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
