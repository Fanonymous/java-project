import javax.swing.*;

import com.te.dao.user;
import com.te.entil.u;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;


/**
 * <p>
 * Title: HappyChat聊天系统登录程序
 * </p>
 * <p>
 * Description: 根据指定的服务器地址、用户名和密码登录聊天服务器
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Filename: Login.java
 * </p>
 * 
 * @author 刘志成
 * @version 1.0
 */
public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8965773902056088264L;

	private JPanel pnlLogin;

	private JButton btnLogin, btnRegister, btnExit;

	private JLabel lblServer, lblUserName, lblPassword, lblLogo;

	private JTextField txtUserName, txtServer;

	private JPasswordField pwdPassword;

	private String strServerIp;

	// 用于将窗口定位
	private Dimension scrnsize;

	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	
	/**
	 * 构造登陆窗体
	 */
	public Login() {
		super("陌陌,为生活点亮色彩");
		setResizable(false);
		setTitle("legendary");
		pnlLogin = new JPanel();
		this.getContentPane().add(pnlLogin);

		lblServer = new JLabel("服务器(S):");
		lblServer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName = new JLabel("用户名(U):");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword = new JLabel("\u5BC6 \u7801(P):");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		txtServer = new JTextField(20);
		txtServer.setEnabled(false);
		txtServer.setText("127.0.0.1");
		txtUserName = new JTextField(20);
		pwdPassword = new JPasswordField(20);
		btnLogin = new JButton("登录(L)");
		btnLogin.setForeground(Color.GREEN);
		btnLogin.setToolTipText("登录到服务器");
		btnLogin.setMnemonic('L');
		btnRegister = new JButton("注册(R)");
		btnRegister.setToolTipText("注册新用户");
		btnRegister.setMnemonic('R');
		btnExit = new JButton("退出(X)");
		btnExit.setToolTipText("退出系统");
		btnExit.setMnemonic('X');
		/***********************************************************************
		 * 该布局采用手动布局 setBounds设置组件位置 * setFont设置字体、字型、字号 * setForeground设置文字的颜色 *
		 * setBackground设置背景色 * setOpaque将背景设置为透明
		 */
		pnlLogin.setLayout(null); // 组件用手动布局
		pnlLogin.setBackground(new Color(238, 232, 170));

		lblServer.setBounds(112, 150, 61, 30);
		txtServer.setBounds(183, 153, 120, 25);
		lblUserName.setBounds(112, 204, 61, 30);
		txtUserName.setBounds(183, 207, 120, 25);
		lblPassword.setBounds(112, 230, 61, 30);
		pwdPassword.setBounds(183, 233, 120, 25);
		btnLogin.setBounds(183, 277, 120, 30);
		btnRegister.setBounds(310, 209, 100, 25);
		btnExit.setBounds(310, 233, 100, 25);

		Font fontstr = new Font("宋体", Font.PLAIN, 12);
		lblServer.setFont(new Font("仿宋", Font.PLAIN, 12));
		txtServer.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblUserName.setFont(new Font("仿宋", Font.PLAIN, 12));
		txtUserName.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblPassword.setFont(new Font("仿宋", Font.PLAIN, 12));
		pwdPassword.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnLogin.setFont(new Font("仿宋", Font.BOLD, 16));
		btnRegister.setFont(new Font("仿宋", Font.PLAIN, 12));
		btnExit.setFont(new Font("仿宋", Font.PLAIN, 12));

		lblUserName.setForeground(Color.BLACK);
		lblPassword.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.BLUE);
		btnRegister.setBackground(Color.WHITE);
		btnExit.setBackground(Color.WHITE);

		pnlLogin.add(lblServer);
		pnlLogin.add(txtServer);
		pnlLogin.add(lblUserName);
		pnlLogin.add(txtUserName);
		pnlLogin.add(lblPassword);
		pnlLogin.add(pwdPassword);
		pnlLogin.add(btnLogin);
		pnlLogin.add(btnRegister);
		pnlLogin.add(btnExit);

		// 设置背景图片
		Icon logo1 = new ImageIcon("images\\loginlogo.jpg");
		lblLogo = new JLabel(new ImageIcon("G:\\gongzuowendang\\chat\\images\\bj.gif"));
		lblLogo.setBounds(10, 10, 400, 110);
		pnlLogin.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\gongzuowendang\\chat\\images\\qq.jpg"));
		lblNewLabel.setBounds(10, 148, 110, 110);
		pnlLogin.add(lblNewLabel);
		setSize(418, 359);
		setVisible(true);
		scrnsize = toolkit.getScreenSize();
		setLocation(scrnsize.width / 2 - this.getWidth() / 2, scrnsize.height
				/ 2 - this.getHeight() / 2);
		Image img = toolkit.getImage("images\\appico.jpg");
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\gongzuowendang\\chat\\images\\title.gif"));

		// 三个按钮注册监听
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		btnExit.addActionListener(this);

	} // 构造方法结束

	/**
	 * 按钮监听响应
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		if (source.equals(btnLogin)) {
			// 判断用户名和密码是否为空
			if (txtUserName.getText().equals("")
					|| pwdPassword.getText().equals("")) {
				JOptionPane op1 = new JOptionPane();
				/*****
				 * 
				 * 以下方法用来设置Dialog对话框的字体设置等
				 */
				Font font=new Font("微软雅黑",0,14);
				UIManager.put("OptionPane.font", font);
				UIManager.put("OptionPane.messageFont", font);
				UIManager.put("OptionPane.buttonFont", font);
				op1.showMessageDialog(null, "用户名或密码不能为空");
			} else {
				strServerIp = txtServer.getText();
				login();
			}
		}
		if (source.equals(btnRegister)) {
			strServerIp = txtServer.getText();
			this.dispose();
			new Register(strServerIp);
		}
		if (source == btnExit) {
			System.exit(0);
		}
	} // actionPerformed()结束

	/** 
	 * 登录事件响应方法
	 */
	@SuppressWarnings("deprecation")
	public void login() {
		/*****
		 * 
		 * 以下方法用来设置Dialog对话框的字体设置等
		 */
		Font font=new Font("微软雅黑",0,14);
		UIManager.put("OptionPane.font", font);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		// 接受客户的详细资料
		Customer data = new Customer();
		data.custName = txtUserName.getText();
		data.custPassword = pwdPassword.getText();
		String n=txtUserName.getText();
		String p=pwdPassword.getText();
		user us=new user();
		u u1=us.login(n, p);
		if(u1!=null){
		try {
			// 连接到服务器
			Socket toServer;
			toServer = new Socket(strServerIp, 1001);
			ObjectOutputStream streamToServer = new ObjectOutputStream(toServer
					.getOutputStream());
			// 写客户详细资料到服务器socket
			streamToServer.writeObject((Customer) data);
			// 读来自服务器socket的登录状态
			BufferedReader fromServer = new BufferedReader(
					new InputStreamReader(toServer.getInputStream()));
			//String status = fromServer.readLine();
			
				new ChatRoom((String) data.custName, strServerIp);
				this.dispose();
				// 关闭流对象
				streamToServer.close();
				fromServer.close();
				toServer.close();
			
		} catch (ConnectException e1) {
			JOptionPane.showMessageDialog(null, "未能建立到指定服务器的连接!");
		} catch (InvalidClassException e2) {
			JOptionPane.showMessageDialog(null, "类错误!");
		} catch (NotSerializableException e3) {
			JOptionPane.showMessageDialog(null, "对象未序列化!");
		} catch (IOException e4) {
			JOptionPane.showMessageDialog(null, "不能写入到指定服务器!");
		}
		}else{
			JOptionPane.showMessageDialog(this, "密码或账号错误！");
		}
	} // login()结束

	/**
	 * 启动登陆窗体
	 * @param args
	 */
	public static void main(String args[]) {
		new Login();
	}
} // Class Login结束
