package com.legendary.chat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;

import com.legendary.Dao.userRegister;
import com.legendary.Dao.userRegisterDao;

/**
 * <p>
 * Title: HappyChat����ϵͳ����������
 * </p>
 * <p>
 * Description: ���������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Filename: Connection.java
 * </p>
 * 
 * 
 * 
 * ��װע����Ϣ <br />
 * ���ڷ�������������û�����Ϣ <br />
 * ������Ϣ���л�<br />
 * �˳���Ϣ���л�<br />
 * 
 * @author ��־��
 * @version 1.0
 */
public class Connection extends Thread {
	/**
	 * ��ͻ���ͨѶSocket
	 */
	private Socket netClient;

	/**
	 * �����û��б�
	 */
	private Vector<Customer> userOnline;

	/**
	 * ������Ϣ
	 */
	private Vector<Chat> userChat;

	/**
	 * �ӿͻ��������� ������
	 */
	private ObjectInputStream fromClient;

	/**
	 * �����ͻ��� ��ӡ��
	 */
	private PrintStream toClient;

	/**
	 * ע���û��б�
	 */
	private static Vector vList = new Vector();

	/**
	 * ��ʱ����
	 */
	private Object obj;

	/**
	 * ��������־����
	 */
	private ServerFrame sFrame;

	@SuppressWarnings("unchecked")
	/**
	 * ������ͻ���ͨѶ
	 */
	public Connection(ServerFrame frame, Socket client, Vector u, Vector c) {
		netClient = client;
		userOnline = u;
		userChat = c;
		sFrame = frame;
		try {
			// ����˫��ͨ��
			// �����ͻ�����
			fromClient = new ObjectInputStream(netClient.getInputStream());

			// ������д���ͻ�
			toClient = new PrintStream(netClient.getOutputStream());
		} catch (IOException e) {
			try {
				netClient.close();
			} catch (IOException e1) {
				System.out.println("���ܽ�����" + e1);
				return;
			}
		}
		this.start();
	}

