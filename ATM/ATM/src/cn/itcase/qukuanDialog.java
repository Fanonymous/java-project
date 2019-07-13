package cn.itcase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
public class qukuanDialog extends JFrame {
	private JLabel labbiaoti,bj;
	private JButton butquxiao;
	private JButton butqueren;
	private JTextField textjine;
	private JLabel labqu;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				qukuanDialog inst = new qukuanDialog();
				inst.setVisible(true);
			}
		});
	}
	
	public qukuanDialog() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("\u53d6\u6b3e");
				this.setResizable(false);
				{
					labbiaoti = new JLabel();
					getContentPane().add(labbiaoti);
					labbiaoti.setText("\u53d6\u6b3e");
					labbiaoti.setBounds(175, 17, 93, 32);
					labbiaoti.setFont(new java.awt.Font("微软雅黑",1,20));
					labbiaoti.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					labqu = new JLabel();
					getContentPane().add(labqu);
					labqu.setText("\u8bf7\u8f93\u5165\u91d1\u989d\uff1a");
					labqu.setBounds(52, 75, 105, 44);
					labqu.setFont(new java.awt.Font("微软雅黑",1,16));
					labqu.setBackground(new java.awt.Color(255,0,0));
				}
				{
					textjine = new JTextField();
					getContentPane().add(textjine);
					textjine.setBounds(162, 87, 219, 24);
				}
				{
					butqueren = new JButton();
					getContentPane().add(butqueren);
					butqueren.setText("\u786e\u8ba4");
					butqueren.setBounds(64, 150, 87, 37);
					butqueren.setFont(new java.awt.Font("微软雅黑",1,14));
					butqueren.addActionListener(new ActionListener() {
						//确认按钮单击事件
						public void actionPerformed(ActionEvent evt) {
							//获得用户取款的数目
							String yue=textjine.getText();
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
									JOptionPane.showMessageDialog(qukuanDialog.this, "取款成功");
									qukuanDialog.this.dispose();
								}else{
									JOptionPane.showMessageDialog(qukuanDialog.this, "余额不足，取款失败");
								}
							 }else{
								 JOptionPane.showMessageDialog(qukuanDialog.this, "余额不足，取款失败");
								 qukuanDialog.this.dispose();
							 }
							 mainFrame main=new mainFrame();
								main.setVisible(true);
							 
							
						}
					});
				}
				{
					butquxiao = new JButton();
					getContentPane().add(butquxiao);
					butquxiao.setText("\u53d6\u6d88");
					butquxiao.setBounds(262, 150, 87, 37);
					butquxiao.setFont(new java.awt.Font("微软雅黑",1,14));
					butquxiao.addActionListener(new ActionListener() {
						//取消按钮单击事件
						public void actionPerformed(ActionEvent evt) {
							qukuanDialog.this.dispose();
							mainFrame main=new mainFrame();
							main.setVisible(true);
						
						}
					});
				}
			}
			this.setSize(464, 263);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bj=new JLabel(new ImageIcon("picture/qian.jpg"));
		add(bj);
		bj.setLocation(0, 0);
		bj.setBounds(-5, 0, 490, 260);
	}

}
