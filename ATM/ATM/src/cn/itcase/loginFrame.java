package cn.itcase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import cn.itcase.dao.userdao;
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
public class loginFrame extends javax.swing.JFrame {
	private JLabel labwelcom;//欢迎登陆"中国银行"的标签
	 JLabel bj;//插背景图片的标签
	private JLabel labid;//输入帐号提示标签
	private JTextField tetid;//输入帐号的文本框
	private JButton butzhuce;//注册按钮
	private JButton butcancel;//取消按钮
	private JButton butconfirm;//登录按钮
	private JPasswordField textpassword;//输入密码的文本框
	private JLabel labpassword;//输入密码的提示标签

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				loginFrame inst = new loginFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public loginFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(440, 384);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u767b\u9646");
			this.setResizable(false);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			{
				labwelcom = new JLabel();
				getContentPane().add(labwelcom);
				labwelcom.setText("\u6b22\u8fce\u767b\u9646\u4e2d\u56fd\u94f6\u884c");
				labwelcom.setBounds(158, 59, 262, 51);
				labwelcom.setFont(new java.awt.Font("微软雅黑",1,26));
				labwelcom.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				labid = new JLabel();
				getContentPane().add(labid);
				labid.setText("\u8bf7\u8f93\u5165\u8d26\u53f7\uff1a");
				labid.setBounds(72, 116, 132, 53);
				labid.setFont(new java.awt.Font("微软雅黑",1,20));
			}
			{
				labpassword = new JLabel();
				getContentPane().add(labpassword);
				labpassword.setText("\u8bf7\u8f93\u5165\u5bc6\u7801\uff1a");
				labpassword.setBounds(72, 194, 132, 53);
				labpassword.setFont(new java.awt.Font("微软雅黑",1,20));
			}
			{
				tetid = new JTextField();
				getContentPane().add(tetid);
				tetid.setBounds(216, 133, 204, 24);
			}
			{
				textpassword = new JPasswordField();
				getContentPane().add(textpassword);
				textpassword.setBounds(216, 211, 204, 24);
			}
			{
				butconfirm = new JButton();
				getContentPane().add(butconfirm);
				butconfirm.setText("\u767b\u9646");
				butconfirm.setBounds(238, 329, 81, 40);
				butconfirm.setFont(new java.awt.Font("微软雅黑",1,12));
				butconfirm.addActionListener(new ActionListener() {
					//登陆按钮单机事件
					public void actionPerformed(ActionEvent evt) {
						//1.获得用户输入的账号和密码
						String ucnoid =new String(tetid.getText());
						//获得用户输入的密码，该方法获得是一个字符数组，可以通过String的构造方法，来将字符数组创建为字符串
						String password = new String(textpassword.getPassword());
						//创建userdao类的一个对象
						userdao us1=new userdao();
						boolean boo = us1.login(ucnoid, password);
						if(boo){
							Share.count=ucnoid;
							//登录成功界面跳转到主界面
							//创建主界面对象
							mainFrame main = new mainFrame();
							//设置主界面显示
							main.setVisible(true);
							//让当前界面隐藏
							loginFrame.this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(loginFrame.this, "登录失败!");
						}
					}
				});
			}
			{
				butcancel = new JButton();
				getContentPane().add(butcancel);
				butcancel.setText("\u53d6\u6d88");
				butcancel.setBounds(420, 329, 81, 40);
				butcancel.setFont(new java.awt.Font("微软雅黑",1,12));
				butcancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//取消按钮单击事件
						System.exit(0);
					}
				});
			}
			pack();
			this.setSize(589, 455);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		
		{
			butzhuce = new JButton();
			getContentPane().add(butzhuce);
			butzhuce.setText("\u6ce8\u518c");
			butzhuce.setBounds(60, 329, 81, 40);
			butzhuce.setFont(new java.awt.Font("微软雅黑",1,12));
			butzhuce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//注册按钮单机事件
					zhuceFrame zhuce=new zhuceFrame();
					zhuce.setVisible(true);
					loginFrame.this.dispose();
				}
			});
		}
		bj=new JLabel(new ImageIcon("picture./bj.jpg"));
		add(bj);
		bj.setLocation(0, 0);
		bj.setBounds(-5, 0, 594, 437);
	}
	


}
class Share{
	static String count;
}
