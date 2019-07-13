import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;

/*<p>Title:HappyChat����ϵͳ�������</p>
 *<p>Description:ϵͳ�û���¼���������</p>
 *<p>Copyright:Copyright (C)2006</p>
 *<p>Filename:ChatRoom.java</p>
 *@author ��־
 *@version 1.0
 */

public class ChatRoom extends Thread implements ActionListener {
	private JComboBox daXiaoComboBox;

	private JComboBox yangShiComboBox;

	private JComboBox zitiComboBox;

	private JComboBox emote;

	static JFrame frmChat;

	JPanel pnlChat;

	JButton btnCls, btnExit, btnSend, btnClear, btnSave;

	JLabel lblUserList, lblUserMessage, lblSendMessage, lblChatUser;

	JLabel lblUserTotal, lblCount, lblBack;

	JTextField txtMessage;

	java.awt.List lstUserList;

	TextArea taUserMessage;

	JComboBox cmbUser;

	JCheckBox chPrivateChat;

	String strServerIp, strLoginName;

	Thread thread;

	final JLabel headLabel = new JLabel();

	// ���ڽ��������ڶ�λ
	Dimension scrnsize;

	Toolkit toolkit = Toolkit.getDefaultToolkit();

	Message messobj = null;

	String serverMessage = "";

