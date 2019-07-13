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
 * Title: HappyChat聊天系统服务器程序
 * </p>
 * <p>
 * Description: 聊天服务器
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
 * 封装注册信息 <br />
 * 用于发送聊天和在线用户的信息 <br />
 * 聊天信息序列化<br />
 * 退出信息序列化<br />
 * 
 * @author 刘志成
 * @version 1.0
 */
public class Connection extends Thread {
	/**
	 * 与客户端通讯Socket
	 */
	private Socket netClient;

	/**
	 * 在线用户列表
	 */
	private Vector<Customer> userOnline;

	/**
	 * 聊天信息
	 */
	private Vector<Chat> userChat;

	/**
	 * 从客户到服务器 输入流
	 */
	private ObjectInputStream fromClient;

	/**
	 * 传到客户端 打印流
	 */
	private PrintStream toClient;

	/**
	 * 注册用户列表
	 */
	private static Vector vList = new Vector();

	/**
	 * 临时对象
	 */
	private Object obj;

	/**
	 * 服务器日志窗体
	 */
	private ServerFrame sFrame;

	@SuppressWarnings("unchecked")
	/**
	 * 创建与客户端通讯
	 */
	public Connection(ServerFrame frame, Socket client, Vector u, Vector c) {
		netClient = client;
		userOnline = u;
		userChat = c;
		sFrame = frame;
		try {
			// 发生双向通信
			// 检索客户输入
			fromClient = new ObjectInputStream(netClient.getInputStream());

			// 服务器写到客户
			toClient = new PrintStream(netClient.getOutputStream());
		} catch (IOException e) {
			try {
				netClient.close();
			} catch (IOException e1) {
				System.out.println("不能建立流" + e1);
				return;
			}
		}
		this.start();
	}

	/**
	 * 处理与客户端的通讯线程
	 */
	public void run() {
		try {// obj是Object类的对象
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
			System.out.println("读对象发生错误！" + e1);
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
	 * 登录处理
	 */
	@SuppressWarnings("deprecation")
	public void serverLogin() {

		try {
			Customer clientMessage2 = (Customer) obj;

			// 读文件
//			FileInputStream file3 = new FileInputStream("user.txt");
//			ObjectInputStream objInput1 = new ObjectInputStream(file3);
//			vList = (Vector) objInput1.readObject();
			userRegisterDao use=new userRegisterDao();
			vList=use.getAll();
			
			int find = 0; // 查找判断标志
		
			for (int i = 0; i < vList.size(); i++) {
				userRegister reg = (userRegister) vList.elementAt(i);

				if (reg.getAccountNumber().equals(clientMessage2.custName)) {
					find = 1;
					if (!reg.getPassword().equals(clientMessage2.custPassword)) {
						toClient.println("密码不正确");
						break;
					} else {
						// 判断是否已经登录
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
							toClient.println("登录人数过多，请稍候再试");
							break;
						}

						if (login_flag == 0) {
							
							userOnline.addElement(clientMessage2);
						
							// // 将该用户名何在
							toClient.println("登录成功");
							Date t = new Date();
							// System.out.println("用户" + clientMessage2.custName
							// + "登录成功，" + "登录时间:" + t.toLocaleString()
							// + "\n");
							log("用户" + clientMessage2.custName + "登录成功，"
									+ "登录时间:" + t.toLocaleString() + "\n");
							freshServerUserList();
							break;
						} else {
							toClient.println("该用户已登录");
						}
					}
				} else {
					continue;
				}
			}
			if (find == 0) {
				toClient.println("没有这个用户，请先注册");
			}


			fromClient.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * 刷新服务器日志窗体在线列表
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
		sFrame.lblUserCount.setText("当前在线人数:" + userOnline.size());
		// System.out.println("fresh ok");
	}

	/**
	 * 注册处理
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	public void serverRegiste() {
		try {
			int flag = 0; // 是否重名判断标志
			userRegister clientMessage = (userRegister) obj;
			
			userRegisterDao use=new userRegisterDao();
			vList=use.getAll();
			
			
			
			if (flag == 0) {
				// 添加新注册用户
				vList.addElement(clientMessage);
				// 将向量中的类写回文件
			
				// 发送注册成功信息
				toClient.println(clientMessage.getAccountNumber() + "注册成功");
				Date t = new Date();
				// append("用户"+clientMessage.custName+"注册成功!;注册时间:"+t.toLocaleString()+"\n");
				// System.out.println("用户" + clientMessage.custName + "注册成功, "
				// + "注册时间:" + t.toLocaleString() + "\n");
				// chenmin
				log("用户" + clientMessage.getAccountNumber() + "注册成功, " + "注册时间:"
						+ t.toLocaleString() + "\n");
				
				fromClient.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * 发送信息处理
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
	 * 增加信息处理
	 */
	public void serverChat() {
		// 将接收到的对象值赋给聊天信息的序列化对象
		Chat cObj = new Chat();
		cObj = (Chat) obj;

		// chenmin
		

		chatLog(cObj);

		// 将聊天信息的序列化对象填加到保存聊天信息的矢量中

		userChat.addElement((Chat) cObj);
		return;
	}

	/**
	 * 用户退出处理
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

		log("用户" + exit.exitname + "已经退出, " + "退出时间:" + t.toLocaleString());

		freshServerUserList();
	}

	/**
	 * 在线用户中删除退出用户
	 * 
	 * @param exit 退出用户名对象
	 */
	private void removeUser(Exit exit) {
		// TODO 自动生成方法存根
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
	 * 日志服务器窗体写 信息
	 * @param log 日志信息
	 */
	public void log(String log) {
		String newlog = sFrame.taLog.getText() + "\n" + log;
		sFrame.taLog.setText(newlog);
	}

	/**
	 * 	
	 * 日志服务器窗体写聊天 信息
	 * @param obj 聊天 信息对象
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