package cn.itcase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class zhuanzhangFrame extends javax.swing.JFrame {
	private JLabel labbiaoqian;
	private JLabel labzhuanzhang;
	private JButton butqueren;
	private JButton butquxiao;
	private JTextField textzhuanzhangjine;
	private JTextField textduizhanghu;
	private JLabel labduiz;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				zhuanzhangFrame inst = new zhuanzhangFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public zhuanzhangFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			{
				labbiaoqian = new JLabel();
				getContentPane().add(labbiaoqian);
				labbiaoqian.setText("\u8f6c\u8d26");
				labbiaoqian.setBounds(204, 24, 105, 43);
				labbiaoqian.setFont(new java.awt.Font("微软雅黑",1,26));
				labbiaoqian.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				labduiz = new JLabel();
				getContentPane().add(labduiz);
				labduiz.setText("\u8bf7\u8f93\u5165\u5bf9\u65b9\u7684\u8d26\u6237\uff1a");
				labduiz.setBounds(46, 132, 167, 33);
				labduiz.setFont(new java.awt.Font("微软雅黑",1,18));
			}
			{
				textduizhanghu = new JTextField();
				getContentPane().add(textduizhanghu);
				textduizhanghu.setBounds(225, 139, 217, 27);
			}
			{
				labzhuanzhang = new JLabel();
				getContentPane().add(labzhuanzhang);
				labzhuanzhang.setText("\u8bf7\u8f93\u5165\u8f6c\u8d26\u7684\u91d1\u989d\uff1a");
				labzhuanzhang.setBounds(46, 216, 179, 33);
				labzhuanzhang.setFont(new java.awt.Font("微软雅黑",1,18));
			}
			{
				textzhuanzhangjine = new JTextField();
				getContentPane().add(textzhuanzhangjine);
				textzhuanzhangjine.setBounds(225, 222, 217, 27);
			}
			{
				butqueren = new JButton();
				getContentPane().add(butqueren);
				butqueren.setText("\u786e\u8ba4");
				butqueren.setBounds(87, 313, 109, 57);
				butqueren.setFont(new java.awt.Font("微软雅黑",1,18));
				butqueren.addActionListener(new ActionListener() {
					//确认按钮单击事件
					public void actionPerformed(ActionEvent evt) {
						//获得用户转账的数目
						String yue=textzhuanzhangjine.getText();
						int number1=Integer.parseInt(yue);
						//获得数据库中用户的金额
						String uc=Share.count;
						 cardsdao car=new cardsdao();
						 cards cha=car.querycardbyuc(uc);
						 String jinge=cha.getYue();
						 int number2=Integer.parseInt(jinge);
						 int number3=number2-number1;
						 if(number3>=0){
							 String s = String.valueOf(number3);
							 //封装
							cards ca=new cards();
							ca.setYue(s);
							ca.setUcnoid(Share.count);
							cardsdao cunku =new cardsdao();
							int result=cunku.qukuan(ca);
							if(result>0){
								JOptionPane.showMessageDialog(zhuanzhangFrame.this, "转帐成功");
								zhuanzhangFrame.this.dispose();
								
							
							}else{
								JOptionPane.showMessageDialog(zhuanzhangFrame.this, "余额不足，转账失败");
							}
						 }else{
							 JOptionPane.showMessageDialog(zhuanzhangFrame.this, "余额不足，转账失败");
							 zhuanzhangFrame.this.dispose();
						 }
						 
						 int number4=number2+number1;
						 String s1 = String.valueOf(number4);
							cards ca=new cards();
							ca.setYue(s1);
							ca.setUcnoid(textduizhanghu.getText());
							cardsdao cunku =new cardsdao();
							cunku.cunkuan(ca);
							mainFrame main=new mainFrame();
							main.setVisible(true);
					}
				});
			}
			{
				butquxiao = new JButton();
				getContentPane().add(butquxiao);
				butquxiao.setText("\u53d6\u6d88");
				butquxiao.setBounds(328, 313, 109, 57);
				butquxiao.setFont(new java.awt.Font("微软雅黑",1,18));
				butquxiao.addActionListener(new ActionListener() {
					//取消按钮单击事件
					public void actionPerformed(ActionEvent evt) {
						zhuanzhangFrame.this.dispose();
						mainFrame main=new mainFrame();
						main.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(576, 460);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
