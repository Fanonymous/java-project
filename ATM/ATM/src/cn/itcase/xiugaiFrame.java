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
import cn.itcase.dao.userdao;
import cn.itcase.shuju.cards;
import cn.itcase.shuju.users;


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
public class xiugaiFrame extends javax.swing.JFrame {
	private JLabel labxiugai;
	private JLabel labshuru;
	private JTextField textxinpassword;
	private JButton butquxiao;
	private JButton butqueren;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				xiugaiFrame inst = new xiugaiFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public xiugaiFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				labxiugai = new JLabel();
				getContentPane().add(labxiugai);
				labxiugai.setText("\u4fee\u6539\u5bc6\u7801");
				labxiugai.setBounds(165, 33, 125, 51);
				labxiugai.setFont(new java.awt.Font("微软雅黑",1,26));
				labxiugai.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				labshuru = new JLabel();
				getContentPane().add(labshuru);
				labshuru.setText("\u8bf7\u8f93\u5165\u65b0\u7684\u5bc6\u7801\uff1a");
				labshuru.setBounds(25, 113, 132, 54);
				labshuru.setFont(new java.awt.Font("微软雅黑",1,16));
			}
			{
				textxinpassword = new JTextField();
				getContentPane().add(textxinpassword);
				textxinpassword.setBounds(175, 130, 209, 24);
			}
			{
				butqueren = new JButton();
				getContentPane().add(butqueren);
				butqueren.setText("\u786e\u8ba4");
				butqueren.setBounds(61, 229, 107, 47);
				butqueren.setFont(new java.awt.Font("微软雅黑",1,16));
				butqueren.addActionListener(new ActionListener() {
					//确认按钮单击事件
					public void actionPerformed(ActionEvent evt) {
						String password=textxinpassword.getText();
						users us=new users();
						us.setpassword(password);
						us.setUcnoid(Share.count);
						userdao use1=new userdao();
						int result=use1.gaimi(us);
						if(result>0){
							JOptionPane.showMessageDialog(xiugaiFrame.this, "修改成功");
							xiugaiFrame.this.dispose();
						}else{
							JOptionPane.showMessageDialog(xiugaiFrame.this, "修改失败");
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
				butquxiao.setBounds(283, 229, 107, 47);
				butquxiao.setFont(new java.awt.Font("微软雅黑",1,16));
				butquxiao.addActionListener(new ActionListener() {
					//取消按钮单击事件
					public void actionPerformed(ActionEvent evt) {
						xiugaiFrame.this.dispose();
						mainFrame main=new mainFrame();
						main.setVisible(true);
						
					}
				});
			}
			pack();
			setSize(500, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
