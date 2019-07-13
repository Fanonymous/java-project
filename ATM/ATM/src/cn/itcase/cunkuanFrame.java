package cn.itcase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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
public class cunkuanFrame extends JDialog {
	private JLabel labcunkuan,bj;
	private JButton butquxiao;
	private JButton jButton1;
	private JLabel labbiaoqian;
	private JTextField textqian;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				cunkuanFrame inst = new cunkuanFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public cunkuanFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b58\u6b3e");
			this.setResizable(false);
			{
				labcunkuan = new JLabel();
				getContentPane().add(labcunkuan);
				labcunkuan.setText("\u8bf7\u653e\u5165\u4eba\u6c11\u5e01\uff1a");
				labcunkuan.setBounds(24, 77, 119, 38);
				labcunkuan.setFont(new java.awt.Font("微软雅黑",1,16));
			}
			{
				textqian = new JTextField();
				getContentPane().add(textqian);
				textqian.setBounds(161, 86, 261, 24);
			}
			{
				labbiaoqian = new JLabel();
				getContentPane().add(labbiaoqian);
				labbiaoqian.setText("\u5b58\u6b3e");
				labbiaoqian.setBounds(184, 12, 99, 48);
				labbiaoqian.setFont(new java.awt.Font("微软雅黑",1,20));
				labbiaoqian.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				butquxiao = new JButton();
				getContentPane().add(butquxiao);
				butquxiao.setText("\u53d6\u6d88");
				butquxiao.setBounds(307, 156, 92, 53);
				butquxiao.addActionListener(new ActionListener() {
					//取消
					public void actionPerformed(ActionEvent evt) {
						cunkuanFrame.this.dispose();
						mainFrame main=new mainFrame();
						main.setVisible(true);
					}
				});
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u786e\u8ba4");
				jButton1.setBounds(69, 156, 92, 53);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String yue=textqian.getText();
						int number1=Integer.parseInt(yue);
						//获得数据库中用户的金额
						String uc=Share.count;
						 cardsdao car=new cardsdao();
						 cards cha=car.querycardbyuc(uc);
						 String jinge=cha.getYue();
						 int number2=Integer.parseInt(jinge);
						 int number3=number2+number1;
						 String s = String.valueOf(number3);
						 //封装
						cards ca=new cards();
						ca.setYue(s);
						ca.setUcnoid(Share.count);
						cardsdao cunku =new cardsdao();
						int result=cunku.qukuan(ca);
						if(result>0){
							JOptionPane.showMessageDialog(cunkuanFrame.this, "存款成功");
							cunkuanFrame.this.dispose();
						}else{
							JOptionPane.showMessageDialog(cunkuanFrame.this, "存款失败");
						}
						mainFrame main=new mainFrame();
						main.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(489, 281);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		bj=new JLabel(new ImageIcon("picture/qian.jpg"));
		add(bj);
		bj.setLocation(0, 0);
		bj.setBounds(-5, 0, 490, 260);
	}

}

