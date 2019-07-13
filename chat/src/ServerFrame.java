
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.*;

//////////*服务器窗口类*///////////////
public class ServerFrame extends JFrame implements ActionListener {
	public  JList list;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8936397327038098620L;

	// 服务器信息面板
	JPanel pnlServer, pnlServerInfo;

	JLabel lblStatus, lblNumber, lblMax, lblServerName, lblProtocol, lblIP,
			lblPort, lblLog;

	public JTextField txtStatus, txtNumber, txtMax, txtServerName, txtProtocol, txtIP,
			txtPort;

	JButton btnStop, btnSaveLog;

	public TextArea taLog;

	JTabbedPane tpServer;

	public TextArea taMessage;

	// 用户信息面板
	JPanel pnlUser;

	public JLabel lblMessage, lblUser, lblNotice, lblUserCount;

	JList lstUser;

	JScrollPane spUser;

	JTextField txtNotice;

	JButton btnSend, btnKick;
	
	public String ti = "";
	
	public String serverMessage ="";

	public ServerFrame() {
		// 服务器窗口
		super("[HappyChat]聊天服务器");
		setSize(550, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();// 在屏幕居中显示
		Dimension fra = this.getSize();
		if (fra.width > scr.width) {
			fra.width = scr.width;
		}
		if (fra.height > scr.height) {
			fra.height = scr.height;
		}
		this.setLocation((scr.width - fra.width) / 2,
				(scr.height - fra.height) / 2);

		// ==========服务器信息面板=========================
		pnlServer = new JPanel();
		pnlServer.setLayout(null);
		pnlServer.setBackground(new Color(176, 196, 222));

		pnlServerInfo = new JPanel(new GridLayout(14, 1));
		pnlServerInfo.setBackground(new Color(100, 149, 237));
		pnlServerInfo.setFont(new Font("宋体", 0, 12));
		pnlServerInfo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(""), BorderFactory
						.createEmptyBorder(1, 1, 1, 1)));

		lblStatus = new JLabel("当前状态:");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtStatus = new JTextField(10);
		txtStatus.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatus.setBackground(Color.decode("#d6f4f2"));
		txtStatus.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtStatus.setEditable(false);

		lblNumber = new JLabel("当前在线人数:");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setForeground(Color.BLACK);
		lblNumber.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtNumber = new JTextField("0 人", 10);
		txtNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumber.setForeground(Color.BLACK);
		txtNumber.setBackground(Color.decode("#d6f4f2"));
		txtNumber.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtNumber.setEditable(false);

		lblMax = new JLabel("最多在线人数:");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setForeground(Color.BLACK);
		lblMax.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtMax = new JTextField("50 人", 10);
		txtMax.setHorizontalAlignment(SwingConstants.CENTER);
		txtMax.setBackground(Color.decode("#d6f4f2"));
		txtMax.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtMax.setEditable(false);

		lblServerName = new JLabel("服务器名称:");
		lblServerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblServerName.setForeground(Color.BLACK);
		lblServerName.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtServerName = new JTextField(10);
		txtServerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtServerName.setForeground(Color.BLACK);
		txtServerName.setBackground(Color.decode("#d6f4f2"));
		txtServerName.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtServerName.setEditable(false);

		lblProtocol = new JLabel("访问协议:");
		lblProtocol.setHorizontalAlignment(SwingConstants.CENTER);
		lblProtocol.setForeground(Color.BLACK);
		lblProtocol.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtProtocol = new JTextField("HTTP", 10);
		txtProtocol.setHorizontalAlignment(SwingConstants.CENTER);
		txtProtocol.setForeground(Color.BLACK);
		txtProtocol.setBackground(Color.decode("#d6f4f2"));
		txtProtocol.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtProtocol.setEditable(false);

		lblIP = new JLabel("服务器IP:");
		lblIP.setHorizontalAlignment(SwingConstants.CENTER);
		lblIP.setForeground(Color.BLACK);
		lblIP.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtIP = new JTextField(10);
		txtIP.setHorizontalAlignment(SwingConstants.CENTER);
		txtIP.setForeground(Color.BLACK);
		txtIP.setBackground(Color.decode("#d6f4f2"));
		txtIP.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtIP.setEditable(false);

		lblPort = new JLabel("服务器端口:");
		lblPort.setHorizontalAlignment(SwingConstants.CENTER);
		lblPort.setForeground(Color.BLACK);
		lblPort.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtPort = new JTextField("8000", 10);
		txtPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort.setForeground(Color.BLACK);
		txtPort.setBackground(Color.decode("#d6f4f2"));
		txtPort.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtPort.setEditable(false);

