package cn.itcase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import cn.itcase.dao.userdao;
import cn.itcase.shuju.cards;
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
public class zhuceFrame extends javax.swing.JFrame {
	private JLabel labzhuce;
	private JTextField textpassword;
	private JLabel labsex;
	private ButtonGroup sexGroup1;
	private JButton butcancel;
	private JButton butzhuce;
	private JTextField textcardid;
	private JLabel labcardid;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private JTextField textname;
	private JLabel labpassword;
	private JLabel labname;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				zhuceFrame inst = new zhuceFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public zhuceFrame() {
		super();
		initGUI();
	}
	//�����������
	private static final int MAX_GENERATE_COUNT = 99999;
    private static int generateCount = 0;
	public  synchronized String getUniqueString()
        {
            if(generateCount > 99999)
                generateCount = 0;
            String uniqueNumber = Long.toString(System.currentTimeMillis()) + Integer.toString(generateCount);
            generateCount++;
            return uniqueNumber;
        }
        
	 

	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("\u6b22\u8fce\u60a8\u4f7f\u7528\u4e2d\u56fd\u94f6\u884c");
			getContentPane().setLayout(null);
			this.setResizable(false);
			{
				labzhuce = new JLabel();
				getContentPane().add(labzhuce);
				labzhuce.setText("\u6ce8\u518c\u4fe1\u606f");
				labzhuce.setBounds(340, 56, 113, 59);
				labzhuce.setFont(new java.awt.Font("΢���ź�",1,26));
				labzhuce.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				labname = new JLabel();
				getContentPane().add(labname);
				labname.setText("\u7528\u6237\u59d3\u540d\uff1a");
				labname.setBounds(92, 178, 131, 63);
				labname.setFont(new java.awt.Font("΢���ź�",1,20));
				labname.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				labsex = new JLabel();
				getContentPane().add(labsex);
				labsex.setText("\u6027   \u522b\uff1a");
				labsex.setBounds(92, 279, 131, 63);
				labsex.setFont(new java.awt.Font("΢���ź�",1,20));
				labsex.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				labpassword = new JLabel();
				getContentPane().add(labpassword);
				labpassword.setText("\u767b\u5f55\u5bc6\u7801\uff1a");
				labpassword.setBounds(104, 487, 131, 63);
				labpassword.setFont(new java.awt.Font("΢���ź�",1,20));
				labpassword.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textname = new JTextField();
				getContentPane().add(textname);
				textname.setBounds(273, 194, 281, 24);
			}
			{
				jRadioButton1 = new JRadioButton();
				getContentPane().add(jRadioButton1);
				jRadioButton1.setText("\u7537");
				jRadioButton1.setBounds(273, 301, 54, 24);
				getSexGroup1().add(jRadioButton1);
			}
			{
				jRadioButton2 = new JRadioButton();
				getContentPane().add(jRadioButton2);
				jRadioButton2.setText("\u5973");
				jRadioButton2.setBounds(385, 301, 54, 24);
				getSexGroup1().add(jRadioButton2);
			}
			{
				labcardid = new JLabel();
				getContentPane().add(labcardid);
				labcardid.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
				labcardid.setBounds(104, 385, 131, 63);
				labcardid.setFont(new java.awt.Font("΢���ź�",1,20));
				labcardid.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				textcardid = new JTextField();
				getContentPane().add(textcardid);
				getContentPane().add(getButzhuce());
				getContentPane().add(getButcancel());
				getContentPane().add(getTextpassword());
				textcardid.setBounds(273, 406, 281, 24);
			}
			pack();
			this.setSize(861, 765);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getSexGroup1() {
		if(sexGroup1 == null) {
			sexGroup1 = new ButtonGroup();
		}
		return sexGroup1;
	}
	
	private JButton getButzhuce() {
		if(butzhuce == null) {
			butzhuce = new JButton();
			butzhuce.setText("\u6ce8\u518c");
			butzhuce.setBounds(161, 642, 95, 41);
			butzhuce.addActionListener(new ActionListener() {
				//����ע�ᰴť�¼�
				public void actionPerformed(ActionEvent evt) {
					String name=textname.getText();
					
					String sex = null;
					//�жϵ�ǰѡ�е����ĸ���ѡ��ť
					if(jRadioButton1.isSelected()){
						sex = jRadioButton1.getText();
					}else{
						sex = jRadioButton2.getText();
					}
					String num=getUniqueString();
					//������֤�ŵ�ֵ
					String cardId = textcardid.getText();
					//��������ֵ
					String password=textpassword.getText();
					//2.����userdao�������еĴ�����
					//����userdao��һ������
					userdao sdao=new userdao();
					//����õ����ݷ�װ��userdao������
					users us=new users();
					us.setUcnoid(num);
					us.setName(name);
					us.setSex(sex);
					us.setCardid(cardId);
					us.setpassword(password);
					int result=sdao.zhuce(us);
                     if(result>0){
						
						JOptionPane.showMessageDialog(zhuceFrame.this, "��ϲ��ע���й����С����Ŀ��ţ�"+num);
						zhuceFrame.this.dispose();//�ͷŵ�ǰ������ռ�õ���Դ
						cards use=new cards();
						use.setUcnoid(num);
						use.setYue("0");
						sdao.zhu(use);
						loginFrame login = new loginFrame();
						login.setVisible(true);
						zhuceFrame.this.dispose();
					}else{
						JOptionPane.showMessageDialog(zhuceFrame.this, "ע��ʧ��");
					}
					
					
					
					
				}
			});
		}
		return butzhuce;
	}
	
	private JButton getButcancel() {
		if(butcancel == null) {
			butcancel = new JButton();
			butcancel.setText("\u53d6\u6d88");
			butcancel.setBounds(525, 642, 95, 41);
			butcancel.addActionListener(new ActionListener() {
				//ȡ����ť�����¼�
				public void actionPerformed(ActionEvent evt) {
					int result=JOptionPane.showConfirmDialog(zhuceFrame.this, "ȷ��ȡ����", "ȷ����Ϣ", JOptionPane.YES_NO_OPTION);
					if(result==0){
						System.exit(0);
					}
				}
			});
		}
		return butcancel;
	}
	
	private JTextField getTextpassword() {
		if(textpassword == null) {
			textpassword = new JTextField();
			textpassword.setBounds(273, 510, 281, 24);
		}
		return textpassword;
	}


  
}