	// ���췽��
	public ChatRoom(String name, String ip) {
		// Dialog d = new FontDialog();
		strServerIp = ip;
		strLoginName = name;
		frmChat = new JFrame("������" + "[�û�:" + name + "]");
		frmChat.setBackground(new Color(152, 251, 152));
		pnlChat = new JPanel();
		frmChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChat.getContentPane().add(pnlChat);

		Font fntDisp1 = new Font("����", Font.PLAIN, 12);

		String list[] = { "������" };
		btnCls = new JButton("����(C)");
		btnExit = new JButton("�˳�(X)");
		btnSend = new JButton("����(N)");
		btnSave = new JButton("����(S)");
		lblUserList = new JLabel("\u5728\u7EBF\u7528\u6237\u5217\u8868");
		lblUserMessage = new JLabel("\u804A\u5929\u4FE1\u606F");
		lblUserMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSendMessage = new JLabel("��������:");
		lblChatUser = new JLabel("���:");
		lblUserTotal = new JLabel("��������:");
		lblUserTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount = new JLabel("0");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lstUserList = new java.awt.List();
		lstUserList.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		txtMessage = new JTextField(170);
		txtMessage.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		cmbUser = new JComboBox(list);
		// chenmin
		cmbUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				freshHead();
			}
		});
		chPrivateChat = new JCheckBox("˽��");
		chPrivateChat.setBackground(new Color(176, 196, 222));
		taUserMessage = new TextArea("", 300, 200,
				TextArea.SCROLLBARS_VERTICAL_ONLY);// ֻ�����¹���
		taUserMessage.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		// taUserMessage.setText("aaaaaa����aaaa");
		taUserMessage.setForeground(new Color(0, 0, 0));
		taUserMessage.setEditable(false); // ����д��

		/***********************************************************************
		 * �ò��ֲ����ֶ����� setBounds�������λ�� * setFont�������塢���͡��ֺ� * setForeground�������ֵ���ɫ *
		 * setBackground���ñ���ɫ * setOpaque����������Ϊ͸��
		 */

		pnlChat.setLayout(null);
		pnlChat.setBackground(new Color(127, 255, 212));
		btnSave.setBounds(436, 370, 93, 25);
		btnCls.setBounds(534, 335, 87, 25);
		btnExit.setBounds(534, 370, 87, 25);
		btnSend.setBounds(436, 335, 93, 25);

		lblUserList.setBounds(10, 10, 96, 20);
		lblUserTotal.setBounds(277, 5, 60, 30);
		lblCount.setBounds(333, 5, 25, 30);
		lblUserMessage.setBounds(167, 5, 80, 30);
		lblChatUser.setBounds(10, 300, 49, 25);
		lblSendMessage.setBounds(18, 415, 72, 30);

		// lblUserTotal.setBounds(10,340,100,40);
		// lblCount.setBounds(73,340,100,40);
		lstUserList.setBounds(10, 36, 80, 254);
		taUserMessage.setBounds(103, 35, 355, 255);
		txtMessage.setBounds(108, 335, 318, 110);
		cmbUser.setBounds(69, 300, 80, 25);
		chPrivateChat.setBounds(435, 401, 60, 20);
		btnCls.setFont(new Font("����", Font.BOLD, 12));
		btnExit.setFont(new Font("����", Font.BOLD, 12));
		btnSend.setFont(new Font("����", Font.BOLD, 12));
		btnSave.setFont(new Font("����", Font.BOLD, 12));
		lblUserList.setFont(new Font("����", Font.BOLD, 12));
		lblUserMessage.setFont(new Font("����", Font.BOLD, 12));
		lblChatUser.setFont(new Font("����", Font.BOLD, 12));
		lblSendMessage.setFont(new Font("����", Font.PLAIN, 16));
		lblUserTotal.setFont(new Font("����", Font.BOLD, 12));
		lblCount.setFont(new Font("����", Font.BOLD, 12));
		cmbUser.setFont(new Font("������", Font.PLAIN, 12));
		chPrivateChat.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		// taUserMessage.setFont(new Font("������", Font.BOLD | Font.ITALIC, 20));

		lblUserList.setForeground(Color.BLACK);
		lblUserMessage.setForeground(Color.BLACK);
		lblSendMessage.setForeground(Color.black);
		lblChatUser.setForeground(Color.black);
		lblSendMessage.setForeground(Color.black);
		lblUserTotal.setForeground(Color.BLACK);
		lblCount.setForeground(Color.BLACK);
		cmbUser.setForeground(Color.black);
		chPrivateChat.setForeground(Color.black);
		lstUserList.setBackground(Color.white);
		taUserMessage.setBackground(Color.white);
		btnCls.setBackground(Color.WHITE);
		btnExit.setBackground(Color.WHITE);
		btnSend.setBackground(Color.WHITE);
		btnSave.setBackground(Color.WHITE);
		pnlChat.add(btnCls);
		pnlChat.add(btnExit);
		pnlChat.add(btnSend);
		pnlChat.add(btnSave);
		pnlChat.add(lblUserList);
		pnlChat.add(lblUserMessage);
		pnlChat.add(lblSendMessage);
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

		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setIcon(new ImageIcon("face//1.JPG"));
		headLabel.setBounds(10, 336, 93, 85);
		pnlChat.add(headLabel);

		emote = new JComboBox();
		emote.setFont(new Font("Ҷ����ë������2.0��", Font.PLAIN, 12));
		emote.setModel(new DefaultComboBoxModel(new String[] { "����", "΢Ц",
				"��Ц", "��ϲ", "����", "���", "�ٺ�", "ɵЦ", "����", "����", "����", "����",
				"����", "����", "����", "��ŭ", "����", "����", "����", "�ʺ�", "��Ц", "���",
				"ʾ��", "����", "����" }));
		emote.setBounds(159, 301, 60, 23);
		pnlChat.add(emote);

		zitiComboBox = new JComboBox();
		zitiComboBox.setFont(new Font("Ҷ����ë������2.0��", Font.PLAIN, 12));
		zitiComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				freshFont();
			}

		});
		zitiComboBox.setModel(new DefaultComboBoxModel(new String[] { "����",
				"����" }));
		zitiComboBox.setBounds(238, 301, 64, 23);
		pnlChat.add(zitiComboBox);

		yangShiComboBox = new JComboBox();
		yangShiComboBox.setFont(new Font("����", Font.PLAIN, 12));
		yangShiComboBox.setModel(new DefaultComboBoxModel(new String[] { "����",
				"����", "б��", "��б" }));
		yangShiComboBox.setBounds(324, 301, 52, 23);
		yangShiComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				freshFont();
			}

		});
		pnlChat.add(yangShiComboBox);

		daXiaoComboBox = new JComboBox();
		daXiaoComboBox.setFont(new Font("������", Font.PLAIN, 12));
		daXiaoComboBox.setModel(new DefaultComboBoxModel(new String[] { "12",
				"14", "16", "18", "20" }));
		daXiaoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				freshFont();
			}

		});
		daXiaoComboBox.setBounds(386, 301, 40, 23);
		pnlChat.add(daXiaoComboBox);
		
		JLabel lblQq = new JLabel("QQ\u79C0");
		lblQq.setHorizontalAlignment(SwingConstants.CENTER);
		lblQq.setFont(new Font("����", Font.PLAIN, 12));
		lblQq.setForeground(Color.BLACK);
		lblQq.setBounds(514, 8, 60, 25);
		pnlChat.add(lblQq);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\gongzuowendang\\chat\\images\\qqxiu.gif"));
		lblNewLabel.setBounds(464, 36, 149, 254);
		pnlChat.add(lblNewLabel);

		// ��������ҳ����Ϣˢ���߳�
		Thread thread = new Thread(this);
		thread.start();

		// Icon log=new ImageIcon("images\\chat.jpg");
		// lblBack = new JLabel(log);
		// lblBack.setBounds(1, 1, 600,420);
		// pnlChat.add(lblBack);

		frmChat.setSize(627, 483);
		frmChat.setVisible(true);
		frmChat.setResizable(false);

		// �����ڶ�λ����Ļ����
		scrnsize = toolkit.getScreenSize();
		frmChat.setLocation(scrnsize.width / 2 - frmChat.getWidth() / 2,
				scrnsize.height / 2 - frmChat.getHeight() / 2);
		Image img = toolkit.getImage("images\\appico.jpg");
		frmChat.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\gongzuowendang\\chat\\images\\title.gif"));

	} // ���췽������

	protected void freshFont() {
		// TODO �Զ����ɷ������
		String ziti = zitiComboBox.getSelectedItem().toString();
		int yangShi = 0;
		String yangShiString = yangShiComboBox.getSelectedItem().toString();
		if (yangShiString.equals("����")) {
			yangShi = Font.PLAIN;
		} else if (yangShiString.equals("����")) {
			yangShi = Font.BOLD;
		} else if (yangShiString.equals("б��")) {
			yangShi = Font.ITALIC;
		} else if (yangShiString.equals("��б")) {
			yangShi = Font.BOLD | Font.ITALIC;
		}

		int daXiao = Integer.parseInt(daXiaoComboBox.getSelectedItem()
				.toString());
		taUserMessage.setFont(new Font(ziti, yangShi, daXiao));
//		taUserMessage.setForeground(hanziLabel.getForeground());
	}

	@SuppressWarnings("deprecation")
	public void run() {
		/*****
		 * 
		 * ���·�����������Dialog�Ի�����������õ�
		 */
		Font font=new Font("΢���ź�",0,14);
		UIManager.put("OptionPane.font", font);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		int intMessageCounter = 0;
		int intUserTotal = 0;
		boolean isFirstLogin = true; // �ж��Ƿ�յ�½
		boolean isFound; // �ж��Ƿ��ҵ��û�
		Vector user_exit = new Vector();

		try {
			// Socket toServer;
			// toServer = new Socket(strServerIp, 1001);
			for (;;) {
				Socket toServer;
				toServer = new Socket(strServerIp, 1001);
				// ����Ϣ����������
				messobj = new Message();
				ObjectOutputStream streamtoserver = new ObjectOutputStream(
						toServer.getOutputStream());
				streamtoserver.writeObject((Message) messobj);
				// �����Է���������Ϣ
				ObjectInputStream streamfromserver = new ObjectInputStream(
						toServer.getInputStream());
				messobj = (Message) streamfromserver.readObject();
				// //////ˢ��������Ϣ�б�//////////
				if (isFirstLogin) // ����յ�½
				{
					intMessageCounter = messobj.chat.size(); // ���θ��û���½ǰ����������
					isFirstLogin = false;
				}
				if (strLoginName.equals(messobj.ti)) {
					// taUserMessage.append("ni bei ti");
					exitChatRoom();
					JOptionPane.showMessageDialog(null, strLoginName
							+ "�㱻����Ա�޳�!");

				}
				
				if (!serverMessage.equals(messobj.serverMessage)) {
					serverMessage = messobj.serverMessage;
					taUserMessage.append("[ϵͳ��Ϣ]��" + serverMessage+"\n");
				}
				// taUserMessage.setText("");
				for (int i = intMessageCounter; i < messobj.chat.size(); i++) {
					Chat temp = (Chat) messobj.chat.elementAt(i);
					// chenmin

					String emote = temp.emote;
					if (emote.equals("����")) {
						emote = "";
					} else {
						emote += "��";
					}
					String temp_message;
					if (temp.chatUser.equals(strLoginName)) {
						if (temp.chatToUser.equals(strLoginName)) {
							temp_message = "ϵͳ��ʾ�����벻Ҫ�������" + "\n";
						} else {
							if (!temp.whisper) // �������Ļ�
							{
								temp_message = "���㡿�ԡ�" + temp.chatToUser + "��"
										+ emote + "˵��" + temp.chatMessage
										+ "\n";
							} else {
								temp_message = "���㡿���Ķԡ�" + temp.chatToUser
										+ "��" + emote + "˵��" + temp.chatMessage
										+ "\n";
							}
						}
					} else {
						if (temp.chatToUser.equals(strLoginName)) {
							if (!temp.whisper) // �������Ļ�
							{
								temp_message = "��" + temp.chatUser + "���ԡ��㡿"
										+ emote + "˵��" + temp.chatMessage
										+ "\n";
							} else {
								temp_message = "��" + temp.chatUser + "�����Ķԡ��㡿"
										+ emote + "˵��" + temp.chatMessage
										+ "\n";
							}
						} else {
							if (!temp.chatUser.equals(temp.chatToUser)) // �Է�û����������
							{
								if (!temp.whisper) // �������Ļ�
								{
									temp_message = "��" + temp.chatUser + "���ԡ�"
											+ temp.chatToUser + "��" + emote
											+ "˵��" + temp.chatMessage + "\n";
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

				// //////ˢ�������û�//////////
				lstUserList.clear();
				for (int i = 0; i < messobj.userOnLine.size(); i++) {
					String User = ((Customer) messobj.userOnLine.elementAt(i)).custName;
					lstUserList.addItem(User);
				}
				Integer a = new Integer(messobj.userOnLine.size());
				lblCount.setText(a.toString());
				// ��ʾ�û����������ҵ���Ϣ
				if (messobj.userOnLine.size() > intUserTotal) {
					// chenmin
					String tempstr = ((Customer) messobj.userOnLine
							.elementAt(messobj.userOnLine.size() - 1)).custName;
					// String tempstr = messobj.userOnLine.elementAt(
					// messobj.userOnLine.size() - 1).toString();
					if (!tempstr.equals(strLoginName)) {
						taUserMessage.append("��" + tempstr + "������" + "\n");
					}
				}
				// ��ʾ�û��뿪�����ҵ���Ϣ
				// ��ʾ�û��뿪�����ҵ���Ϣ
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
						if (!isFound) // û�з��ָ��û�
						{
							String tempstr = ((Customer) user_exit.elementAt(b)).custName;

							if (!tempstr.equals(strLoginName)) {
								taUserMessage.append("��" + tempstr + "������"
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
			JOptionPane.showMessageDialog(null, "�������ӷ�������");
			e.printStackTrace();
			frmChat.dispose();
			// System.out.println();
			// System.out.println(e.getMessage());
		}

	} // run()����

	private void exitChatRoom() {
		// TODO �Զ����ɷ������
		exit();
	}

	// /////////������ť��Ӧ//////////////
	public void actionPerformed(ActionEvent ae) {
		Object source = (Object) ae.getSource();
//		if (source.equals(btnTimer)) {
//			new Clock();
//		}
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
		if (source.equals(lstUserList)) // ˫���б��
		{
			changeUser();
		}
	} // actionPerformed()����

	// /////////�������ڹر���Ӧ//////////////
	class Windowclose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			exit();
		}
	}

	// "����"��ť
	public void clearMessage() {
		taUserMessage.setText("");
	}

	// "�˳�"��ť
	public void exit() {
		Exit exit = new Exit();
		exit.exitname = strLoginName;
		// �����˳���Ϣ
		try {
			Socket toServer = new Socket(strServerIp, 1001);
			// �������������Ϣ
			ObjectOutputStream outObj = new ObjectOutputStream(toServer
					.getOutputStream());
			outObj.writeObject(exit);
			outObj.close();
			toServer.close();

			frmChat.dispose();
			// this.destroy();
		} catch (Exception e) {
		}

	} // exit()����

	// "����"��ť
	public void sendMessage() {
		Chat chatobj = new Chat();
		chatobj.chatUser = strLoginName;
		chatobj.chatMessage = txtMessage.getText();
		chatobj.chatToUser = String.valueOf(cmbUser.getSelectedItem());
		chatobj.whisper = chPrivateChat.isSelected() ? true : false;
		chatobj.emote = emote.getSelectedItem().toString();
		// �������������Ϣ
		try {
			Socket toServer = new Socket(strServerIp, 1001);
			ObjectOutputStream outObj = new ObjectOutputStream(toServer
					.getOutputStream());
			outObj.writeObject(chatobj);
			txtMessage.setText(""); // ����ı���
			outObj.close();
			toServer.close();
		} catch (Exception e) {
		}
	} // sendMessage()����

	// "����"��ť
	public void saveMessage() {
		try {
			FileOutputStream fileoutput = new FileOutputStream(
					this.strLoginName + "_message.txt", true);
			String temp = taUserMessage.getText();
			// System.out.println(temp);
			fileoutput.write(temp.getBytes());
			fileoutput.close();
			JOptionPane.showMessageDialog(null, "�����¼������" + this.strLoginName
					+ "_message.txt");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ����ѡ�û���ӵ�cmbUser��
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
		headLabel.setIcon(new ImageIcon("face//" + head + ".JPG"));
	} // changeUser()����

	// chenmin
	protected void freshHead() {
		// TODO �Զ����ɷ������
		String head = getUserHead(cmbUser.getSelectedItem().toString());
		// JOptionPane.showMessageDialog(null, head);
		// cmbUser.setSelectedItem(selected);

		// chenmin
		headLabel.setIcon(new ImageIcon("face//" + head + ".JPG"));
	}

	// chenmin
	private String getUserHead(String selectedItem) {
		// TODO �Զ����ɷ������
		String head = "oo";
		for (int i = 0; i < messobj.userOnLine.size(); i++) {
			String User = ((Customer) messobj.userOnLine.elementAt(i)).custName;
			head = ((Customer) messobj.userOnLine.elementAt(i)).custHead;
			// System.out.println(User+":"+head);
			if (User.equals(selectedItem)) {
				break;
			}
			// lstUserList.addItem(User);
		}
		return head;
	}

	public static void main(String args[]) {
		new ChatRoom("�����û�", "127.0.0.1");
	}
}