		btnStop = new JButton("关闭服务器(C)");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeServer();
			}
		});
		btnStop.setBackground(Color.WHITE);
		btnStop.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		lblLog = new JLabel("\u670D\u52A1\u5668\u65E5\u5FD7");
		lblLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblLog.setForeground(Color.BLACK);
		lblLog.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		taLog = new TextArea(20, 50);
		taLog.setFont(new Font("宋体", 0, 12));
		btnSaveLog = new JButton("保存日志(S)");
		btnSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveLog();
			}
		});
		btnSaveLog.setBackground(Color.WHITE);
		btnSaveLog.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		pnlServerInfo.add(lblStatus);
		pnlServerInfo.add(txtStatus);
		pnlServerInfo.add(lblNumber);
		pnlServerInfo.add(txtNumber);
		pnlServerInfo.add(lblMax);
		pnlServerInfo.add(txtMax);
		pnlServerInfo.add(lblServerName);
		pnlServerInfo.add(txtServerName);
		pnlServerInfo.add(lblProtocol);
		pnlServerInfo.add(txtProtocol);
		pnlServerInfo.add(lblIP);
		pnlServerInfo.add(txtIP);
		pnlServerInfo.add(lblPort);
		pnlServerInfo.add(txtPort);

		pnlServerInfo.setBounds(5, 5, 100, 400);
		lblLog.setBounds(110, 5, 100, 30);
		taLog.setBounds(110, 35, 400, 370);
		btnStop.setBounds(177, 411, 120, 30);
		btnSaveLog.setBounds(341, 411, 120, 30);
		pnlServer.add(pnlServerInfo);
		pnlServer.add(lblLog);
		pnlServer.add(taLog);
		pnlServer.add(btnStop);
		pnlServer.add(btnSaveLog);
		// ===========在线用户面板====================
		pnlUser = new JPanel();
		pnlUser.setLayout(null);
		pnlUser.setBackground(new Color(176, 196, 222));
		pnlUser.setFont(new Font("宋体", 0, 12));
		lblMessage = new JLabel("\u7528\u6237\u6D88\u606F");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblMessage.setForeground(Color.BLACK);
		taMessage = new TextArea(20, 20);
		taMessage.setFont(new Font("宋体", 0, 12));
		lblNotice = new JLabel("通知：");
		lblNotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotice.setForeground(Color.BLACK);
		lblNotice.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtNotice = new JTextField(20);
		txtNotice.setFont(new Font("宋体", 0, 12));
		btnSend = new JButton("发送(S)");
		btnSend.setBackground(Color.WHITE);
		btnSend.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnSend.setEnabled(true);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverMessage();
			}
		});

		lblUserCount = new JLabel("在线总人数 0 人");
		lblUserCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserCount.setForeground(Color.BLACK);
		lblUserCount.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		btnKick = new JButton("\u5F3A\u5236\u9000\u51FA(K)");
		btnKick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tiRen();
			}
		});
		btnKick.setBackground(Color.WHITE);
		btnKick.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblUser = new JLabel("\u5728\u7EBF\u7528\u6237\u5217\u8868");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblUser.setForeground(Color.BLACK);

		lstUser = new JList();
		lstUser.setFont(new Font("宋体", 0, 12));
		lstUser.setVisibleRowCount(17);
		lstUser.setFixedCellWidth(180);
		lstUser.setFixedCellHeight(18);
		// lstUser.setListData(listVector);

		spUser = new JScrollPane();
		spUser.setBackground(Color.decode("#d6f4f2"));
		spUser.setFont(new Font("宋体", 0, 12));
		// spUser.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spUser
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spUser.getViewport().setView(lstUser);

		lblMessage.setBounds(5, 5, 71, 25);
		taMessage.setBounds(5, 35, 300, 360);
		lblUser.setBounds(310, 5, 100, 25);
		spUser.setBounds(310, 35, 220, 360);
		lblNotice.setBounds(5, 410, 40, 25);
		txtNotice.setBounds(50, 410, 160, 25);
		btnSend.setBounds(220, 410, 80, 25);
		lblUserCount.setBounds(320, 410, 90, 25);
		btnKick.setBounds(420, 410, 100, 25);

		pnlUser.add(lblMessage);
		pnlUser.add(taMessage);
		pnlUser.add(lblUser);
		pnlUser.add(spUser);

		list = new JList();
		list.setListData(new String[] { "" });
		//list.setModel(null);
		//.setListData(null);
		spUser.setViewportView(list);
		//list.setListData(null);
		pnlUser.add(lblNotice);
		pnlUser.add(txtNotice);
		pnlUser.add(btnSend);
		pnlUser.add(lblUserCount);
		pnlUser.add(btnKick);

		// ============主标签面板========================

		tpServer = new JTabbedPane(JTabbedPane.TOP);
		tpServer.setBackground(Color.decode("#d6f4f2"));
		tpServer.setFont(new Font("宋体", 0, 12));
		tpServer.add("服务器管理", pnlServer);
		tpServer.add("用户信息管理", pnlUser);
		this.getContentPane().add(tpServer);
		setVisible(true);
	}

	protected void serverMessage() {
		// TODO 自动生成方法存根
		this.serverMessage = txtNotice.getText();
		txtNotice.setText("");
	}

	protected void closeServer() {
		// TODO 自动生成方法存根
		this.dispose();
		//this.res
	}

	protected void saveLog() {
		// TODO 自动生成方法存根
		try {
			FileOutputStream fileoutput = new FileOutputStream("log.txt",
					true);
			String temp = taMessage.getText();
			//System.out.println(temp);
			fileoutput.write(temp.getBytes());
			fileoutput.close();
			JOptionPane.showMessageDialog(null, "记录保存在log.txt");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void tiRen() {
		// TODO 自动生成方法存根
//		System.out.println("Ti:"+list.getSelectedValue().toString());
		ti = list.getSelectedValue().toString();
		log("Ti:"+ti);
	}

	private void log(String string) {
		// TODO 自动生成方法存根
		String newta = taMessage.getText();
		newta += ("\n"+string);
		taMessage.setText(newta);
	}

	public void actionPerformed(ActionEvent evt) {

	}

	public static void main(String args[]) {
		new ServerFrame();
	}
}