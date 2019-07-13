import javax.swing.*;

import com.te.dao.user;
import com.te.entil.u;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;


/**
 * <p>
 * Title: HappyChat����ϵͳ��¼����
 * </p>
 * <p>
 * Description: ����ָ���ķ�������ַ���û����������¼���������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Filename: Login.java
 * </p>
 * 
 * @author ��־��
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

	// ���ڽ����ڶ�λ
	private Dimension scrnsize;

	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	
	/**
	 * �����½����
	 */
	public Login() {
		super("İİ,Ϊ�������ɫ��");
		setResizable(false);
		setTitle("legendary");
		pnlLogin = new JPanel();
		this.getContentPane().add(pnlLogin);

		lblServer = new JLabel("������(S):");
		lblServer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName = new JLabel("�û���(U):");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword = new JLabel("\u5BC6 \u7801(P):");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		txtServer = new JTextField(20);
		txtServer.setEnabled(false);
		txtServer.setText("127.0.0.1");
		txtUserName = new JTextField(20);
		pwdPassword = new JPasswordField(20);
		btnLogin = new JButton("��¼(L)");
		btnLogin.setForeground(Color.GREEN);
		btnLogin.setToolTipText("��¼��������");
		btnLogin.setMnemonic('L');
		btnRegister = new JButton("ע��(R)");
		btnRegister.setToolTipText("ע�����û�");
		btnRegister.setMnemonic('R');
		btnExit = new JButton("�˳�(X)");
		btnExit.setToolTipText("�˳�ϵͳ");
		btnExit.setMnemonic('X');
		/***********************************************************************
		 * �ò��ֲ����ֶ����� setBounds�������λ�� * setFont�������塢���͡��ֺ� * setForeground�������ֵ���ɫ *
		 * setBackground���ñ���ɫ * setOpaque����������Ϊ͸��
		 */
		pnlLogin.setLayout(null); // ������ֶ�����
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

		Font fontstr = new Font("����", Font.PLAIN, 12);
		lblServer.setFont(new Font("����", Font.PLAIN, 12));
		txtServer.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblUserName.setFont(new Font("����", Font.PLAIN, 12));
		txtUserName.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblPassword.setFont(new Font("����", Font.PLAIN, 12));
		pwdPassword.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		btnLogin.setFont(new Font("����", Font.BOLD, 16));
		btnRegister.setFont(new Font("����", Font.PLAIN, 12));
		btnExit.setFont(new Font("����", Font.PLAIN, 12));

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

		// ���ñ���ͼƬ
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

		// ������ťע�����
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		btnExit.addActionListener(this);

	} // ���췽������

	/**
	 * ��ť������Ӧ
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		if (source.equals(btnLogin)) {
			// �ж��û����������Ƿ�Ϊ��
			if (txtUserName.getText().equals("")
					|| pwdPassword.getText().equals("")) {
				JOptionPane op1 = new JOptionPane();
				/*****
				 * 
				 * ���·�����������Dialog�Ի�����������õ�
				 */
				Font font=new Font("΢���ź�",0,14);
				UIManager.put("OptionPane.font", font);
				UIManager.put("OptionPane.messageFont", font);
				UIManager.put("OptionPane.buttonFont", font);
				op1.showMessageDialog(null, "�û��������벻��Ϊ��");
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
	} // actionPerformed()����

	/** 
	 * ��¼�¼���Ӧ����
	 */
	@SuppressWarnings("deprecation")
	public void login() {
		/*****
		 * 
		 * ���·�����������Dialog�Ի�����������õ�
		 */
		Font font=new Font("΢���ź�",0,14);
		UIManager.put("OptionPane.font", font);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		// ���ܿͻ�����ϸ����
		Customer data = new Customer();
		data.custName = txtUserName.getText();
		data.custPassword = pwdPassword.getText();
		String n=txtUserName.getText();
		String p=pwdPassword.getText();
		user us=new user();
		u u1=us.login(n, p);
		if(u1!=null){
		try {
			// ���ӵ�������
			Socket toServer;
			toServer = new Socket(strServerIp, 1001);
			ObjectOutputStream streamToServer = new ObjectOutputStream(toServer
					.getOutputStream());
			// д�ͻ���ϸ���ϵ�������socket
			streamToServer.writeObject((Customer) data);
			// �����Է�����socket�ĵ�¼״̬
			BufferedReader fromServer = new BufferedReader(
					new InputStreamReader(toServer.getInputStream()));
			//String status = fromServer.readLine();
			
				new ChatRoom((String) data.custName, strServerIp);
				this.dispose();
				// �ر�������
				streamToServer.close();
				fromServer.close();
				toServer.close();
			
		} catch (ConnectException e1) {
			JOptionPane.showMessageDialog(null, "δ�ܽ�����ָ��������������!");
		} catch (InvalidClassException e2) {
			JOptionPane.showMessageDialog(null, "�����!");
		} catch (NotSerializableException e3) {
			JOptionPane.showMessageDialog(null, "����δ���л�!");
		} catch (IOException e4) {
			JOptionPane.showMessageDialog(null, "����д�뵽ָ��������!");
		}
		}else{
			JOptionPane.showMessageDialog(this, "������˺Ŵ���");
		}
	} // login()����

	/**
	 * ������½����
	 * @param args
	 */
	public static void main(String args[]) {
		new Login();
	}
} // Class Login����
