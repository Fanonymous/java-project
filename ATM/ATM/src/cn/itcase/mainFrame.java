package cn.itcase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import cn.itcase.dao.cardsdao;
import cn.itcase.shuju.cards;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class mainFrame extends javax.swing.JFrame {
	private JLabel labbiaoti,bj;
	private JButton butchaxun;
	private JButton jButton1;
	private JButton butcunkuan;
	private JButton buttuika;
	private JButton butzhuanzhang;
	private JButton butxiugaimima;
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mainFrame inst = new mainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public mainFrame() {
		super();
		initGUI();
	}
	
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				labbiaoti = new JLabel();
				getContentPane().add(labbiaoti);
				labbiaoti.setText("\u4e2d\u56fd\u94f6\u884c");
				labbiaoti.setBounds(181, 23, 189, 50);
				labbiaoti.setFont(new java.awt.Font("微软雅黑",1,26));
				labbiaoti.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				butchaxun = new JButton();
				getContentPane().add(butchaxun);
				butchaxun.setText("\u67e5\u8be2\u4f59\u989d");
				butchaxun.setBounds(42, 130, 110, 60);
				butchaxun.setFont(new java.awt.Font("微软雅黑",1,18));
				butchaxun.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//查询余额单击事件
						
						 String uc=Share.count;
						 cardsdao car=new cardsdao();
						 cards cha=car.querycardbyuc(uc);
						 JOptionPane.showMessageDialog(mainFrame.this, "您的余额："+cha.getYue()+"元");
						
					
					}
				});
			}
			{
				butxiugaimima = new JButton();
				getContentPane().add(butxiugaimima);
				butxiugaimima.setText("\u4fee\u6539\u5bc6\u7801");
				butxiugaimima.setBounds(426, 128, 110, 60);
				butxiugaimima.setFont(new java.awt.Font("微软雅黑",1,18));
				butxiugaimima.addActionListener(new ActionListener() {
					//修改密码按钮单击事件
					public void actionPerformed(ActionEvent evt) {
						xiugaiFrame xiu=new xiugaiFrame();
						xiu.setVisible(true);
						mainFrame.this.dispose();
					}
				});
			}
			{
				butzhuanzhang = new JButton();
				getContentPane().add(butzhuanzhang);
				butzhuanzhang.setText("\u8f6c\u8d26");
				butzhuanzhang.setBounds(426, 227, 110, 60);
				butzhuanzhang.setFont(new java.awt.Font("微软雅黑",1,18));
				butzhuanzhang.addActionListener(new ActionListener() {
					//转账按钮单击事件
					public void actionPerformed(ActionEvent evt) {
						zhuanzhangFrame zhuan=new zhuanzhangFrame();
						zhuan.setVisible(true);
						mainFrame.this.dispose();
					}
				});
			}
			{
				buttuika = new JButton();
				getContentPane().add(buttuika);
				buttuika.setText("\u9000\u5361");
				buttuika.setBounds(426, 334, 110, 60);
				buttuika.setFont(new java.awt.Font("微软雅黑",1,18));
				buttuika.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//退卡按钮单击事件
						System.exit(0);
						
					}
				});
			}
			
		
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u53d6\u6b3e");
				jButton1.setBounds(42, 329, 110, 60);
				jButton1.setFont(new java.awt.Font("微软雅黑",1,18));
				jButton1.addActionListener(new ActionListener() {
					//取款按钮单击事件
					public void actionPerformed(ActionEvent evt) {
						qukuanDialog qukuan=new qukuanDialog();
						qukuan.setVisible(true);
						mainFrame.this.dispose();
					}
				});
			}
			{
				butcunkuan = new JButton();
				getContentPane().add(butcunkuan);
				butcunkuan.setText("\u5b58\u6b3e");
				butcunkuan.setBounds(42, 231, 110, 60);
				butcunkuan.setFont(new java.awt.Font("微软雅黑",1,18));
				butcunkuan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//存款按钮单击事件
						cunkuanFrame cunku=new cunkuanFrame();
						cunku.setVisible(true);
						mainFrame.this.dispose();
					}
				});
			}
			pack();
			this.setSize(598, 494);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		bj=new JLabel(new ImageIcon("picture./zybj.jpg"));
		add(bj);
		bj.setLocation(0, 0);
		bj.setBounds(-5, 0, 594, 457);
	}
}	

