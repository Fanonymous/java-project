package com.legendary.chat;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import com.legendary.Dao.userRegister;
import com.legendary.Dao.userRegisterDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class registerJFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 901974612751722190L;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ValidCode vcode;
	String  strServerIp="127.0.0.1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerJFrame frame = new registerJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 产生随机帐号
	private static final int MAX_GENERATE_COUNT = 99999;
	private static int generateCount = 0;

	public synchronized String getUniqueString() {
		if (generateCount > 99999)
			generateCount = 0;
		String uniqueNumber = Long.toString(System.currentTimeMillis()) + Integer.toString(generateCount);
		generateCount++;
		return uniqueNumber;
	}

	/**
	 * Create the frame.
	 */
	public registerJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(registerJFrame.class.getResource("/images/title.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 346, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u6CE8\u518C\u5E10\u53F7");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("仿宋", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 10, 81, 25);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 391, 2);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("\u6635\u79F0");
		lblNewLabel.setFont(new Font("仿宋", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(37, 59, 54, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("仿宋", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(37, 94, 54, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("仿宋", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(16, 129, 75, 15);
		panel.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u6027\u522B");
		label_1.setFont(new Font("仿宋", Font.BOLD, 13));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(37, 165, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u6240\u5728\u5730");
		label_2.setFont(new Font("仿宋", Font.BOLD, 13));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(37, 233, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u9A8C\u8BC1\u7801");
		label_3.setFont(new Font("仿宋", Font.BOLD, 13));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(37, 258, 54, 15);
		panel.add(label_3);
		
		
		JLabel label_4 = new JLabel("\u624B\u673A\u53F7");
		label_4.setFont(new Font("仿宋", Font.BOLD, 13));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(37, 318, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u751F\u65E5");
		label_5.setFont(new Font("仿宋", Font.BOLD, 13));
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(37, 201, 54, 15);
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(118, 61, 136, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 96, 136, 21);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(118, 126, 136, 21);
		panel.add(passwordField_1);
		
		final JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setBounds(118, 161, 81, 23);
		panel.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(201, 161, 81, 23);
		panel.add(radioButton_1);
		
		ButtonGroup sex=new ButtonGroup();
		sex.add(radioButton);
		sex.add(radioButton_1);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 198, 136, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(118, 230, 136, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		vcode=new ValidCode();
		vcode.setBounds(230, 260, 50,30);
		panel.add(vcode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(118, 315, 136, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4\u6CE8\u518C");
		button.setFont(new Font("仿宋", Font.BOLD, 16));
		button.setBounds(118, 373, 136, 40);
		panel.add(button);
		
		textField_4 = new JTextField();
		textField_4.setBounds(118, 258, 88, 34);
		panel.add(textField_4);
		textField_4.setColumns(10);
				
		button.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
                
                if (!isValidCodeRight()) {  
                    JOptionPane.showMessageDialog(registerJFrame.this, "验证码错误！");  
                }
                if (isValidCodeRight()) { 
                	String accountNumber=getUniqueString();
    				String nickname=textField.getText();
    				String password=passwordField.getText();
    				String password1=passwordField_1.getText();
    				String sex=null;
                    if(radioButton.isSelected()){
                    	sex=radioButton.getText();
    				}else{
    					sex=radioButton_1.getText();
    				}
                    String birthday=textField_1.getText();
                    String location=textField_2.getText();
                    String tel=textField_3.getText();
                    userRegister user=new userRegister();
                    user.setAccountNumber(accountNumber);
                    user.setNickname(nickname);
                    user.setPassword(password1);
                    user.setSex(sex);
                    user.setBirthday(birthday);
                    user.setLocation(location);
                    user.setTel(tel);
                  //验证用户名是否为空
            		if(user.getNickname().length()==0)
            		{
            		    JOptionPane.showMessageDialog(null,"用户名不能为空");	
                        return;	
            		}
            		//验证密码是否为空
            		if(user.getPassword().length()==0)
            		{
            		    JOptionPane.showMessageDialog(null,"密码不能为空");	
                        return;	
            		}
            		//验证密码的一致性
            		if(!user.getPassword().equals(passwordField_1.getText()))
            		{
            		    JOptionPane.showMessageDialog(null,"密码两次输入不一致，请重新输入");	
                        return;
            		}
            		
            		//验证生日是否为空
            		if(user.getBirthday().length()==0)
            		{
            		    JOptionPane.showMessageDialog(null,"生日不能为空");	
                        return;	
            		}
            		
            		//验证所在地是否为空
            		if(user.getLocation().length()==0)
            		{
            		    JOptionPane.showMessageDialog(null,"所在地不能为空");	
                        return;	
            		}
                    
            		
            		//验证手机号是否为空
            		if(user.getTel().length()==0)
            		{
            		    JOptionPane.showMessageDialog(null,"手机号不能为空");	
                        return;	
            		}
                    
            		if(user.getTel().length()<11)
            		{
            		    JOptionPane.showMessageDialog(null,"手机号输入非法");	
                        return;	
            		}
                    
            		
            		userRegisterDao userdao=new userRegisterDao();
                    int result=userdao.zhuce(user);
                    if(result>0){
                    	
                    	try
                		{
                		    //连接到服务器
                		    Socket toServer;
                  		    toServer = new Socket(strServerIp,1001);
                		    ObjectOutputStream streamToServer=new ObjectOutputStream (toServer.getOutputStream());					
                		    //写客户详细资料到服务器socket
                		    //userRegister user=new userRegister();
                		    streamToServer.writeObject((userRegister)user);
                            //读来自服务器socket的登陆状态
                            BufferedReader fromServer=new BufferedReader(new InputStreamReader(toServer.getInputStream()));
                            //String status=fromServer.readLine();
                            //显示成功消息
                            //JOptionPane op=new JOptionPane();
                            //op.showMessageDialog(null,status);
                           
                            //关闭流对象
                		    streamToServer.close();
                            fromServer.close();
                         }
                		 catch(InvalidClassException e1)
                		 {
                		    JOptionPane.showMessageDialog(null,"类错误!");
                		 }
                		 catch(NotSerializableException e2)
                		 {
                			JOptionPane.showMessageDialog(null,"对象未序列化!");
                		 }
                		 catch(IOException e3)
                		 {
                		 	JOptionPane.showMessageDialog(null,"不能写入到指定服务器!");
                		 }
                    	
                               	
                    	JOptionPane.showMessageDialog(registerJFrame.this, "注册成功！您的帐号:"+accountNumber);
                    	registerJFrame.this.dispose();
                    	loginJFrame login=new loginJFrame();
                    	login.setVisible(true);
                    }else{
                    	JOptionPane.showMessageDialog(registerJFrame.this, "注册失败！");
                    }
            		
            		
            		
            		
            		
            		
                    
                    
                    
                }
                
                
                                
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public void actionPerformed(ActionEvent e) {

	}
	
	   /** 
     * 验证码的校验 
     *  
     * @return 
     */  
    public boolean isValidCodeRight() {  
  
        if (textField_4 == null) {  
            return false;  
        }  
        if (vcode == null) {  
            return true;  
        }  
        if (vcode.getCode().equals(textField_4.getText())) {  
            return true;  
        }  
        return false;  
    }  
}
