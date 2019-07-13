package com.legendary.chat;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;

/*<p>Title:HappyChat聊天系统聊天程序</p>
 *<p>Description:系统用户登录后进行聊天</p>
 *<p>Copyright:Copyright (C)2006</p>
 *<p>Filename:ChatRoom.java</p>
 *@author 刘志
 *@version 1.0
 */

public class ChatRoom extends Thread implements ActionListener {
	private JComboBox daXiaoComboBox;

	private JComboBox yangShiComboBox;

	private JComboBox zitiComboBox;

	static JFrame frmChat;

	JPanel pnlChat;

	JButton btnCls, btnExit, btnSend, btnClear, btnSave;

	JLabel lblUserList, lblUserMessage, lblChatUser;

	JLabel lblUserTotal, lblCount, lblBack;

	JTextField txtMessage;

	java.awt.List lstUserList;

	TextArea taUserMessage;

	JComboBox cmbUser;

	JCheckBox chPrivateChat;

	String strServerIp, strLoginName;

	Thread thread;

	// 用于将窗口用于定位
	Dimension scrnsize;

	Toolkit toolkit = Toolkit.getDefaultToolkit();

	Message messobj = null;

	String serverMessage = "";

	final JLabel hanziLabel = new JLabel();
	private JPanel panel;
	private JLabel label;

