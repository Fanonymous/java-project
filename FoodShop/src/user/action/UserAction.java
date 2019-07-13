package user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import user.service.UserService;
import user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �û�ģ��Action���� 
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	// ģ������ʹ�õĶ���
	private User user = new User();

	public User getModel() {
		return user;
	}

	// ������֤��:
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	// ע��UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ��ת��ע��ҳ���ִ�з���
	 */
	public String registPage() {
		return "registPage";
	}

	/**
	 * У���û�����ִ�з���
	 * 
	 * @throws IOException
	 */
	public String findByName() throws IOException {
		// ����Service���в�ѯ:
		User existUser = userService.findByUsername(user.getUsername());
		// ���response����,��ҳ�����:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж�
		if (existUser != null) {
			// ��ѯ�����û�:�û����Ѿ�����
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		} else {
			// û��ѯ�����û�:�û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}

	/**
	 * �û�ע��ķ���:
	 */
	public String regist() {
		// �ж���֤�����:
		// ��session�л����֤������ֵ:
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if (!checkcode.equalsIgnoreCase(checkcode1)) {
			this.addActionError("��֤���������!");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�!���¼");
		//return "msg";
		return "loginPage";
	}

	/**
	 * ��ת����¼ҳ��
	 */
	public String loginPage() {
		return "loginPage";
	}

	/**
	 * ��¼�ķ���
	 */
	public String login() {
		User existUser = userService.login(user);
		// �ж�
		if (existUser == null) {
			// ��¼ʧ��
			this.addActionError("��¼ʧ��:�û������������!");
			return LOGIN;
		} else {
			// ��¼�ɹ�
			// ���û�����Ϣ���뵽session��
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			// ҳ����ת
			return "loginSuccess";
		}

	}

	/**
	 * �û��˳��ķ���
	 */
	public String quit() {
		// ����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}

}
