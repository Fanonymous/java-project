package adminuser.action;

import org.apache.struts2.ServletActionContext;

import adminuser.service.AdminUserService;
import adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements
		ModelDriven<AdminUser> {
	// ģ������ʹ�õĶ���
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}

	// ע��AdminUserService
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	// ��̨��¼��ִ�еķ���
	public String login() {
		// ����service������ɵ�¼
		AdminUser existAdminUser = adminUserService.login(adminUser);
		// �ж�
		if (existAdminUser == null) {
			// �û������������
			this.addActionError("�û������������!");
			return "loginFail";
		} else {
			// ��¼�ɹ�:
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
}
