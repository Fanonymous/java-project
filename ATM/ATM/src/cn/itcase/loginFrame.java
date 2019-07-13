package cn.itcase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import cn.itcase.dao.userdao;
import cn.itcase.shuju.users;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class loginFrame extends javax.swing.JFrame {
	private JLabel labwelcom;//��ӭ��½"�й�����"�ı�ǩ
	 JLabel bj;//�屳��ͼƬ�ı�ǩ
	private JLabel labid;//�����ʺ���ʾ��ǩ
	private JTextField tetid;//�����ʺŵ��ı���
	private JButton butzhuce;//ע�ᰴť
	private JButton butcancel;//ȡ����ť
	private JButton butconfirm;//��¼��ť
	private JPasswordField textpassword;//����������ı���
	private JLabel labpassword;//�����������ʾ��ǩ

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				loginFrame inst = new loginFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public loginFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(440, 384);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u767b\u9646");
			this.setResizable(false);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			{
				labwelcom = new JLabel();
				getContentPane().add(labwelcom);
				labwelcom.setText("\u6b22\u8fce\u767b\u9646\u4e2d\u56fd\u94f6\u884c");
				labwelcom.setBounds(158, 59, 262, 51);
				labwelcom.setFont(new java.awt.Font("΢���ź�",1,26));
				labwelcom.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				labid = new JLabel();
				getContentPane().add(labid);
				labid.setText("\u8bf7\u8f93\u5165\u8d26\u53f7\uff1a");
				labid.setBounds(72, 116, 132, 53);
				labid.setFont(new java.awt.Font("΢���ź�",1,20));
			}
			{
				labpassword = new JLabel();
				getContentPane().add(labpassword);
				labpassword.setText("\u8bf7\u8f93\u5165\u5bc6\u7801\uff1a");
				labpassword.setBounds(72, 194, 132, 53);
				labpassword.setFont(new java.awt.Font("΢���ź�",1,20));
			}
			{
				tetid = new JTextField();
				getContentPane().add(tetid);
				tetid.setBounds(216, 133, 204, 24);
			}
			{
				textpassword = new JPasswordField();
				getContentPane().add(textpassword);
				textpassword.setBounds(216, 211, 204, 24);
			}
			{
				butconfirm = new JButton();
				getContentPane().add(butconfirm);
				butconfirm.setText("\u767b\u9646");
				butconfirm.setBounds(238, 329, 81, 40);
				butconfirm.setFont(new java.awt.Font("΢���ź�",1,12));
				butconfirm.addActionListener(new ActionListener() {
					//��½��ť�����¼�
					public void actionPerformed(ActionEvent evt) {
						//1.����û�������˺ź�����
						String ucnoid =new String(tetid.getText());
						//����û���������룬�÷��������һ���ַ����飬����ͨ��String�Ĺ��췽���������ַ����鴴��Ϊ�ַ���
						String password = new String(textpassword.getPassword());
						//����userdao���һ������
						userdao us1=new userdao();
						boolean boo = us1.login(ucnoid, password);
						if(boo){
							Share.count=ucnoid;
							//��¼�ɹ�������ת��������
							//�������������
							mainFrame main = new mainFrame();
							//������������ʾ
							main.setVisible(true);
							//�õ�ǰ��������
							loginFrame.this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(loginFrame.this, "��¼ʧ��!");
						}
					}
				});
			}
			{
				butcancel = new JButton();
				getContentPane().add(butcancel);
				butcancel.setText("\u53d6\u6d88");
				butcancel.setBounds(420, 329, 81, 40);
				butcancel.setFont(new java.awt.Font("΢���ź�",1,12));
				butcancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//ȡ����ť�����¼�
						System.exit(0);
					}
				});
			}
			pack();
			this.setSize(589, 455);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		
		{
			butzhuce = new JButton();
			getContentPane().add(butzhuce);
			butzhuce.setText("\u6ce8\u518c");
			butzhuce.setBounds(60, 329, 81, 40);
			butzhuce.setFont(new java.awt.Font("΢���ź�",1,12));
			butzhuce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//ע�ᰴť�����¼�
					zhuceFrame zhuce=new zhuceFrame();
					zhuce.setVisible(true);
					loginFrame.this.dispose();
				}
			});
		}
		bj=new JLabel(new ImageIcon("picture./bj.jpg"));
		add(bj);
		bj.setLocation(0, 0);
		bj.setBounds(-5, 0, 594, 437);
	}
	


}
class Share{
	static String count;
}
