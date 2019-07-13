package cn;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JRadioButton;

public class music extends JFrame implements ActionListener{
	JLabel bj, welc,moshi;
	static JRadioButton b1;
	static JRadioButton b2;
	JButton begin;
	
	ButtonGroup g1;
	File musicfile;
	AudioClip clip;
	
		
		
	public music(){
		super();
		this.setLayout(null);
		this.setLocation(0, 50);
		this.setSize(500, 450);
		this.setVisible(true);
		
		
		moshi=new JLabel("请选择游戏：");
		b1=new JRadioButton("图片模式",true);
		b2=new JRadioButton("数字模式");
		add(moshi);
		moshi.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		moshi.setForeground(Color.BLACK);
		moshi.setLocation(0,0);
		moshi.setSize(320,20);
		add(b1);
		add(b2);
		g1=new ButtonGroup();
		g1.add(b1);
		g1.add(b2);
		b1.setFont(new Font("微软雅黑", Font.BOLD,14));
		b1.setLocation(130,0);
		b1.setSize(85,14);
		b2.setFont(new Font("微软雅黑", Font.BOLD,14));
		b2.setLocation(130,20);
		b2.setSize(85,14);
		
		
		welc = new JLabel("欢迎使用拼图游戏");
		add(welc);
		
		welc.setFont(new Font("微软雅黑",Font.BOLD,30));
		welc.setLocation(60, 50);
		welc.setSize(380, 50);
		begin = new JButton("开始游戏");
		add(begin);
		begin.setFont(new Font("", Font.BOLD, 28));
		
		
		begin.setLocation(60, 250);
		begin.setSize(380, 50);
		begin.addActionListener(this);
		
		
		
		bj=new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("picture/bj.jpg")));
		add(bj);
		bj.setLocation(0, 0);
		bj.setSize(600, 401);

		this.validate();
		try {
			musicfile = new File("music/一次就好.wav");// creating file object 1
			URI uri = musicfile.toURI();// 2
			URL url = uri.toURL(); // 3
			clip = Applet.newAudioClip(url);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public static boolean checkb1(){
		if(b1.isSelected()){
			return true;
		}
		return false;
	}
	public  static boolean checkb2(){
		if(b2.isSelected()){
			return true;
		}
		return false;
	}
	public void actionPerformed(ActionEvent e) {

		new frame("拼图");
		clip.play();
		this.dispose();

	}
	public static void main(String[] args) throws Exception {
		new music();

	}
	
	
}