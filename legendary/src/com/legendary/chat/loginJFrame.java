package com.legendary.chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.legendary.Dao.userRegisterDao;

import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class loginJFrame extends JFrame implements ActionListener {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginJFrame frame = new loginJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginJFrame() {
		setResizable(false);
		setForeground(Color.BLUE);
		getContentPane().setForeground(Color.YELLOW);
		setIconImage(Toolkit.getDefaultToolkit().getImage(loginJFrame.class.getResource("/images/title.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 347);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.CYAN);
		panel.setBounds(10, 149, 379, 150);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 100, 110);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(loginJFrame.class.getResource("/images/qq.jpg")));
		lblNewLabel.setBounds(0, 5, 100, 95);
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 16));

		textField.setBounds(120, 22, 169, 32);
		panel.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u5B89\u5168\u767B\u5F55");
		button.setFont(new Font("黑体", Font.BOLD, 16));
		button.setForeground(Color.GREEN);
		button.setBackground(Color.BLUE);
		button.setBounds(120, 88, 169, 39);
		panel.add(button);

		JButton btnNewButton = new JButton("\u6CE8\u518C\u5E10\u53F7");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 9));

		// btnNewButton.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });

		btnNewButton.setBounds(290, 22, 89, 32);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u627E\u56DE\u5BC6\u7801");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 9));
		btnNewButton_1.setBounds(290, 52, 89, 32);
		panel.add(btnNewButton_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(120, 52, 169, 32);
		panel.add(passwordField);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 379, 129);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(loginJFrame.class.getResource("/images/bj.gif")));
		lblNewLabel_1.setBounds(10, 10, 359, 109);
		panel_2.add(lblNewLabel_1);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				registerJFrame re = new registerJFrame();
				re.setVisible(true);
				loginJFrame.this.dispose();

			}
		});

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
				} else {
					Customer data = new Customer();
					data.custName = textField.getText();
					data.custPassword = passwordField.getText();
					userRegisterDao us = new userRegisterDao();
					boolean bo = us.login(textField.getText(), passwordField.getText());
					if (bo) {
						try {
							Socket toServer;
							toServer = new Socket("127.0.0.1", 1001);
							ObjectOutputStream streamToServer = new ObjectOutputStream(toServer.getOutputStream());
							streamToServer.writeObject((Customer) data);
							BufferedReader fromServer = new BufferedReader(
									new InputStreamReader(toServer.getInputStream()));
							new ChatRoom((String)data.custName, "127.0.0.1");
							loginJFrame.this.dispose();
							streamToServer.close();
							toServer.close();

						} catch (ConnectException e1) {
							JOptionPane.showMessageDialog(null, "未能建立到指定服务器的连接！");

						} catch (InvalidClassException e2) {
							JOptionPane.showMessageDialog(null, "类错误！");
							
						} catch (NotSerializableException e3) {
							JOptionPane.showMessageDialog(null, "对象未序列化！");
						}catch(IOException e4){
							JOptionPane.showMessageDialog(null, "不能写入到指定服务器！");
						}
					} else {
						JOptionPane.showMessageDialog(null, "登录失败！");

					}
				}

			}
		});

	}

	public void actionPerformed(ActionEvent e) {

	}
}
