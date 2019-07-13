import javax.swing.*;

import com.te.dao.user;
import com.te.entil.u;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

/*<p>Title:HappyChat聊天系统用户注册程序</p>
 *<p>Description:新用户通过输入相关信息注册成系统用户</p>
 *<p>Copyright:Copyright(C)2006</p>
 *<p>Filename:Register.java</p>
 *@author 刘志成
 *@version 1.0
 */

public class Register extends JFrame implements ActionListener {
	private JComboBox comboBox;
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019746127517522180L;
	private ValidCode vcode;
	JPanel pnlRegister;
	JLabel lblUserName, lblGender, lblAge;
	JLabel lblPassword, lblConfirmPass, lblEmail;
	JTextField txtUserName, txtAge, txtEmail;
	JPasswordField pwdUserPassword, pwdConfirmPass;
	JRadioButton rbtnMale, rbtnFemale;
	ButtonGroup btngGender;
	JButton btnOk, btnCancel, btnClear;
	String strServerIp;
	final JLabel headLabel = new JLabel();
	// 用于将窗口用于定位
	Dimension scrnsize;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	private JTextField textField;
	// 构造方法

	public Register(String ip) {
		super("[HappyChat]聊天室注册窗口");
		setTitle("legendary");
		strServerIp = ip;
		pnlRegister = new JPanel();
		pnlRegister.setForeground(Color.BLACK);
		this.getContentPane().add(pnlRegister);

		lblUserName = new JLabel("用 户 名:");
		lblGender = new JLabel("性    别:");
		lblAge = new JLabel("\u5E74    \u9F84:");
		lblPassword = new JLabel("\u5BC6  \u7801:");
		lblConfirmPass = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
		lblEmail = new JLabel("电子邮件:");
		txtUserName = new JTextField(30);
		txtEmail = new JTextField(30);
		txtAge = new JTextField(10);
		pwdUserPassword = new JPasswordField(30);
		pwdConfirmPass = new JPasswordField(30);
		rbtnMale = new JRadioButton("男", true);
		rbtnFemale = new JRadioButton("女");
		btngGender = new ButtonGroup();
		btnOk = new JButton("\u6CE8\u518C(O)");
		btnOk.setForeground(Color.BLACK);
		btnOk.setMnemonic('O');
		btnOk.setToolTipText("保存注册信息");
		btnCancel = new JButton("返回(B)");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setMnemonic('B');
		btnCancel.setToolTipText("返回登录窗口");
		btnClear = new JButton("清空(L)");
		btnClear.setForeground(Color.BLACK);
		btnClear.setMnemonic('L');
		btnClear.setToolTipText("清空注册信息");

		/*
		 * 该布局采用手动布局 * setBounds设置组件位置 * setFont设置字体、字型、字号 *
		 * setForeground设置文字的颜色 * setBackground设置背景色 * setOpaque将背景设置为透明
		 */
		pnlRegister.setLayout(null); // 组件用手动布局
		pnlRegister.setBackground(new Color(135, 206, 250));

		lblUserName.setBounds(56, 65, 70, 30);
		txtUserName.setBounds(136, 70, 120, 20);
		lblPassword.setBounds(56, 134, 60, 30);
		pwdUserPassword.setBounds(136, 139, 120, 20);
		lblConfirmPass.setBounds(56, 169, 70, 30);
		pwdConfirmPass.setBounds(136, 174, 120, 20);
		lblGender.setBounds(56, 209, 70, 30);
		rbtnMale.setBounds(132, 214, 60, 20);
		rbtnFemale.setBounds(207, 214, 47, 20);
		lblAge.setBounds(56, 236, 100, 30);
		txtAge.setBounds(136, 241, 120, 20);
		lblEmail.setBounds(56, 261, 100, 30);
		txtEmail.setBounds(136, 266, 120, 20);

		btnOk.setBounds(136, 353, 120, 48);
		btnCancel.setBounds(278, 376, 93, 25);
		btnClear.setBounds(278, 353, 93, 25);

		Font fontstr = new Font("宋体", Font.PLAIN, 12);
		lblUserName.setFont(new Font("仿宋", Font.BOLD, 12));
		lblGender.setFont(new Font("仿宋", Font.BOLD, 12));
		lblPassword.setFont(new Font("仿宋", Font.BOLD, 12));
		lblConfirmPass.setFont(new Font("仿宋", Font.BOLD, 12));
		lblAge.setFont(new Font("仿宋", Font.BOLD, 12));
		lblEmail.setFont(new Font("仿宋", Font.BOLD, 12));
		rbtnMale.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		rbtnFemale.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtUserName.setFont(fontstr);
		txtEmail.setFont(fontstr);
		btnOk.setFont(new Font("仿宋", Font.BOLD, 18));
		btnCancel.setFont(new Font("仿宋", Font.BOLD, 12));
		btnClear.setFont(new Font("仿宋", Font.BOLD, 12));

		lblUserName.setForeground(Color.BLACK);
		lblGender.setForeground(Color.BLACK);
		lblPassword.setForeground(Color.BLACK);
		lblAge.setForeground(Color.BLACK);
		lblConfirmPass.setForeground(Color.BLACK);
		lblEmail.setForeground(Color.BLACK);
		rbtnMale.setForeground(Color.BLACK);
		rbtnFemale.setForeground(Color.BLACK);
		rbtnMale.setBackground(Color.white);
		rbtnFemale.setBackground(Color.white);
		btnOk.setBackground(Color.WHITE);
		btnCancel.setBackground(Color.WHITE);
		btnClear.setBackground(Color.WHITE);
		rbtnMale.setOpaque(false);
		rbtnFemale.setOpaque(false);

		pnlRegister.add(lblUserName);
		pnlRegister.add(lblGender);
		pnlRegister.add(lblPassword);
		pnlRegister.add(lblConfirmPass);
		pnlRegister.add(lblEmail);
		pnlRegister.add(lblAge);
		pnlRegister.add(txtAge);
		pnlRegister.add(txtUserName);
		pnlRegister.add(txtEmail);
		pnlRegister.add(pwdUserPassword);
		pnlRegister.add(pwdConfirmPass);
		pnlRegister.add(btnOk);
		pnlRegister.add(btnCancel);
		pnlRegister.add(btnClear);
		pnlRegister.add(rbtnMale);
		pnlRegister.add(rbtnFemale);
		btngGender.add(rbtnMale);
		btngGender.add(rbtnFemale);

		// 设置背景图片
		Icon logo = new ImageIcon("images\\registerlogo.jpg");

		this.setSize(414, 455);
		this.setVisible(true);
		this.setResizable(false);
		// 将窗口定位在屏幕中央
		scrnsize = toolkit.getScreenSize();
		this.setLocation(scrnsize.width / 2 - this.getWidth() / 2, scrnsize.height / 2 - this.getHeight() / 2);
		Image img = toolkit.getImage("images\\appico.jpg");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\gongzuowendang\\chat\\images\\title.gif"));
		// 三个按钮注册监听
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		btnClear.addActionListener(this);

		final JLabel label = new JLabel();
		label.setFont(new Font("仿宋", Font.BOLD, 12));
		label.setText("头    像:");
		label.setBounds(56, 105, 70, 19);
		pnlRegister.add(label);

		comboBox = new JComboBox();
		comboBox.setAutoscrolls(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		comboBox.setBounds(136, 103, 47, 23);
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				Icon logo = new ImageIcon("face\\" + comboBox.getSelectedItem().toString() + ".jpg");
				// TODO 自动生成方法存根
				headLabel.setIcon(logo);
			}
		});
		pnlRegister.add(comboBox);

		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// .setIcon(SwingResourceManager.getIcon(Register.class, "face/1.jpg"));
		headLabel.setIcon(new ImageIcon("face//1.jpg"));
		headLabel.setBounds(278, 91, 93, 85);
		pnlRegister.add(headLabel);

		JLabel label_1 = new JLabel("\u6CE8\u518C\u5E10\u53F7");
		label_1.setForeground(new Color(255, 0, 255));
		label_1.setFont(new Font("叶根友毛笔行书2.0版", Font.BOLD, 16));
		label_1.setBounds(10, 10, 87, 30);
		pnlRegister.add(label_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 50, 410, 2);
		pnlRegister.add(separator);

		JLabel label_2 = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("仿宋", Font.BOLD, 12));
		label_2.setBounds(56, 301, 54, 23);
		pnlRegister.add(label_2);

		textField = new JTextField();
		textField.setBounds(136, 302, 66, 21);
		pnlRegister.add(textField);
		textField.setColumns(10);

		vcode = new ValidCode();
		vcode.setBounds(230, 290, 50, 30);
		pnlRegister.add(vcode);

	} // 构造方法结束

	// 按钮监听响应
	public void actionPerformed(ActionEvent ae) {
		Object source = new Object();
		source = ae.getSource();
		if (source.equals(btnOk)) // "确定"按钮
		{
			register();
		}
		if (source.equals(btnCancel)) // "返回"按钮
		{
			new Login();
			this.dispose();
		}
		if (source.equals(btnClear)) // "清空"按钮
		{
			txtUserName.setText("");
			pwdUserPassword.setText("");
			pwdConfirmPass.setText("");
			txtAge.setText("");
			txtEmail.setText("");
		}
	} // actionPerformed()结束

	////////// "确定"按钮事件响应//////////
	@SuppressWarnings({ "deprecation", "static-access" })
	public void register() {
		// 接受客户的详细资料
		Register_Customer data = new Register_Customer();
		data.custName = txtUserName.getText();
		data.custPassword = pwdUserPassword.getText();
		data.age = txtAge.getText();
		data.sex = rbtnMale.isSelected() ? "男" : "女";
		data.email = txtEmail.getText();
		// chenmin
		data.head = comboBox.getSelectedItem().toString();
		u stu = new u();
		String n = txtUserName.getText();
		String p = pwdUserPassword.getText();
		String ag = txtAge.getText();
		String sex = rbtnMale.isSelected() ? "男" : "女";
		String em = txtEmail.getText();
		String head = comboBox.getSelectedItem().toString();
		stu.setCustName(n);
		stu.setCustPassword(p);
		stu.setAge(ag);
		stu.setSex(sex);
		stu.setEmail(em);
		stu.setHead(head);
		// 验证用户名是否为空
		/*****
		 * 
		 * 以下方法用来设置Dialog对话框的字体设置等
		 */
		Font font = new Font("微软雅黑", 0, 14);
		UIManager.put("OptionPane.font", font);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);

		if (data.custName.length() == 0) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		// 验证密码是否为空
		if (data.custPassword.length() == 0) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}

		// 验证密码的一致性
		if (!data.custPassword.equals(pwdConfirmPass.getText())) {
			JOptionPane.showMessageDialog(null, "密码两次输入不一致，请重新输入");
			return;
		}

		// 验证年龄是否为空
		if (data.age.length() == 0) {
			JOptionPane.showMessageDialog(null, "年龄不能为空");
			return;
		}
		// 验证年龄的合法性
		int age = Integer.parseInt(txtAge.getText());
		if (age <= 0 || age > 100) {
			JOptionPane.showMessageDialog(null, "年龄输入不合法");
			return;
		}
		// 验证Email的正确性
		int Found_flag = 0; // 判断标志
		for (int i = 0; i < data.email.length(); i++) {
			if (data.email.charAt(i) == '@') {
				Found_flag++;
			}
		}
		if (Found_flag != 1) {
			JOptionPane.showMessageDialog(null, "电子邮箱格式不正确，请重新输入");
			return;
		}
		if (!isValidCodeRight()) {
			JOptionPane.showMessageDialog(Register.this, "验证码错误！");
		}
		if (isValidCodeRight()) {
			user us = new user();
			int u1 = us.addu(stu);
			if (u1 != 0) {
				try {
					// 连接到服务器
					Socket toServer;
					toServer = new Socket(strServerIp, 1001);
					ObjectOutputStream streamToServer = new ObjectOutputStream(toServer.getOutputStream());
					// 写客户详细资料到服务器socket
					streamToServer.writeObject((Register_Customer) data);
					// 读来自服务器socket的登陆状态
					BufferedReader fromServer = new BufferedReader(new InputStreamReader(toServer.getInputStream()));
					// String status=fromServer.readLine();
					// 显示成功消息
					// JOptionPane op=new JOptionPane();
					// op.showMessageDialog(null,status);
					// if(status.equals(data.custName+"注册成功"))
					// {
					txtUserName.setText("");
					pwdUserPassword.setText("");
					pwdConfirmPass.setText("");
					txtAge.setText("");
					txtEmail.setText("");
					// }

					// 关闭流对象
					streamToServer.close();
					fromServer.close();
					JOptionPane.showMessageDialog(this, "注册成功");
				} catch (InvalidClassException e1) {
					JOptionPane.showMessageDialog(null, "类错误!");
				} catch (NotSerializableException e2) {
					JOptionPane.showMessageDialog(null, "对象未序列化!");
				} catch (IOException e3) {
					JOptionPane.showMessageDialog(null, "不能写入到指定服务器!");
				}
			}
		}

	} // 方法register()结束

	/**
	 * 验证码的校验
	 * 
	 * @return
	 */
	public boolean isValidCodeRight() {

		if (textField == null) {
			return false;
		}
		if (vcode == null) {
			return true;
		}
		if (vcode.getCode().equals(textField.getText())) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		new Register("127.0.0.1");
	}
} // class Register 结束