	// 构造方法
	public ChatRoom(String name, String ip) {
		// Dialog d = new FontDialog();
		strServerIp = ip;
		strLoginName = name;
		frmChat = new JFrame("聊天室" + "[用户:" + name + "]");
		pnlChat = new JPanel();
		frmChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChat.getContentPane().add(pnlChat);

		Font fntDisp1 = new Font("宋体", Font.PLAIN, 12);

		String list[] = { "所有人" };
		btnCls = new JButton("清屏(C)");
		btnExit = new JButton("退出(X)");
		btnSend = new JButton("发送(N)");
		btnSave = new JButton("保存(S)");
		lblUserList = new JLabel("【在线用户列表】");
		lblUserMessage = new JLabel("【聊天信息】");
		lblChatUser = new JLabel("你对:");
		lblUserTotal = new JLabel("在线人数:");
		lblCount = new JLabel("0");
		lstUserList = new java.awt.List();
		txtMessage = new JTextField(170);
		cmbUser = new JComboBox(list);
		// chenmin
		cmbUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				freshHead();
			}
		});
		chPrivateChat = new JCheckBox("私聊");
		taUserMessage = new TextArea("", 300, 200,
				TextArea.SCROLLBARS_VERTICAL_ONLY);// 只能向下滚动
		// taUserMessage.setText("aaaaaa汉字aaaa");
		taUserMessage.setForeground(new Color(0, 0, 0));
		taUserMessage.setEditable(false); // 不可写入

		/***********************************************************************
		 * 该布局采用手动布局 setBounds设置组件位置 * setFont设置字体、字型、字号 * setForeground设置文字的颜色 *
		 * setBackground设置背景色 * setOpaque将背景设置为透明
		 */

		pnlChat.setLayout(null);
		pnlChat.setBackground(new Color(153, 255, 255));
		btnSave.setBounds(492, 370, 80, 25);
		btnCls.setBounds(492, 300, 80, 25);
		btnExit.setBounds(492, 398, 80, 25);
		btnSend.setBounds(492, 335, 80, 25);

		lblUserList.setBounds(5, 0, 96, 40);
		lblUserTotal.setBounds(130, 0, 60, 40);
		lblCount.setBounds(190, 0, 60, 40);
		lblUserMessage.setBounds(225, 0, 180, 40);
		lblChatUser.setBounds(10, 290, 40, 40);

		// lblUserTotal.setBounds(10,340,100,40);
		// lblCount.setBounds(73,340,100,40);
		lstUserList.setBounds(15, 40, 80, 255);
		taUserMessage.setBounds(101, 40, 363, 255);
		txtMessage.setBounds(80, 335, 388, 82);
		cmbUser.setBounds(50, 300, 80, 25);
		chPrivateChat.setBounds(375, 302, 60, 20);
		btnCls.setFont(fntDisp1);
		btnExit.setFont(fntDisp1);
		btnSend.setFont(fntDisp1);
		btnSave.setFont(fntDisp1);
		lblUserList.setFont(fntDisp1);
		lblUserMessage.setFont(fntDisp1);
		lblChatUser.setFont(fntDisp1);
		lblUserTotal.setFont(fntDisp1);
		lblCount.setFont(fntDisp1);
		cmbUser.setFont(fntDisp1);
		chPrivateChat.setFont(fntDisp1);
		// taUserMessage.setFont(new Font("新宋体", Font.BOLD | Font.ITALIC, 20));

		lblUserList.setForeground(new Color(0, 51, 255));
		lblUserMessage.setForeground(new Color(0, 51, 255));
		lblChatUser.setForeground(new Color(0, 0, 0));
		lblUserTotal.setForeground(new Color(0, 51, 255));
		lblCount.setForeground(new Color(255, 0, 0));
		cmbUser.setForeground(Color.black);
		chPrivateChat.setForeground(Color.black);
		lstUserList.setBackground(Color.white);
		taUserMessage.setBackground(Color.white);
		btnCls.setBackground(Color.ORANGE);
		btnExit.setBackground(Color.ORANGE);
		btnSend.setBackground(Color.PINK);
		btnSave.setBackground(Color.ORANGE);
		pnlChat.add(btnCls);
		pnlChat.add(btnExit);
		pnlChat.add(btnSend);
		pnlChat.add(btnSave);
		pnlChat.add(lblUserList);
		pnlChat.add(lblUserMessage);
		pnlChat.add(lblChatUser);
		pnlChat.add(lblUserTotal);
		pnlChat.add(lblCount);
		pnlChat.add(lstUserList);
		pnlChat.add(taUserMessage);
		pnlChat.add(txtMessage);
		pnlChat.add(cmbUser);
		pnlChat.add(chPrivateChat);

		frmChat.addWindowListener(new Windowclose());
		btnCls.addActionListener(this);
		btnExit.addActionListener(this);
		btnSend.addActionListener(this);
		btnSave.addActionListener(this);
		lstUserList.addActionListener(this);
		txtMessage.addActionListener(this);

		zitiComboBox = new JComboBox();
		zitiComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				freshFont();
			}

		});
		zitiComboBox.setModel(new DefaultComboBoxModel(new String[] { "宋体",
				"黑体" }));
		zitiComboBox.setBounds(155, 301, 64, 23);
		pnlChat.add(zitiComboBox);

		yangShiComboBox = new JComboBox();
		yangShiComboBox.setModel(new DefaultComboBoxModel(new String[] { "正规",
				"粗体", "斜体", "粗斜" }));
		yangShiComboBox.setBounds(238, 301, 52, 23);
		yangShiComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				freshFont();
			}

		});
		pnlChat.add(yangShiComboBox);

		daXiaoComboBox = new JComboBox();
		daXiaoComboBox.setModel(new DefaultComboBoxModel(new String[] { "12",
				"14", "16", "18", "20" }));
		daXiaoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				freshFont();
			}

		});
		daXiaoComboBox.setBounds(312, 301, 40, 23);
		pnlChat.add(daXiaoComboBox);

		hanziLabel.setForeground(new Color(0, 51, 255));
		hanziLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hanziLabel.setFont(new Font("宋体", Font.BOLD, 18));
		hanziLabel.setBackground(Color.ORANGE);
		hanziLabel.setText("\u804A\u5929");
		hanziLabel.setBounds(10, 355, 57, 50);
		pnlChat.add(hanziLabel);
		
		panel = new JPanel();
		panel.setBounds(476, 40, 96, 250);
		pnlChat.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(10, 10, 76, 230);
		panel.add(label);

		// 启动聊天页面信息刷新线程
		Thread thread = new Thread(this);
		thread.start();

		// Icon log=new ImageIcon("images\\chat.jpg");
		// lblBack = new JLabel(log);
		// lblBack.setBounds(1, 1, 600,420);
		// pnlChat.add(lblBack);

		frmChat.setSize(600, 461);
		frmChat.setVisible(true);
		frmChat.setResizable(false);

		// 将窗口定位在屏幕中央
		scrnsize = toolkit.getScreenSize();
		frmChat.setLocation(scrnsize.width / 2 - frmChat.getWidth() / 2,
				scrnsize.height / 2 - frmChat.getHeight() / 2);
		Image img = toolkit.getImage("images\\appico.jpg");
		frmChat.setIconImage(img);

	} // 构造方法结束

	protected void freshFont() {
		// TODO 自动生成方法存根
		String ziti = zitiComboBox.getSelectedItem().toString();
		int yangShi = 0;
		String yangShiString = yangShiComboBox.getSelectedItem().toString();
		if (yangShiString.equals("常规")) {
			yangShi = Font.PLAIN;
		} else if (yangShiString.equals("粗体")) {
			yangShi = Font.BOLD;
		} else if (yangShiString.equals("斜体")) {
			yangShi = Font.ITALIC;
		} else if (yangShiString.equals("粗斜")) {
			yangShi = Font.BOLD | Font.ITALIC;
		}

		int daXiao = Integer.parseInt(daXiaoComboBox.getSelectedItem()
				.toString());
		taUserMessage.setFont(new Font(ziti, yangShi, daXiao));
		taUserMessage.setForeground(hanziLabel.getForeground());
	}

	@SuppressWarnings("deprecation")
	public void run() {
		int intMessageCounter = 0;
		int intUserTotal = 0;
		boolean isFirstLogin = true; // 判断是否刚登陆
		boolean isFound; // 判断是否找到用户
		Vector user_exit = new Vector();

		try {
			// Socket toServer;
			// toServer = new Socket(strServerIp, 1001);
			for (;;) {
				Socket toServer;
				toServer = new Socket(strServerIp, 1001);
				// 将信息发往服务器
				messobj = new Message();
				ObjectOutputStream streamtoserver = new ObjectOutputStream(
						toServer.getOutputStream());
				streamtoserver.writeObject((Message) messobj);
				// 收来自服务器的信息
				ObjectInputStream streamfromserver = new ObjectInputStream(
						toServer.getInputStream());
				messobj = (Message) streamfromserver.readObject();
				// //////刷新聊天信息列表//////////
				if (isFirstLogin) // 如果刚登陆
				{
					intMessageCounter = messobj.chat.size(); // 屏蔽该用户登陆前的聊天内容
					isFirstLogin = false;
				}
				if (strLoginName.equals(messobj.ti)) {
					// taUserMessage.append("ni bei ti");
					exitChatRoom();
					JOptionPane.showMessageDialog(null, strLoginName
							+ "你被管理员剔除!");

				}
				
				if (!serverMessage.equals(messobj.serverMessage)) {
					serverMessage = messobj.serverMessage;
					taUserMessage.append("[系统消息]：" + serverMessage+"\n");
				}
				// taUserMessage.setText("");
				for (int i = intMessageCounter; i < messobj.chat.size(); i++) {
					Chat temp = (Chat) messobj.chat.elementAt(i);
					// chenmin

					String emote = temp.emote;
					if (emote.equals("表情")) {
						emote = "";
					} else {
						emote += "地";
					}
					String temp_message;
					if (temp.chatUser.equals(strLoginName)) {
						if (temp.chatToUser.equals(strLoginName)) {
							temp_message = "系统提示您：请不要自言自语！" + "\n";
						} else {
							if (!temp.whisper) // 不是悄悄话
							{
								temp_message = "【你】对【" + temp.chatToUser + "】"
										+ emote + "说：" + temp.chatMessage
										+ "\n";
							} else {
								temp_message = "【你】悄悄对【" + temp.chatToUser
										+ "】" + emote + "说：" + temp.chatMessage
										+ "\n";
							}
						}
					} else {
						if (temp.chatToUser.equals(strLoginName)) {
							if (!temp.whisper) // 不是悄悄话
							{
								temp_message = "【" + temp.chatUser + "】对【你】"
										+ emote + "说：" + temp.chatMessage
										+ "\n";
							} else {
								temp_message = "【" + temp.chatUser + "】悄悄对【你】"
										+ emote + "说：" + temp.chatMessage
										+ "\n";
							}
						} else {
							if (!temp.chatUser.equals(temp.chatToUser)) // 对方没有自言自语
							{
								if (!temp.whisper) // 不是悄悄话
								{
									temp_message = "【" + temp.chatUser + "】对【"
											+ temp.chatToUser + "】" + emote
											+ "说：" + temp.chatMessage + "\n";
								} else {
									temp_message = "";
								}
							} else {
								temp_message = "";
							}
						}
					}
					taUserMessage.append(temp_message);
					intMessageCounter++;
				}

				// //////刷新在线用户//////////
				lstUserList.clear();
				for (int i = 0; i < messobj.userOnLine.size(); i++) {
					String User = ((Customer) messobj.userOnLine.elementAt(i)).custName;
					lstUserList.addItem(User);
				}
				Integer a = new Integer(messobj.userOnLine.size());
				lblCount.setText(a.toString());
				// 显示用户进入聊天室的信息
				if (messobj.userOnLine.size() > intUserTotal) {
					// chenmin
					String tempstr = ((Customer) messobj.userOnLine
							.elementAt(messobj.userOnLine.size() - 1)).custName;
					// String tempstr = messobj.userOnLine.elementAt(
					// messobj.userOnLine.size() - 1).toString();
					if (!tempstr.equals(strLoginName)) {
						taUserMessage.append("【" + tempstr + "】来了" + "\n");
					}
				}
				// 显示用户离开聊天室的信息
				// 显示用户离开聊天室的信息
				if (messobj.userOnLine.size() < intUserTotal) {
					for (int b = 0; b < user_exit.size(); b++) {
						isFound = false;
						for (int c = 0; c < messobj.userOnLine.size(); c++) {
							String tempstr = ((Customer) user_exit.elementAt(b)).custName;

							if (tempstr.equals(((Customer) messobj.userOnLine
									.elementAt(c)).custName)) {
								isFound = true;
								break;
							}
						}
						if (!isFound) // 没有发现该用户
						{
							String tempstr = ((Customer) user_exit.elementAt(b)).custName;

							if (!tempstr.equals(strLoginName)) {
								taUserMessage.append("【" + tempstr + "】走了"
										+ "\n");
							}
						}
					}
				}
				user_exit = messobj.userOnLine;
				intUserTotal = messobj.userOnLine.size();
				streamtoserver.close();
				streamfromserver.close();
				toServer.close();
				Thread.sleep(3000);
			}

		} catch (Exception e) {
			@SuppressWarnings("unused")
			JOptionPane jop = new JOptionPane();
			JOptionPane.showMessageDialog(null, "不能连接服务器！");
			e.printStackTrace();
			frmChat.dispose();
			// System.out.println();
			// System.out.println(e.getMessage());
		}

	} // run()结束

	private void exitChatRoom() {
		// TODO 自动生成方法存根
		exit();
	}

	// /////////监听按钮响应//////////////
	public void actionPerformed(ActionEvent ae) {
		Object source = (Object) ae.getSource();
		
		if (source.equals(btnCls)) {
			clearMessage();
		}
		if (source.equals(btnExit)) {
			exit();
		}
		if (source.equals(btnSend)) {
			sendMessage();
		}
		if (source.equals(btnSave)) {
			saveMessage();
		}
		if (source.equals(lstUserList)) // 双击列表框
		{
			changeUser();
		}
	} // actionPerformed()结束

	// /////////监听窗口关闭响应//////////////
	class Windowclose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			exit();
		}
	}

	// "清屏"按钮
	public void clearMessage() {
		taUserMessage.setText("");
	}

	// "退出"按钮
	public void exit() {
		Exit exit = new Exit();
		exit.exitname = strLoginName;
		// 发送退出信息
		try {
			Socket toServer = new Socket("127.0.0.1", 1001);
			// 向服务器发送信息
			ObjectOutputStream outObj = new ObjectOutputStream(toServer
					.getOutputStream());
			outObj.writeObject(exit);
			outObj.close();
			toServer.close();

			frmChat.dispose();
			// this.destroy();
		} catch (Exception e) {
		}

	} // exit()结束

	// "发送"按钮
	public void sendMessage() {
		Chat chatobj = new Chat();
		chatobj.chatUser = strLoginName;
		chatobj.chatMessage = txtMessage.getText();
		chatobj.chatToUser = String.valueOf(cmbUser.getSelectedItem());
		chatobj.whisper = chPrivateChat.isSelected() ? true : false;
		
		// 向服务器发送信息
		try {
			Socket toServer = new Socket("127.0.0.1", 1001);
			ObjectOutputStream outObj = new ObjectOutputStream(toServer
					.getOutputStream());
			outObj.writeObject(chatobj);
			txtMessage.setText(""); // 清空文本框
			outObj.close();
			toServer.close();
		} catch (Exception e) {
		}
	} // sendMessage()结束

	// "保存"按钮
	public void saveMessage() {
		try {
			FileOutputStream fileoutput = new FileOutputStream(
					this.strLoginName + "_message.txt", true);
			String temp = taUserMessage.getText();
			// System.out.println(temp);
			fileoutput.write(temp.getBytes());
			fileoutput.close();
			JOptionPane.showMessageDialog(null, "聊天记录保存在" + this.strLoginName
					+ "_message.txt");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// 将所选用户添加到cmbUser中
	public void changeUser() {

		boolean key = true;
		String selected = lstUserList.getSelectedItem();
		// JOptionPane.showMessageDialog(null, selected);
		for (int i = 0; i < cmbUser.getItemCount(); i++) {
			if (selected.equals(cmbUser.getItemAt(i))) {
				key = false;
				break;
			}
		}
		if (key == true) {
			cmbUser.insertItemAt(selected, 0);
		}
		String head = getUserHead(lstUserList.getSelectedItem());
		// JOptionPane.showMessageDialog(null, head);
		cmbUser.setSelectedItem(selected);

		// chenmin
		
	} // changeUser()结束

	// chenmin
	protected void freshHead() {
		// TODO 自动生成方法存根
		String head = getUserHead(cmbUser.getSelectedItem().toString());
		// JOptionPane.showMessageDialog(null, head);
		// cmbUser.setSelectedItem(selected);

		// chenmin
		
	}

	// chenmin
	private String getUserHead(String selectedItem) {
		// TODO 自动生成方法存根
		String head = "oo";
		for (int i = 0; i < messobj.userOnLine.size(); i++) {
			String User = ((Customer) messobj.userOnLine.elementAt(i)).custName;
			
			// System.out.println(User+":"+head);
			if (User.equals(selectedItem)) {
				break;
			}
			// lstUserList.addItem(User);
		}
		return head;
	}

	public static void main(String args[]) {
		new ChatRoom("测试用户", "127.0.0.1");
	}
}