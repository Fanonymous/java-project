package com.legendary.chat;


import java.io.Serializable;

/**
 * <p>
 * Title: HappyChat����ϵͳ��¼����
 * </p>
 * <p>
 * Description: �������ݶ���
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Filename: Chat.java
 * </p>
 * 
 * @author *****
 * @version 1.0
 */
public class Chat implements Serializable
{

	private static final long serialVersionUID = 4058485121419391969L;
	/**
	 * �������û���
	 */
	public String  chatUser;
	/**
	 * ��������
	 */
	public String  chatMessage;
	/**
	 * ���ܶ����û���
	 */
	public String  chatToUser;
	/**
	 * ��������
	 */
	public String  emote;
	/**
	 * �Ƿ�˽��
	 */
	public boolean whisper;
}  