	/**
	 * ������ͻ��˵�ͨѶ�߳�
	 */
	public void run() {
		try {// obj��Object��Ķ���
			obj = (Object) fromClient.readObject();
			if (obj.getClass().getName().equals("Customer")) {
				serverLogin();
			}
			if (obj.getClass().getName().equals("Register_Customer")) {
				serverRegiste();
			}
			if (obj.getClass().getName().equals("Message")) {
				serverMessage();
			}
			if (obj.getClass().getName().equals("Chat")) {
				serverChat();
			}
			if (obj.getClass().getName().equals("Exit")) {
				serverExit();
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e1) {
			System.out.println("������������" + e1);
		} finally {
			try {
				netClient.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * 
	 * ��¼����
	 */
	@SuppressWarnings("deprecation")
	public void serverLogin() {

		try {
			Customer clientMessage2 = (Customer) obj;

			// ���ļ�
//			FileInputStream file3 = new FileInputStream("user.txt");
//			ObjectInputStream objInput1 = new ObjectInputStream(file3);
//			vList = (Vector) objInput1.readObject();
			userRegisterDao use=new userRegisterDao();
			vList=use.getAll();
			
			int find = 0; // �����жϱ�־
		
			for (int i = 0; i < vList.size(); i++) {
				userRegister reg = (userRegister) vList.elementAt(i);

				if (reg.getAccountNumber().equals(clientMessage2.custName)) {
					find = 1;
					if (!reg.getPassword().equals(clientMessage2.custPassword)) {
						toClient.println("���벻��ȷ");
						break;
					} else {
						// �ж��Ƿ��Ѿ���¼
						int login_flag = 0;
						for (int a = 0; a < userOnline.size(); a++) {
							// chenmin
							String _custName = ((Customer) userOnline
									.elementAt(a)).custName;
							if (clientMessage2.custName.equals(_custName)) {
								login_flag = 1;
								break;
							}
						}

						if (userOnline.size() >= 50) {
							toClient.println("��¼�������࣬���Ժ�����");
							break;
						}

						if (login_flag == 0) {
							
							userOnline.addElement(clientMessage2);
						
							// // �����û�������
							toClient.println("��¼�ɹ�");
							Date t = new Date();
							// System.out.println("�û�" + clientMessage2.custName
							// + "��¼�ɹ���" + "��¼ʱ��:" + t.toLocaleString()
							// + "\n");
							log("�û�" + clientMessage2.custName + "��¼�ɹ���"
									+ "��¼ʱ��:" + t.toLocaleString() + "\n");
							freshServerUserList();
							break;
						} else {
							toClient.println("���û��ѵ�¼");
						}
					}
				} else {
					continue;
				}
			}
			if (find == 0) {
				toClient.println("û������û�������ע��");
			}


			fromClient.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * ˢ�·�������־���������б�
	 * 
	 */
	private void freshServerUserList() {
		String[] userList = new String[50];
		Customer cus = null;
		for (int j = 0; j < userOnline.size(); j++) {
			cus = (Customer) userOnline.get(j);
			userList[j] = cus.custName;
		}
		sFrame.list.setListData(userList);
		sFrame.txtNumber.setText("" + userOnline.size());
		sFrame.lblUserCount.setText("��ǰ��������:" + userOnline.size());
		// System.out.println("fresh ok");
	}

	/**
	 * ע�ᴦ��
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	public void serverRegiste() {
		try {
			int flag = 0; // �Ƿ������жϱ�־
			userRegister clientMessage = (userRegister) obj;
			
			userRegisterDao use=new userRegisterDao();
			vList=use.getAll();
			
			
			
			if (flag == 0) {
				// �����ע���û�
				vList.addElement(clientMessage);
				// �������е���д���ļ�
			
				// ����ע��ɹ���Ϣ
				toClient.println(clientMessage.getAccountNumber() + "ע��ɹ�");
				Date t = new Date();
				// append("�û�"+clientMessage.custName+"ע��ɹ�!;ע��ʱ��:"+t.toLocaleString()+"\n");
				// System.out.println("�û�" + clientMessage.custName + "ע��ɹ�, "
				// + "ע��ʱ��:" + t.toLocaleString() + "\n");
				// chenmin
				log("�û�" + clientMessage.getAccountNumber() + "ע��ɹ�, " + "ע��ʱ��:"
						+ t.toLocaleString() + "\n");
				
				fromClient.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * ������Ϣ����
	 */
	public void serverMessage() {
		try {
			Message mess = new Message();
			mess.userOnLine = userOnline;
			mess.chat = userChat;
			mess.ti = sFrame.ti;
			mess.serverMessage = "" + sFrame.serverMessage;
			// log("s:" + mess.serverMessage);
			// chenmin
			// mess.chat = WordFilter.filter(mess.chat.get(index));

			ObjectOutputStream outputstream = new ObjectOutputStream(netClient
					.getOutputStream());
			outputstream.writeObject((Message) mess);

			// server list
			// sFrame.list.setListData(new String[] { "3", "4", "5" });
			netClient.close();
			outputstream.close();
		} catch (IOException e) {
		}

	}

	/**
	 * ������Ϣ����
	 */
	public void serverChat() {
		// �����յ��Ķ���ֵ����������Ϣ�����л�����
		Chat cObj = new Chat();
		cObj = (Chat) obj;

		// chenmin
		

		chatLog(cObj);

		// ��������Ϣ�����л�������ӵ�����������Ϣ��ʸ����

		userChat.addElement((Chat) cObj);
		return;
	}

	/**
	 * �û��˳�����
	 */
	@SuppressWarnings("deprecation")
	public void serverExit() {
		Exit exit = new Exit();
		exit = (Exit) obj;

		removeUser(exit);
		// chenmin
		if (sFrame.ti.equals(exit.exitname)) {
			sFrame.ti = "";
		}

		Date t = new Date();

		log("�û�" + exit.exitname + "�Ѿ��˳�, " + "�˳�ʱ��:" + t.toLocaleString());

		freshServerUserList();
	}

	/**
	 * �����û���ɾ���˳��û�
	 * 
	 * @param exit �˳��û�������
	 */
	private void removeUser(Exit exit) {
		// TODO �Զ����ɷ������
		Vector<Customer> vec = new Vector<Customer>();
		Customer _cus = null;
		for (int j = 0; j < userOnline.size(); j++) {
			_cus = (Customer) userOnline.get(j);
			if (!exit.exitname.equals(_cus.custName)) {
				vec.add(_cus);
			}
			// System.out.println("list:"+_cus.custName);
		}
		userOnline.removeAllElements();
		for (int j = 0; j < vec.size(); j++) {
			_cus = (Customer) vec.get(j);
			userOnline.add(_cus);
		}
		// userOnline = vec;

	}

	/**
	 * ��־����������д ��Ϣ
	 * @param log ��־��Ϣ
	 */
	public void log(String log) {
		String newlog = sFrame.taLog.getText() + "\n" + log;
		sFrame.taLog.setText(newlog);
	}

	/**
	 * 	
	 * ��־����������д���� ��Ϣ
	 * @param obj ���� ��Ϣ����
	 */
	@SuppressWarnings("deprecation")
	public void chatLog(Chat obj) {
		String newlog = sFrame.taMessage.getText();
		Date date = new Date();
		if (!obj.whisper) {
			newlog += "\n";
			newlog += ("[" + date.getHours() + ":" + date.getMinutes() + ":"
					+ date.getSeconds() + "]");
			newlog += obj.chatUser;
			newlog += "->";
			newlog += obj.chatToUser;
			newlog += ":";
			newlog += obj.chatMessage;
		}

		sFrame.taMessage.setText(newlog);
	}
}